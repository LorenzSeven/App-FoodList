package com.example.food_list_app.activity.utenteConsumer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.food_list_app.MenuNavBar;
import com.example.food_list_app.R;
import com.example.food_list_app.SearchBar;
import com.example.food_list_app.adapter.RicetteArrayAdapter;
import com.example.food_list_app.api.SyncCall;
import com.example.food_list_app.api.WebCtrl;
import com.example.food_list_app.oggetti.Ricetta;

import java.util.ArrayList;

public class ListaRicetteActivity extends AppCompatActivity implements SyncCall {
    ListView listaViewRicette = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_preferiti_ricette);

        WebCtrl webCtrl1 = WebCtrl.getINSTACE(this);  //Web Controller

        listaViewRicette = findViewById(R.id.listaGenerica);
        TextView titolo = findViewById(R.id.titoloPag);
        titolo.setText("Risultati di Ricerca:");


        Bundle data = getIntent().getExtras();  //putExra dalla Home o barra di ricerca
        if (data != null) {
            String scelta = data.getString("scelta");
            String from = data.getString("from");

            if (from.equals("home")) {//home tipi portate
                webCtrl1.getRicetteTipo(scelta);
            } else if (from.equals("search")) {//barra di ricerca
                webCtrl1.getRicetteNome(scelta);
            }

        } else
            Log.d("ListaRicetteActivity", "Nessuno scelta");


        titolo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListaRicetteActivity.this, ListaPreferitiActivity.class);
                startActivity(intent);
            }
        });


        listaViewRicette.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Ricetta r = (Ricetta) listaViewRicette.getItemAtPosition(position);
                Intent intent = new Intent(ListaRicetteActivity.this, DescrizionePiattoActivity.class);
                intent.putExtra("id", r.getId());
                startActivity(intent);
            }
        });

    }

    @Override
    public void handleAsync(Object obj) {
        if (obj instanceof ArrayList) {
            ArrayList<Ricetta> tempList = (ArrayList<Ricetta>) obj;
            aggiungiArrayAdapter(tempList);
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        gestioneTopBottomBar(R.id.itemHome); //listener bar menu e search
    }

    private void aggiungiArrayAdapter(ArrayList<Ricetta> listaDB) {
        RicetteArrayAdapter listaAdapterRicette = new RicetteArrayAdapter(this, R.layout.lista_item_piatto, listaDB);
        listaViewRicette.setAdapter(listaAdapterRicette);

    }

    private void gestioneTopBottomBar(int itemSelected) {
        new MenuNavBar(this, findViewById(R.id.bottomNavigationView), itemSelected,this);//l'icona che si illumina

        new SearchBar(this, this, findViewById(R.id.editTextSearchBar), findViewById(R.id.imageButtonBack)); // all'itenro del costruttore parte gestioneListenerTopBar();
    }


}

