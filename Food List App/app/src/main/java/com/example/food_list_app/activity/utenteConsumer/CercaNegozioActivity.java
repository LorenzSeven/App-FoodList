package com.example.food_list_app.activity.utenteConsumer;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.food_list_app.GlobalState;
import com.example.food_list_app.MenuNavBar;
import com.example.food_list_app.R;
import com.example.food_list_app.SearchBar;
import com.example.food_list_app.adapter.NegoziXConsumerArrayAdapter;
import com.example.food_list_app.api.SyncCall;
import com.example.food_list_app.api.WebCtrl;
import com.example.food_list_app.oggetti.Ingrediente;
import com.example.food_list_app.oggetti.Negozio;
import com.example.food_list_app.oggetti.UtenteConsumer;

import java.util.ArrayList;

public class CercaNegozioActivity extends AppCompatActivity implements SyncCall {

    WebCtrl webCtrl;
    ListView listaNegozi;
    GlobalState globalState;

    double latitudineUtente = 0.0, longitudineUtente = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cerca_negozi);

        listaNegozi = findViewById(R.id.lista_negozi_ListView);


        webCtrl = WebCtrl.getINSTACE(this);
         globalState = (GlobalState) getApplication();

        //Location Mangaer


    }

    @Override
    protected void onStart() {
        super.onStart();

    }


    @Override
    protected void onResume() {
        super.onResume();
        gestioneTopBottomBar(R.id.itemCarrello); //listener bar menu e search

        Bundle datiCarrello = getIntent().getExtras();
        if (datiCarrello != null) {

            double distanzaMax = datiCarrello.getDouble("distanzaMax");
            latitudineUtente = datiCarrello.getDouble("latitudineUtente");
            longitudineUtente = datiCarrello.getDouble("longitudineUtente");

            globalState = (GlobalState) getApplication();
            UtenteConsumer utenteConsumer = globalState.getUtente();
            webCtrl.getCercaNegoziDistanzaOrdinati(utenteConsumer.getId(), latitudineUtente, longitudineUtente, distanzaMax);

        }
    }

    ArrayList<Negozio> negoziDB;

    @Override
    public void handleAsync(Object obj) {


        if (obj instanceof ArrayList && ((ArrayList<?>) obj).get(0) instanceof Negozio) {
            globalState = (GlobalState) getApplication();
            UtenteConsumer utenteConsumer = globalState.getUtente();
            webCtrl.getCarrello(utenteConsumer.getId());


            negoziDB = (ArrayList<Negozio>) obj;


            if (negoziDB.size() == 0) {
                Toast.makeText(this, "Non ci sono negozi nelle tue vicinanze ", Toast.LENGTH_LONG).show();
            }

        }

        if (obj instanceof ArrayList && ((ArrayList<?>) obj).get(0) instanceof Ingrediente) {
            ArrayList<Ingrediente> listaCarrello = (ArrayList<Ingrediente>) obj;
            int totaleIngredieniUtente = listaCarrello.size();

            NegoziXConsumerArrayAdapter paa = new NegoziXConsumerArrayAdapter(CercaNegozioActivity.this, R.layout.lista_item_negozio_consumer, negoziDB, totaleIngredieniUtente);
            listaNegozi.setAdapter(paa);
        }

    }

    private void gestioneTopBottomBar(int itemSelected) {

        new MenuNavBar(this, findViewById(R.id.bottomNavigationView), itemSelected, this);//l'icona che si illumina + activity


        new SearchBar(this, this, findViewById(R.id.editTextSearchBar), findViewById(R.id.imageButtonBack)); // all'itenro del costruttore parte gestioneListenerTopBar();
    }


}




