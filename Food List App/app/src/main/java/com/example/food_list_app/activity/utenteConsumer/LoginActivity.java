package com.example.food_list_app.activity.utenteConsumer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.food_list_app.GlobalState;
import com.example.food_list_app.R;
import com.example.food_list_app.api.SyncCall;
import com.example.food_list_app.api.WebCtrl;
import com.example.food_list_app.oggetti.UtenteConsumer;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener, SyncCall {

    Button loginButton;
    Button utenteButton;
    EditText editMail;
    EditText editPass;

    String email;
    String password;

    GlobalState globalState;


    WebCtrl webCtrl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //REST GET
        webCtrl = WebCtrl.getINSTACE(this);

        editMail = findViewById(R.id.editEmail);
        editPass = findViewById(R.id.editPassword);

        loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this);

        utenteButton = findViewById(R.id.registerUtente);
        utenteButton.setOnClickListener(this);

        globalState = (GlobalState) getApplicationContext();
    }

    @Override
    public void onClick(View v) {

        password = editPass.getText().toString();
        email = editMail.getText().toString();

        int id = v.getId();

        switch (id) {

            case R.id.loginButton:
                if (password.toString().isEmpty() || email.toString().isEmpty()) {
                    Toast.makeText(this, "compila tutti i campi", Toast.LENGTH_LONG).show();
                } else {
                    webCtrl.getUtenteConsumer(email, password);
                }

                break;

            case R.id.registerUtente:
                startActivity(new Intent(this, RegistrazioneUtenteActivity.class));
                break;
        }
    }

    @Override
    public void handleAsync(Object obj) {
        if (obj instanceof UtenteConsumer) {
            UtenteConsumer u = (UtenteConsumer) obj;
            globalState.setUtente(u);
        }

        if (obj instanceof String) {
            String s = (String) obj;
            Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
        } else if (obj != null) {
            startActivity(new Intent(this, HomeActivity.class));
        } else Toast.makeText(this, "Credenziali errate, riprovare!!", Toast.LENGTH_SHORT).show();

    }
}