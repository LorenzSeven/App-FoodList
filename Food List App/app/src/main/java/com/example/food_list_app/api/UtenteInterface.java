package com.example.food_list_app.api;

import com.example.food_list_app.oggetti.UtenteAzienda;
import com.example.food_list_app.oggetti.UtenteConsumer;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface UtenteInterface {

    //http://api.myservice.com/User/

    @Multipart
    @POST("/User/login")
    Call<UtenteConsumer> loginConsumer(@Part ("emailUtente") String emailUtente, @Part ("passwordUtente") String passwordUtente);

    @Multipart
    @POST("/User/loginAzienda")
    Call<UtenteAzienda> loginAzienda(@Part ("emailAzienda") String emailAzienda, @Part ("passwordAzienda") String passwordAzienda);


    @POST("/User/registerUtente")
    Call<Void> registerUtente(@Body UtenteConsumer utenteConsumer);

    @POST("/User/registerAzienda")
    Call<Void> registerAzienda(@Body UtenteAzienda utenteAzienda);
}
