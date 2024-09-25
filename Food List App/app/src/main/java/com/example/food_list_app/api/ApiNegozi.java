package com.example.food_list_app.api;

import com.example.food_list_app.oggetti.Ingrediente;
import com.example.food_list_app.oggetti.Negozio;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiNegozi {

    @GET("/NegoziCtrl/getNegozio")
    Call<Negozio> ottieniNegozio(@Query("id") int idNegozio);

    @GET("/NegoziCtrl/getNegozi")
    Call<ArrayList<Negozio>> ottieniNegozi(@Query("idAz") int idUtenteAz);

    @DELETE("/NegoziCtrl/deleteNegozio")
    Call<Void> deleteNegozio(@Query("id") int idNegozio);


    @GET("/NegoziCtrl/utente/{id}/cerca/negozio")
    Call<ArrayList<Negozio>> ottieniCercaNegozi(@Path("id") int id);


    @GET("/NegoziCtrl/utente/{id}/cerca/negozio/distanza")
    Call<ArrayList<Negozio>> ottieniCercaNegoziDistanza(@Path("id") int id, @Query("latitudineUtente") double latitudineUtente, @Query("longitudineUtente") double longitudineUtente, @Query("distanzaMax") double distanzaMax);

    @POST("NegoziCtrl/aggiungi/ingrediente/ingredienti")
    Call<Ingrediente> InserisciIngredienti(@Body Ingrediente ingrediente);

    @POST("NegoziCtrl/associaANegozio")
    Call<Void> associaNegozio(@Query("idIngrediente") int idIngr, @Query("valore") float val, @Query("prezzo") float prezzo, @Query("unitàMisura") String mes, @Query("idNegozio") int idNeg);

    @POST("NegoziCtrl/postNegozio")
    Call<Void> addNegozio(@Body Negozio negozio);

}
