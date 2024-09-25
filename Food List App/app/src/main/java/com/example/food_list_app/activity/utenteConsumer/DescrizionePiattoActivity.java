package com.example.food_list_app.activity.utenteConsumer;

import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.food_list_app.GlobalState;
import com.example.food_list_app.MenuNavBar;
import com.example.food_list_app.R;
import com.example.food_list_app.SearchBar;
import com.example.food_list_app.adapter.IngredientiDescrizionePiattoArrayAdapter;
import com.example.food_list_app.api.SyncCall;
import com.example.food_list_app.api.WebCtrl;
import com.example.food_list_app.oggetti.Ingrediente;
import com.example.food_list_app.oggetti.Ricetta;
import com.example.food_list_app.oggetti.UtenteConsumer;

import java.util.ArrayList;

public class DescrizionePiattoActivity extends AppCompatActivity implements SyncCall {
    ListView list_view_ingredienti = null;
    ArrayList<Ingrediente> listaingredienti = new ArrayList<>();
    int id_ricetta = 0;
    String nome = "";
    String tipo = "";
    String nazionalità = "";
    String tempo = "";
    String difficoltà = "";
    String descrizione = "";
    String immagine = "";


    TextView nomericetta = null;
    ImageView immaginericetta = null;
    TextView tiporicetta = null;
    TextView nazionalitàricetta = null;
    TextView temporicetta = null;
    TextView difficoltàricetta = null;
    TextView descrizionericetta = null;

    Button pulsante_aggiungi_al_carrello = null;
    Button pulsante_aggiungi_ai_preferiti = null;

    GlobalState globalState;
    @Override
    public void handleAsync(Object obj) {
        if (obj instanceof Ricetta) {
            Ricetta r = (Ricetta) obj;
            nome = r.getNome();
            tipo = r.getTipo();
            nazionalità = r.getNazionalità();
            tempo = r.getTempo_preparazione();
            difficoltà = r.getDifficoltà();
            descrizione = r.getDescrizione();
            immagine = r.getImmagine();

            nomericetta = findViewById(R.id.textview_nome_ricetta);
            immaginericetta = findViewById(R.id.imageview_foto_ricetta);
            tiporicetta = findViewById(R.id.textview_tipo_piatto);
            nazionalitàricetta = findViewById(R.id.textview_nazionalità);
            temporicetta = findViewById(R.id.textview_tempo_preparazione);
            difficoltàricetta = findViewById(R.id.textview_difficoltà);
            descrizionericetta = findViewById(R.id.descrizione);

            String nuova_descrizione = converti_descrizione_in_android(descrizione);
            int numero_ricette = contaStepRicetta(nuova_descrizione); //conta gli step ricetta
            if (numero_ricette > 0) {
                SpannableStringBuilder descrizione_size_aumentato = setSectionOfTextSize(nuova_descrizione, paroleDaIngrandire(numero_ricette), 19);
                descrizionericetta.setText(descrizione_size_aumentato);

            } else {
                Log.w("DescrizPiattoActivit", "numero ricette 0");
                descrizionericetta.setText(descrizione);
            }
            nomericetta.setText(nome);
            tiporicetta.setText(tipo);
            nazionalitàricetta.setText(nazionalità);
            temporicetta.setText(tempo);
            difficoltàricetta.setText(difficoltà);
            Glide.with(this).load(immagine).into(immaginericetta);
        }
        if (obj instanceof ArrayList) {
            listaingredienti = (ArrayList<Ingrediente>) obj;
            IngredientiDescrizionePiattoArrayAdapter iaa = new IngredientiDescrizionePiattoArrayAdapter(this, R.layout.lista_item_ingredienti_descrizione_piatto, listaingredienti);
            list_view_ingredienti.setAdapter(iaa);
            setListViewHeightBasedOnChildren(list_view_ingredienti);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descrizione_piatto);
        globalState = (GlobalState)getApplicationContext();

        list_view_ingredienti = findViewById(R.id.listview_ingredienti);
        pulsante_aggiungi_al_carrello = findViewById(R.id.button_aggiungi_al_carrello);
        pulsante_aggiungi_ai_preferiti = findViewById(R.id.button_aggiungi_ai_preferiti);

        Bundle ricettabundle = getIntent().getExtras();
        if (ricettabundle != null) { // dall'actvity Home o R
            id_ricetta = ricettabundle.getInt("id");
        } else {
            Log.d("ListaRicetteActivity", "Nessuno scelta");
        }

        //Web Controller
        WebCtrl webCtrl = WebCtrl.getINSTACE(this);

        webCtrl.getIngredientiDaRicetta(id_ricetta);
        webCtrl.prendiRicetta(id_ricetta);

        pulsante_aggiungi_ai_preferiti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UtenteConsumer utenteConsumer = globalState.getUtente();
                webCtrl.postRicettaInPreferiti(utenteConsumer.getId(), id_ricetta);
                Toast.makeText(DescrizionePiattoActivity.this, "Aggiunta Ricetta ai preferiti", Toast.LENGTH_LONG).show();
            }
        });
        pulsante_aggiungi_al_carrello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent vaiASceltaIngr = new Intent(DescrizionePiattoActivity.this, IngredientiRicettaActivity.class);
                vaiASceltaIngr.putExtra("id_ricetta", id_ricetta);
                startActivity(vaiASceltaIngr);
            }
        });

    }

    //metodo per convertire la descrizione dal database in android
    public static String converti_descrizione_in_android(String testo) {
        String testo_nuovo = "";
        String testo_nuovo2 = "";
        String testo_nuovo3 = "";

        for (int i = 0; i < testo.length(); i++) {
            String lettera = testo.substring(i, i + 1);
            if (lettera.equals("(")) {
                testo_nuovo = testo.replace("(", "");
            }
            if (lettera.equals(")")) {
                testo_nuovo2 = testo_nuovo.replace(")", "");
            }
            if (lettera.equals("|")) {
                testo_nuovo3 = testo_nuovo2.replace("|", "\n");
            }
        }
        return testo_nuovo3;
    }

    //metodo per contare gli step della ricetta
    public static int contaStepRicetta(String testo) {
        String[] parole = {"Step 1", "Step 2", "Step 3", "Step 4", "Step 5", "Step 6", "Step 7", "Step 8", "Step 9", "Step 10"};
        int totaleStep = 0;
        for (int i = 0; i < parole.length; i++) {
            boolean trovato = testo.contains(parole[i]);
            if (trovato == true) {
                totaleStep += 1;
            }
        }
        return totaleStep;
    }

    //metodo per ottenere l'array delle parole che devono essere ingrandite
    public String[] paroleDaIngrandire(int totaleStepRicetta) {
        //gli elementi sono 13 e vanno da 0 a 12
        String[] testi_da_cambiare = new String[totaleStepRicetta + 3]; //+3 per la "Preparazione", "Conservazione", "Intolleranze"
        testi_da_cambiare[0] = "Preparazione";
        for (int i = 1; i < totaleStepRicetta + 1; i++) {
            testi_da_cambiare[i] = "Step " + i;
        }
        testi_da_cambiare[testi_da_cambiare.length - 2] = "Conservazione";
        testi_da_cambiare[testi_da_cambiare.length - 1] = "Intolleranze";
        return testi_da_cambiare;
    }

    //metodo per modificare la grandezza delle parole
    public static SpannableStringBuilder setSectionOfTextSize(String text, String[] textToChangeSize, int size) {
        SpannableStringBuilder builder = new SpannableStringBuilder();

        for (int i = 0; i < textToChangeSize.length; i++) {
            String testText = text.toLowerCase();  //converti il testo in lower case
            String testTextToBold = textToChangeSize[i].toLowerCase(); //converti il testo in lower case
            int startingIndex = testText.indexOf(testTextToBold);  //indice di inizio
            int endingIndex = startingIndex + testTextToBold.length(); // indice di fine

            if (i == 0) {
                builder.append(text);
            }
            builder.setSpan(new AbsoluteSizeSpan(size, true), startingIndex, endingIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return builder;
    }

    //metodo per far vedere tutte le righe di una ListView dentro uno ScrollView
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null)
            return;

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, view, listView);
            if (i == 0)
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth, LinearLayout.LayoutParams.WRAP_CONTENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
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