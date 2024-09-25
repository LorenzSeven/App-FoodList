package com.example.food_list_app.activity.utenteConsumer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.food_list_app.GlobalState;
import com.example.food_list_app.MenuNavBar;
import com.example.food_list_app.SearchBar;
import com.example.food_list_app.adapter.IngredientiRicettaArrayAdpter;
import com.example.food_list_app.api.SyncCall;
import com.example.food_list_app.api.WebCtrl;
import com.example.food_list_app.oggetti.Ingrediente;
import com.example.food_list_app.R;
import com.example.food_list_app.oggetti.Ricetta;
import com.example.food_list_app.oggetti.UtenteConsumer;

import java.util.ArrayList;

public class IngredientiRicettaActivity extends AppCompatActivity implements SyncCall {
    ListView listView = null;
    Button bottoneCarrello = null;
    ArrayList<Integer> ingredientiSalvati = new ArrayList<>();

    ArrayList<Ingrediente> listaIngredienti = new ArrayList<>();
    Ricetta ricetta = null;
    GlobalState globalState;

    public void handleAsync(Object obj) {
        ricetta = (Ricetta) obj;
        IngredientiRicettaArrayAdpter iaa = new IngredientiRicettaArrayAdpter(IngredientiRicettaActivity.this, R.layout.activity_ingredienti_ricetta, listaIngredienti = ricetta.getLista_ingredienti());
        listView.setAdapter(iaa);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredienti_ricetta);
        globalState = (GlobalState) getApplication();

        listView = findViewById(R.id.listViewIngred);
        bottoneCarrello = findViewById(R.id.Bottone_carrello);


        WebCtrl webCtrl = WebCtrl.getINSTACE(this);
        Bundle dati = getIntent().getExtras();
        if (dati != null) {
            int idRicetta = dati.getInt("id_ricetta");
            webCtrl.getRicetta(idRicetta);
        } else
            Log.v("IngredRicetActivity", "idRicetta --> null");

        bottoneCarrello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IngredientiRicettaActivity.this, HomeActivity.class);
                startActivity(intent);

                //Salvo gli ingredienti scelti e li invio al Database
                for (Ingrediente ingrediente : listaIngredienti) {
                    if (ingrediente.getIsChecked())
                        ingredientiSalvati.add(ingrediente.getId());
                }


                UtenteConsumer utenteConsumer = globalState.getUtente();
                webCtrl.salvaInCarrello(utenteConsumer.getId(), ingredientiSalvati);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        gestioneTopBottomBar(R.id.itemHome); //listener bar menu e search
    }


    private void gestioneTopBottomBar(int itemSelected) {

        new MenuNavBar(this, findViewById(R.id.bottomNavigationView), itemSelected, this);//l'icona che si illumina + activity


        new SearchBar(this, this, findViewById(R.id.editTextSearchBar), findViewById(R.id.imageButtonBack)); // all'itenro del costruttore parte gestioneListenerTopBar();
    }


}


