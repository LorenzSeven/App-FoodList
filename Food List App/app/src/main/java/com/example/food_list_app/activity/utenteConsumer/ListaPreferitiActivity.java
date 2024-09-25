package com.example.food_list_app.activity.utenteConsumer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.food_list_app.GlobalState;
import com.example.food_list_app.MenuNavBar;
import com.example.food_list_app.R;
import com.example.food_list_app.SearchBar;
import com.example.food_list_app.api.SyncCall;
import com.example.food_list_app.api.WebCtrl;
import com.example.food_list_app.oggetti.Ricetta;
import com.example.food_list_app.adapter.RicetteArrayAdapter;
import com.example.food_list_app.oggetti.UtenteConsumer;

import java.util.ArrayList;

public class ListaPreferitiActivity extends AppCompatActivity implements SyncCall {


    ListView listaPreferiti = null;

    ArrayList<Ricetta> elementiPreferiti = new ArrayList<>();
    RicetteArrayAdapter paa = null;

    WebCtrl webCtrl;
    GlobalState globalState;
    @Override
    public void handleAsync(Object obj) {
        elementiPreferiti = (ArrayList<Ricetta>) obj;
        paa = new RicetteArrayAdapter(this, R.layout.lista_item_piatto, elementiPreferiti);
        listaPreferiti.setAdapter(paa);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_preferiti_ricette);
        globalState = (GlobalState) getApplication();

        webCtrl = WebCtrl.getINSTACE(this);

        listaPreferiti = findViewById(R.id.listaGenerica);
        TextView titolo = findViewById(R.id.titoloPag);
        titolo.setText("Elenco Ricette Preferite");





        //Cancella ricetta preferita
        listaPreferiti.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder adb = new AlertDialog.Builder(ListaPreferitiActivity.this);
                adb.setTitle("Eliminare la ricetta?");
                adb.setMessage("Vuoi davvero eliminare questa ricetta?");
                final int positionToRemove = position;
                adb.setNegativeButton("No", null);
                adb.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        UtenteConsumer utenteConsumer = globalState.getUtente();
                        webCtrl.deletePreferito(utenteConsumer.getId(), paa.getItem(positionToRemove).getId());
                        elementiPreferiti.remove(positionToRemove);
                        paa.notifyDataSetChanged();
                    }
                });
                adb.show();
                return true;
            }
        });

        listaPreferiti.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Ricetta r = (Ricetta) listaPreferiti.getItemAtPosition(position);
                Intent goToNegozio = new Intent(ListaPreferitiActivity.this, DescrizionePiattoActivity.class);
                goToNegozio.putExtra("id", r.getId());
                startActivity(goToNegozio);
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        gestioneTopBottomBar(R.id.itemPreferiti); //listener bar menu e search

        GlobalState globalState = (GlobalState) getApplication();
        UtenteConsumer utenteConsumer = globalState.getUtente();
        webCtrl.getRicettePreferiti(utenteConsumer.getId());
    }

    private void gestioneTopBottomBar(int itemSelected) {

        new MenuNavBar(this, findViewById(R.id.bottomNavigationView), itemSelected, this);//l'icona che si illumina + activity


        new SearchBar(this, this, findViewById(R.id.editTextSearchBar), findViewById(R.id.imageButtonBack)); // all'itenro del costruttore parte gestioneListenerTopBar();
    }
}