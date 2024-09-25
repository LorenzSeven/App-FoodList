package com.example.food_list_app.activity.utenteConsumer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.food_list_app.MenuNavBar;
import com.example.food_list_app.R;
import com.example.food_list_app.SearchBar;


public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton imgBtnprimi, imgBtnSecondi, imgBtnDolci, imgBtnContorni;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        inizializzazioneGUI();



    }

    @Override
    protected void onResume() {
        super.onResume();
        gestioneTopBottomBar(R.id.itemHome); //listener bar menu e search
    }

    @SuppressLint("NonConstantResourceId") //per eliminare il warning "non consigliato switch
    @Override //Categorie Portate
    public void onClick(View v) {
        Intent intent = new Intent(this, ListaRicetteActivity.class);
        String key = "scelta";
        switch (v.getId()) {
            case R.id.ImageButtonPrimi:
                intent.putExtra(key, "Primo");
                break;
            case R.id.ImageButtonSecondi:
                intent.putExtra(key, "Secondo");
                break;
            case R.id.ImageButtonDolci:
                intent.putExtra(key, "Dolce");
                break;
            case R.id.ImageButtonContorni:
                intent.putExtra(key, "Contorno");
                break;
        }

        intent.putExtra("from", "home");
        startActivity(intent);


    }

    private void inizializzazioneGUI() {
        //categorie portate
        imgBtnprimi = findViewById(R.id.ImageButtonPrimi);
        imgBtnSecondi = findViewById(R.id.ImageButtonSecondi);
        imgBtnDolci = findViewById(R.id.ImageButtonDolci);
        imgBtnContorni = findViewById(R.id.ImageButtonContorni);

        imgBtnprimi.setOnClickListener(this);
        imgBtnSecondi.setOnClickListener(this);
        imgBtnDolci.setOnClickListener(this);
        imgBtnContorni.setOnClickListener(this);

    }

    private void gestioneTopBottomBar(int itemSelected) {


        new MenuNavBar(this, findViewById(R.id.bottomNavigationView), itemSelected, this);//l'icona che si illumina + activity


        new SearchBar(this, this, findViewById(R.id.editTextSearchBar), findViewById(R.id.imageButtonBack)); // all'itenro del costruttore parte gestioneListenerTopBar();
    }
    //barra di ricerca long
        /*editTextSearchBar = findViewById(R.id.editTextSearchBar);
        imgBtnBack = findViewById(R.id.imageButtonBack);
        SearchBar searchBar = new SearchBar(this, editTextSearchBar, imgBtnBack);
        searchBar.gestioneListenerTopBar(); */

}