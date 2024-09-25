package com.example.food_list_app.activity.utenteConsumer;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.food_list_app.GlobalState;
import com.example.food_list_app.MenuNavBar;
import com.example.food_list_app.R;
import com.example.food_list_app.SearchBar;
import com.example.food_list_app.adapter.CarrelloArrayAdpter;
import com.example.food_list_app.api.SyncCall;
import com.example.food_list_app.api.WebCtrl;
import com.example.food_list_app.oggetti.Ingrediente;
import com.example.food_list_app.oggetti.UtenteConsumer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarrelloActivity extends AppCompatActivity implements SyncCall {

    ListView listView_carrello = null;

    CarrelloArrayAdpter listaCarrello;

    ArrayList<Ingrediente> arrayCarrello = new ArrayList<>();


    EditText editTextIndirizzo;
    ToggleButton tggbtn5km, tggbtn10km, tggbtn15km;
    Button btnCercaNegozio;
    WebCtrl webCtrl;
    GlobalState globalState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrello);
        //Rest
        webCtrl = WebCtrl.getINSTACE(this);
        globalState = (GlobalState) getApplication();

        //editTextIndirizzo = findViewById(R.id.editTextIndirizzoUtenteCarrello);
        listView_carrello = findViewById(R.id.listViewCar);

        tggbtn5km = findViewById(R.id.toggleBtn5km);
        tggbtn10km = findViewById(R.id.toggleBtn10km);
        tggbtn15km = findViewById(R.id.toggleBtn15km);

        editTextIndirizzo = findViewById(R.id.editTextIndirizzoUtenteCarrello);

        btnCercaNegozio = findViewById(R.id.btnCercaNegozio);


        btnCercaNegozio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Ingrediente ingrediente : arrayCarrello) {
                    if (!ingrediente.getIsChecked()) {

                        UtenteConsumer utenteConsumer = globalState.getUtente();

                        webCtrl.eliminaDaCarrello(utenteConsumer.getId(), ingrediente.getId());
                    }
                }

                if (editTextIndirizzo.getText().toString().isEmpty()) {
                    Toast.makeText(CarrelloActivity.this, "Inserire indirizzo!!", Toast.LENGTH_LONG).show();
                    return;
                }

                String indirizzoUtente = editTextIndirizzo.getText().toString();
                double[] coordinateLatLong = geoCoder(indirizzoUtente);
                if (coordinateLatLong[0] == 0 && coordinateLatLong[1] == 0) {
                    Toast.makeText(CarrelloActivity.this, "l'indirizzo non esiste !!", Toast.LENGTH_LONG).show();
                    return;
                }

                double distanzaMax = controlloToggleDistanza();


                Intent goToCercaNegozi = new Intent(CarrelloActivity.this, CercaNegozioActivity.class);

                goToCercaNegozi.putExtra("distanzaMax", distanzaMax);
                goToCercaNegozi.putExtra("latitudineUtente", coordinateLatLong[0]);
                goToCercaNegozi.putExtra("longitudineUtente", coordinateLatLong[1]);

                startActivity(goToCercaNegozi);
            }
        });

    }


    @Override
    protected void onResume() {
        super.onResume();
        gestioneTopBottomBar(R.id.itemCarrello); //listener bar menu e search

        UtenteConsumer utenteConsumer = globalState.getUtente();
        webCtrl.getCarrello(utenteConsumer.getId());


    }

    @Override
    public void handleAsync(Object obj) {
        if (obj instanceof ArrayList) {
            if (((ArrayList<?>) obj).size() > 0 && ((ArrayList<?>) obj).get(0) instanceof Ingrediente) {
                arrayCarrello = (ArrayList<Ingrediente>) obj;
                for (Ingrediente ingrediente : arrayCarrello)
                    ingrediente.setIsChecked(true);
                listaCarrello = new CarrelloArrayAdpter(CarrelloActivity.this, R.layout.activity_carrello, arrayCarrello);
                listView_carrello.setAdapter(listaCarrello);
            }
        }
    }

    private double[] geoCoder(String indirizzo) {
        double[] coordinate = new double[2];
        Geocoder geocoder = new Geocoder(this);
        List<Address> addresses = null;
        try {
            addresses = geocoder.getFromLocationName(indirizzo, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (addresses != null && !addresses.isEmpty()) {
            Address address = addresses.get(0);
            coordinate[0] = address.getLatitude();
            coordinate[1] = address.getLongitude();
        }

        return coordinate;
    }

    private void gestioneTopBottomBar(int itemSelected) {
        new MenuNavBar(this, findViewById(R.id.bottomNavigationView), itemSelected, this);//l'icona che si illumina

        new SearchBar(this, this, findViewById(R.id.editTextSearchBar), findViewById(R.id.imageButtonBack)); // all'itenro del costruttore parte gestioneListenerTopBar();

        //listner editText inserisci indirizzo
        new SearchBar(this, this, findViewById(R.id.editTextIndirizzoUtenteCarrello));
    }

    private double controlloToggleDistanza() {
        double distanzaMax = 0;
        if (tggbtn5km.isChecked())
            distanzaMax = 5;
        if (tggbtn10km.isChecked())
            distanzaMax = 10;
        if (tggbtn15km.isChecked())
            distanzaMax = 15;

        return distanzaMax;
    }

}

