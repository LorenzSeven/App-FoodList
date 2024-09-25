package com.example.food_list_app.activity.utenteAzienda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.food_list_app.GlobalState;
import com.example.food_list_app.MenuNavBar;
import com.example.food_list_app.R;
import com.example.food_list_app.api.SyncCall;
import com.example.food_list_app.api.WebCtrl;
import com.example.food_list_app.oggetti.UtenteAzienda;
import com.example.food_list_app.oggetti.Negozio;

import java.io.IOException;
import java.util.List;

public class AggiungiSedeActivity extends AppCompatActivity implements SyncCall {
    EditText editTextNome, editTextIndirizzo, editTextLunSab, editTextDom;
    Button btnAggiungiNegozio;
    WebCtrl webCtrl;
    GlobalState globalState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aggiungi_sede);

        webCtrl = WebCtrl.getINSTACE(this);
        globalState = (GlobalState) getApplicationContext();
        btnAggiungiNegozio = findViewById(R.id.btnAggiungiNegozio);

        editTextNome = findViewById(R.id.edittextNomeSede);
        editTextIndirizzo = findViewById(R.id.editTextIndirizzoNegozio);
        editTextLunSab = findViewById(R.id.editTextLunSab);
        editTextDom = findViewById(R.id.editTextDom);

        EditText[] listaEditTexts = {editTextNome, editTextIndirizzo, editTextLunSab, editTextDom};

        btnAggiungiNegozio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!controlloCampiEditText(listaEditTexts)) return;
                ;

                UtenteAzienda utenteAzienda = globalState.getAzienda();

                String nomeNegozio = listaEditTexts[0].getText().toString();
                String indirizzoNegozio = listaEditTexts[1].getText().toString();
                String orariNegozio = editTextLunSab.getText().toString() + "," + editTextDom.getText().toString();

                double[] coordianteLatLong = geoCoder(indirizzoNegozio);
                String lat = String.valueOf(coordianteLatLong[0]);
                String log = String.valueOf(coordianteLatLong[1]);


                Negozio negozio = new Negozio(nomeNegozio, indirizzoNegozio, orariNegozio, utenteAzienda.getId(), coordianteLatLong[0], coordianteLatLong[1]);

                webCtrl.postNegozio(negozio);

                startActivity(new Intent(AggiungiSedeActivity.this, HomeAziendaActivity.class));


            }
        });


    }

    private boolean controlloCampiEditText(EditText[] listaEditTexts) {
        for (EditText e :
                listaEditTexts) {
            if ("".equals(e.getText().toString())) {
                Toast.makeText(AggiungiSedeActivity.this, "Campi non riempiti!! ", Toast.LENGTH_LONG).show();

                return false;
            }

        }
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        gestioneBarMenuNavigazione(R.id.itemNegozi);//listener bar menu azienda
    }

    private void gestioneBarMenuNavigazione(int itemSelected) {
        new MenuNavBar(this, findViewById(R.id.bottomNavigationView), itemSelected, this);//l'icona che si illumina + activity

    }

    @Override
    public void handleAsync(Object obj) {

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
}