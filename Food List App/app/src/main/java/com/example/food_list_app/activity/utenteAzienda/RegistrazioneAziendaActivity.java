package com.example.food_list_app.activity.utenteAzienda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.food_list_app.R;
import com.example.food_list_app.activity.utenteConsumer.LoginActivity;
import com.example.food_list_app.api.UtenteInterface;
import com.example.food_list_app.oggetti.UtenteAzienda;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegistrazioneAziendaActivity extends AppCompatActivity implements View.OnClickListener {

    Button register;
    public static final String BASE_URL = "http://192.168.0.135:8080";

    EditText companyMail, companyPassword, companyBrand, companyLocation, companyIVA;

    int id = 20;

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    UtenteInterface Apiweb = retrofit.create(UtenteInterface.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrazione_azienda);

        register = findViewById(R.id.btnRegisterCompany);
        register.setOnClickListener(this);

        companyMail = findViewById(R.id.emailAzienda);

        companyPassword = findViewById(R.id.passwordAzienda);

        companyBrand = findViewById(R.id.sede);
    }
    @Override
    public void onClick(View view) {

        int var = view.getId();

        switch (var) {

            case R.id.btnregister:
                Intent prendiAzienda = new Intent(RegistrazioneAziendaActivity.this, LoginActivity.class);

                String emailAzienda = String.valueOf(Objects.requireNonNull(companyMail).getText());
                String passwordAzienda = String.valueOf(Objects.requireNonNull(companyPassword).getText());
                String brandAzienda = String.valueOf(Objects.requireNonNull(companyMail).getText());
                String sedeAzienda = String.valueOf(Objects.requireNonNull(companyPassword).getText());
                String partitaAzienda = String.valueOf(Objects.requireNonNull(companyMail).getText());



                Call<Void> setAzienda = Apiweb.registerAzienda(new UtenteAzienda(20, emailAzienda, passwordAzienda, brandAzienda, "", sedeAzienda, partitaAzienda));
                setAzienda.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                    }
                });
                break;
        }
        startActivity(new Intent(this, LoginAziendaActivity.class));
    }
}