package com.example.food_list_app.api;

import com.example.food_list_app.oggetti.Ricetta;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiRicette
{
    //http://localhost:8080/Ricette/getRicettaIng?id=4 --> JSON Object Ricetta che contiene  un  JSON ARRAY di ingredietnit
    @GET("/Ricette/getRicettaIng")
    Call<Ricetta> getSingleRicetta(@Query("id") int id);


    // http://localhost:8080/Ricette/getRicette?tipo=primo --> JSON Array Ricetta che contiene  un  JSON ARRAY di
    @GET("/Ricette/getRicette/tipo/{tipo}")
    Call<ArrayList<Ricetta>> getRicetteTipo(@Path("tipo") String tipo);

    // http://localhost:8080/Ricette/getRicette/nome/tiramisù
    @GET("Ricette/getRicette/nome/{nome}")
    Call<ArrayList<Ricetta>> getRicetteNome(@Path("nome") String nome);

    // http://localhost:8080/Ricette/getRicetteDaPreferiti?id=5
    @GET("Ricette/getRicetteDaPreferiti")
    Call<ArrayList<Ricetta>> getPreferiti(@Query("id") int idUtente);

    // http://localhost:8080/Ricette/postRicetta?idUtente=5&idRicetta=8
    @POST("Ricette/postRicetta")
    Call<Void> postRicettaInPreferiti(@Query("idUtente")int IdUtente, @Query("idRicetta") int idRicetta);

    // http://localhost:8080/Ricette/deleteRicetta?idUtente=X&idRicetta=X
    @DELETE("Ricette/deleteRicetta")
    Call<Void> eliminaRicettaPreferiti(@Query("idUtente") int idUtente, @Query("idRicetta") int idRicetta);

    // http://localhost:8080/Ricette/getRicetta?id=1
    @GET("Ricette/getRicetta")
    Call<Ricetta> ottieniRicetta(@Query("id") int id);
}
