package com.example.food_list_app.activity.utenteAzienda;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.food_list_app.GlobalState;
import com.example.food_list_app.MenuNavBar;
import com.example.food_list_app.adapter.NegoziArrayAdapter;
import com.example.food_list_app.api.SyncCall;
import com.example.food_list_app.api.WebCtrl;
import com.example.food_list_app.oggetti.UtenteAzienda;
import com.example.food_list_app.oggetti.Negozio;
import com.example.food_list_app.R;

import java.util.ArrayList;

public class HomeAziendaActivity extends AppCompatActivity implements SyncCall {

    ListView listaNegozi = null;
    ArrayList<Negozio> arrayNegozi = null;
    NegoziArrayAdapter paa = null;
    WebCtrl webCtrl;
    Button btnAggiungiNegozio;
    GlobalState globalState;
    @Override
    public void handleAsync(Object obj) {

        if (obj instanceof ArrayList && ((ArrayList<?>) obj).get(0) instanceof Negozio) {
            arrayNegozi = (ArrayList<Negozio>) obj;
            paa = new NegoziArrayAdapter(HomeAziendaActivity.this, R.layout.activity_home_azienda, arrayNegozi);
            listaNegozi.setAdapter(paa);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_azienda);


        listaNegozi = findViewById(R.id.listaNegoziAzienda);
        TextView titolo = findViewById(R.id.titoloPag);
        titolo.setText("Lista dei punti vendita:");


        webCtrl = WebCtrl.getINSTACE(this);
        globalState = (GlobalState) getApplicationContext();
        btnAggiungiNegozio = findViewById(R.id.btnAggiungiNegozio);

        listaNegozi.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder adb = new AlertDialog.Builder(HomeAziendaActivity.this);
                adb.setTitle("Eliminare il negozio?");
                adb.setMessage("Vuoi davvero eliminare questo negozio?");
                final int positionToRemove = position;
                adb.setNegativeButton("No", null);
                adb.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        webCtrl.delNegozio(paa.getItem(positionToRemove).getId());
                        arrayNegozi.remove(positionToRemove);
                        paa.notifyDataSetChanged();
                    }
                });
                adb.show();
                return true;
            }
        });
        listaNegozi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent goToNegozio = new Intent(HomeAziendaActivity.this, VisualizzaIngredientiNegozioActivity.class);
                goToNegozio.putExtra("id negozio", paa.getItem(position).getId());
                startActivity(goToNegozio);
            }
        });




        btnAggiungiNegozio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeAziendaActivity.this, AggiungiSedeActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        gestioneBarMenuNavigazione(R.id.itemNegozi);//listener bar menu azienda


        UtenteAzienda utenteAzienda = globalState.getAzienda();

        webCtrl.getNegoziAz(utenteAzienda.getId());
    }

    private void gestioneBarMenuNavigazione(int itemSelected) {

        new MenuNavBar(this, findViewById(R.id.bottomNavigationView), itemSelected, this);//l'icona che si illumina + activity

    }

}



