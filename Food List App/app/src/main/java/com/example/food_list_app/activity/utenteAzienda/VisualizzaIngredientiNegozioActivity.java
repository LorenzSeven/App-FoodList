package com.example.food_list_app.activity.utenteAzienda;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.food_list_app.MenuNavBar;
import com.example.food_list_app.R;
import com.example.food_list_app.adapter.IngredientiNegozioArrayAdapter;
import com.example.food_list_app.api.SyncCall;
import com.example.food_list_app.api.WebCtrl;
import com.example.food_list_app.oggetti.Ingrediente;
import com.example.food_list_app.oggetti.Negozio;

import java.util.ArrayList;

public class VisualizzaIngredientiNegozioActivity extends AppCompatActivity implements SyncCall {

    TextView nome = null;

    TextView orari = null;
    TextView indirizzo = null;
    ListView Listview_Ingr = null;
    ImageView imgViewNegozio = null;
    ArrayList<Ingrediente> ArrayList_Ingredienti = new ArrayList<>();

    IngredientiNegozioArrayAdapter ListaIngredienti;

    Button bottone_Aggiungi = null;
    int idNegozio = 0;
    WebCtrl webCtrl;

    @Override
    public void handleAsync(Object obj) {

        if (!(obj instanceof Negozio)) return;

        Negozio negozioSelez = (Negozio) obj;
        ArrayList_Ingredienti = negozioSelez.getIngNegozio();
        nome.setText(negozioSelez.getNome());
        orari.setText(negozioSelez.getOrari());
        indirizzo.setText(negozioSelez.getIndirizzo());


        Glide.with(this).load(negozioSelez.getImmagineNegozio()).into(imgViewNegozio);

        ListaIngredienti = new IngredientiNegozioArrayAdapter(VisualizzaIngredientiNegozioActivity.this, R.layout.lista_item_ingrediente_negozio, ArrayList_Ingredienti);
        Listview_Ingr.setAdapter(ListaIngredienti);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizza_ingredienti_negozio);
        bottone_Aggiungi = findViewById(R.id.btnAggiungiIngredienti);


        Listview_Ingr = findViewById(R.id.Listview_Ingredienti);

        nome = findViewById(R.id.TextViewNomeNegozio);
        orari = findViewById(R.id.TextViewOre);
        indirizzo = findViewById(R.id.TextViewIndirizzo);
        imgViewNegozio = findViewById(R.id.imageview_foto_ricetta);

        webCtrl = WebCtrl.getINSTACE(this);


        bottone_Aggiungi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VisualizzaIngredientiNegozioActivity.this, AggiungiIngredientiNegozioActivity.class);
                intent.putExtra("id negozio", idNegozio);
                startActivity(intent);
            }
        });

        Listview_Ingr.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder adb = new AlertDialog.Builder(VisualizzaIngredientiNegozioActivity.this);
                adb.setTitle("Eliminare questo ingrediente?");
                adb.setMessage("Vuoi davvero eliminare questo ingrediente?");
                final int positionToRemove = position;
                adb.setNegativeButton("No", null);
                adb.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        webCtrl.delIngredienteNegozio(ListaIngredienti.getItem(positionToRemove).getId(), idNegozio);
                        ArrayList_Ingredienti.remove(positionToRemove);
                        ListaIngredienti.notifyDataSetChanged();
                    }
                });
                adb.show();
                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        gestioneBarMenuNavigazione(R.id.itemNegozi);//listener bar menu azienda

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            idNegozio = bundle.getInt("id negozio");
            webCtrl.getNegozio(idNegozio);
        } else Toast.makeText(this, "getIntent ID negozio == null", Toast.LENGTH_SHORT).show();

    }

    private void gestioneBarMenuNavigazione(int itemSelected) {
        new MenuNavBar(this, findViewById(R.id.bottomNavigationView), itemSelected, this);//l'icona che si illumina + activity

    }
}