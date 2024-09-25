package com.example.food_list_app.activity.utenteAzienda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.food_list_app.GlobalState;
import com.example.food_list_app.R;
import com.example.food_list_app.activity.utenteConsumer.HomeActivity;
import com.example.food_list_app.activity.utenteConsumer.RegistrazioneUtenteActivity;
import com.example.food_list_app.api.SyncCall;
import com.example.food_list_app.api.WebCtrl;
import com.example.food_list_app.oggetti.UtenteAzienda;


public class LoginAziendaActivity extends AppCompatActivity implements View.OnClickListener, SyncCall {

    Button loginButton, registerAziendaButton;

    EditText aziendaEditMail, aziendaEditPass;

    String aziendaEmail, aziendaPassword;

    GlobalState globalState;
    WebCtrl webCtrl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azienda_login);

        webCtrl = WebCtrl.getINSTACE(this);

        aziendaEditMail = findViewById(R.id.editAziendaEmail);
        aziendaEditPass = findViewById(R.id.editAziendaPassword);

        loginButton = findViewById(R.id.loginAziendaButton);
        loginButton.setOnClickListener(this);

        registerAziendaButton = findViewById(R.id.registerAzienda);
        registerAziendaButton.setOnClickListener(this);


        globalState = (GlobalState) getApplicationContext();
    }

    @Override
    public void onClick(View v) {

        aziendaEmail = aziendaEditMail.getText().toString();
        aziendaPassword = aziendaEditPass.getText().toString();
        //aziendaEmail = "azienda3@example.com";
        //aziendaPassword ="password3";
        int id = v.getId();

        switch (id) {

            case R.id.loginAziendaButton:
                if (aziendaPassword.toString().isEmpty() || aziendaPassword.toString().isEmpty()) {
                    Toast.makeText(this, "compila tutti i campi", Toast.LENGTH_LONG).show();
                } else {
                    webCtrl.getUtenteAzienda(aziendaEmail, aziendaPassword);
                }
                break;

            case R.id.registerAzienda:

                startActivity(new Intent(this, RegistrazioneAziendaActivity.class));
                break;
        }


    }

    @Override
    public void handleAsync(Object obj) {
        if (obj instanceof UtenteAzienda) {
            UtenteAzienda a = (UtenteAzienda) obj;
            globalState.setAzienda(a);
        }

        if (obj instanceof String) {
            String s = (String) obj;
            Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
        } else if (obj != null) {
            startActivity(new Intent(this, HomeAziendaActivity.class));
        } else Toast.makeText(this, "Credenziali errate, riprovare!!", Toast.LENGTH_SHORT).show();

    }
}