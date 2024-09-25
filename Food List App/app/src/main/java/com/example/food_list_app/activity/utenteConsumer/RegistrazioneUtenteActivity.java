package com.example.food_list_app.activity.utenteConsumer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.food_list_app.R;
import com.example.food_list_app.api.UtenteInterface;
import com.example.food_list_app.oggetti.UtenteConsumer;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegistrazioneUtenteActivity extends AppCompatActivity implements View.OnClickListener {

    Button register;
    public static final String BASE_URL = "http://192.168.0.135:8080";

    EditText username, useremail, userpassword;

    int id = 20;

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    UtenteInterface Apiweb = retrofit.create(UtenteInterface.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrazione_utente);

        register = findViewById(R.id.btnregister);
        register.setOnClickListener(this);


        username = findViewById(R.id.username);

        useremail = findViewById(R.id.emailUtente);

        userpassword = findViewById(R.id.passwordUtente);
    }
    @Override
    public void onClick(View view) {

        int var = view.getId();

        switch (var) {

            case R.id.btnregister:
                Intent prendidati = new Intent(RegistrazioneUtenteActivity.this, LoginActivity.class);
                String nomeUtente = String.valueOf(Objects.requireNonNull(username).getText());
                String emailUtente = String.valueOf(Objects.requireNonNull(useremail).getText());
                String passwordUtente = String.valueOf(Objects.requireNonNull(userpassword).getText());

                Call<Void> setUtente = Apiweb.registerUtente(new UtenteConsumer(20, nomeUtente, emailUtente, passwordUtente, ""));
                setUtente.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                    }
                });
                break;
        }
        startActivity(new Intent(this, LoginActivity.class));
    }
}