package com.example.food_list_app.activity.utenteConsumer;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.food_list_app.GlobalState;
import com.example.food_list_app.MenuNavBar;
import com.example.food_list_app.R;
import com.example.food_list_app.oggetti.UtenteConsumer;

public class ProfiloUtenteActivity extends AppCompatActivity {

    TextView boxUser;
    TextView boxEmail;
    TextView boxPassword;
    GlobalState globalState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilo_utente);

         globalState = (GlobalState)getApplicationContext();

        boxUser = findViewById(R.id.textViewNomeutente);
        boxEmail = findViewById(R.id.textViewEmail);
        boxPassword = findViewById(R.id.textViewPassword);




        /*
        Bundle datiUtente = getIntent().getExtras();
        if (datiUtente != null) {

            String email = datiUtente.getString("emailUtente");
            String password = datiUtente.getString("passwordUtente");

            TextView emailUtente = findViewById(R.id.nomeutente);
            emailUtente.setText(email);
        }

         */

    }

    @Override
    protected void onResume() {
        super.onResume();
        gestioneBarNavigation(R.id.itemProfilo); //listener bar menu e search




        UtenteConsumer utenteConsumer = globalState.getUtente();

        if (utenteConsumer != null) {

            boxUser.setText(utenteConsumer.getNomeUtente());
            boxEmail.setText(utenteConsumer.getEmailUtente());
            boxPassword.setText(utenteConsumer.getPassword());
        }
    }

    private void gestioneBarNavigation(int itemSelected) {

        new MenuNavBar(this, findViewById(R.id.bottomNavigationView), itemSelected, this);//l'icona che si illumina + activity


    }
}