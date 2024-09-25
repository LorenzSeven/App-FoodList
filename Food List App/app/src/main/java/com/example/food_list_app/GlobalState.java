package com.example.food_list_app;

import android.app.Application;

import com.example.food_list_app.oggetti.UtenteAzienda;
import com.example.food_list_app.oggetti.UtenteConsumer;

public class GlobalState extends Application {
    private UtenteConsumer utenteConsumer;
    private UtenteAzienda utenteAzienda;

    public UtenteConsumer getUtente() {
        return utenteConsumer;
    }

    public void setUtente(UtenteConsumer utenteConsumer) {
        this.utenteConsumer = utenteConsumer;
    }

    public UtenteAzienda getAzienda() {
        return utenteAzienda;
    }

    public void setAzienda(UtenteAzienda utenteAzienda) {
        this.utenteAzienda = utenteAzienda;
    }
}
