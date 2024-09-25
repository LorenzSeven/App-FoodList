package com.example.food_list_app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.food_list_app.R;
import com.example.food_list_app.activity.utenteAzienda.LoginAziendaActivity;
import com.example.food_list_app.activity.utenteConsumer.LoginActivity;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    Button utenteButton;
    Button aziendaButton;

    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        logo = findViewById(R.id.logo);
        logo.setImageResource(R.drawable.mini_logo);

        utenteButton = findViewById(R.id.openUtente);
        utenteButton.setOnClickListener(this);

        aziendaButton = findViewById(R.id.openAzienda);
        aziendaButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        int id = view.getId();

        switch (id) {
            case R.id.openUtente:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.openAzienda:
                startActivity(new Intent(this, LoginAziendaActivity.class));
                break;
        }
    }
}