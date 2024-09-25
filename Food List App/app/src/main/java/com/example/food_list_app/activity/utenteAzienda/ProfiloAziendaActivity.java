package com.example.food_list_app.activity.utenteAzienda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.food_list_app.GlobalState;
import com.example.food_list_app.MenuNavBar;
import com.example.food_list_app.R;
import com.example.food_list_app.activity.utenteConsumer.HomeActivity;
import com.example.food_list_app.oggetti.UtenteAzienda;
import com.example.food_list_app.oggetti.UtenteConsumer;

public class ProfiloAziendaActivity extends AppCompatActivity implements View.OnClickListener {

    Button puntiVendita;
    ImageView imgBrand;
    GlobalState globalState;

    TextView  boxCompany, boxEmail, boxSede;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilo_azienda);

        boxCompany = findViewById(R.id.nomeProfiloAzienda);
        boxEmail = findViewById(R.id.emailProfiloAzienda);
        boxSede = findViewById(R.id.sedeProfiloAzienda);

        puntiVendita = findViewById(R.id.puntivendita);

        puntiVendita.setOnClickListener(this);

        imgBrand = findViewById(R.id.imgBrandNegozio);

        globalState = (GlobalState) getApplication();
        UtenteAzienda utenteAzienda = globalState.getAzienda();//usalo per il tuo setText


        //per caricare l'immagine dal DB tramite URL :|
        Glide.with(this).load(utenteAzienda.immagineAzienda).into(imgBrand);


    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(new Intent(this, HomeAziendaActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        gestioneBarMenuNavigazione(R.id.itemProfilo); //listener bar nAV

        GlobalState globalState = (GlobalState)getApplicationContext();

        UtenteAzienda azienda = globalState.getAzienda();

        if (azienda != null) {

            boxCompany.setText(azienda.getBrandAzienda());
            boxEmail.setText(azienda.getEmailAzienda());
            boxSede.setText(azienda.getSedeAzienda());
        }
    }

    private void gestioneBarMenuNavigazione(int itemSelected) {

        new MenuNavBar(this, findViewById(R.id.bottomNavigationView), itemSelected, this);//l'icona che si illumina + activity

    }
}