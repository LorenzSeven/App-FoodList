package com.example.food_list_app.api;

import com.example.food_list_app.adapter.CarrelloArrayAdpter;
import com.example.food_list_app.oggetti.Ingrediente;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiIngredienti {


    //http://localhost:8080/negozio/dbingredienti-> JSON Array Ingredienti
    @GET("/negozio/dbingredienti")
    Call<ArrayList<Ingrediente>> ottieniIngredienti();


    // http://localhost:8080/negozio/getingredienti-> JSON Object Ingredienti
    @GET("/negozio/getingrediente/{id}")
    Call<Ingrediente> ottieniIngrediente(@Path("id") int id);

    // http://localhost:8080/negozio/utente/1/aggiungi/carrello
    @POST("/negozio/utente/{id}/aggiungi/carrello")
    Call<Void> aggiungiAlCarrello(@Path("id") int id, @Body ArrayList<Integer> idListaIngredienti);
    // http://localhost:8080/negozio/ricetta/ingredienti?id=4
    @GET("/negozio/ricetta/ingredienti")
    Call<ArrayList<Ingrediente>> ottieniIngredientiDaRicetta(@Query("id") int id);
    // http://localhost:8080/Ricette/utente/1/carrello
    @GET("/Ricette/utente/{id}/carrello")
    Call<ArrayList<Ingrediente>> OttieniIngredientiCarrello(@Path("id") int idutente);
    @DELETE("/negozio/utente/aggiungono/ingredienti/elimina")
    Call<Void> eliminaIngredienteCarrello(@Query("idUtente") int idUtente, @Query("idIngrediente") int idIngrediente);
    @DELETE("/negozio/utente/1/ingredienti/elimina")
    Call<Void> eliminaIngredienteNegozio(@Query("idIngrediente") int idIngrediente, @Query("idNegozio") int idNegozio);
    @GET("negozio/getLastIngrediente")
    Call<Ingrediente> getLastIngrediente();
}
