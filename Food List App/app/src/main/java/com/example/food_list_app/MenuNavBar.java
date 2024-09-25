package com.example.food_list_app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.example.food_list_app.activity.utenteAzienda.AggiungiIngredientiNegozioActivity;
import com.example.food_list_app.activity.utenteConsumer.LoginActivity;
import com.example.food_list_app.activity.utenteAzienda.AggiungiSedeActivity;
import com.example.food_list_app.activity.utenteAzienda.HomeAziendaActivity;
import com.example.food_list_app.activity.utenteAzienda.ProfiloAziendaActivity;
import com.example.food_list_app.activity.utenteAzienda.RegistrazioneAziendaActivity;
import com.example.food_list_app.activity.utenteAzienda.VisualizzaIngredientiNegozioActivity;
import com.example.food_list_app.activity.utenteConsumer.CarrelloActivity;
import com.example.food_list_app.activity.utenteConsumer.HomeActivity;
import com.example.food_list_app.activity.utenteConsumer.ListaPreferitiActivity;
import com.example.food_list_app.activity.utenteConsumer.ProfiloUtenteActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MenuNavBar implements NavigationBarView.OnItemSelectedListener {
    private final Context context;
    private Activity activity = null;


    public MenuNavBar(Context context, BottomNavigationView btmNavItem, int itemSelected, Activity activity) {
        this.context = context;
        this.activity = activity;

        // barra di navigazione
        btmNavItem.setOnItemSelectedListener(this);


        btmNavItem.getMenu().findItem(itemSelected).setChecked(true);

    }


    @SuppressLint("NonConstantResourceId") //per eliminare il warning "non consigliato lo swtich
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) { // bottoni barra di naviagazione

        int id = item.getItemId();
        Intent intent = null;

        if (isActivityUtente())
            switch (id) {
                case R.id.itemHome:
                    if (!(activity instanceof HomeActivity)) //per evitare che si attiva nella stessa acitivty
                        intent = new Intent(context, HomeActivity.class);
                    break;
                case R.id.itemProfilo:
                    if (!(activity instanceof LoginActivity))
                        intent = new Intent(context, ProfiloUtenteActivity.class);
                    break;
                case R.id.itemCarrello:
                    if (!(activity instanceof CarrelloActivity))
                        intent = new Intent(context, CarrelloActivity.class);
                    break;
                case R.id.itemPreferiti:
                    if (!(activity instanceof ListaPreferitiActivity))
                        intent = new Intent(context, ListaPreferitiActivity.class);
                    break;
            }
        else
            switch (id) {
                case R.id.itemNegozi:
                    if (!(activity instanceof HomeAziendaActivity))
                        intent = new Intent(context, HomeAziendaActivity.class);
                    break;
                case R.id.itemProfilo:
                    if (!(activity instanceof ProfiloAziendaActivity))
                        intent = new Intent(context, ProfiloAziendaActivity.class);
                    break;
            }

        if (intent != null) {
            context.startActivity(intent);
            return true;
        }
        return false;
    }


    private boolean isActivityUtente() {
        return !(activity instanceof AggiungiSedeActivity || activity instanceof HomeAziendaActivity || activity instanceof ProfiloAziendaActivity || activity instanceof RegistrazioneAziendaActivity || activity instanceof VisualizzaIngredientiNegozioActivity || activity instanceof AggiungiIngredientiNegozioActivity);
    }


}
