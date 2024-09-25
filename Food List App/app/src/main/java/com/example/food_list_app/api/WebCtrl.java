package com.example.food_list_app.api;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.food_list_app.oggetti.Ingrediente;
import com.example.food_list_app.oggetti.Negozio;
import com.example.food_list_app.oggetti.Ricetta;
import com.example.food_list_app.oggetti.UtenteAzienda;
import com.example.food_list_app.oggetti.UtenteConsumer;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;

//Gestisce le chiamate Web
public class WebCtrl extends AppCompatActivity {
    private static WebCtrl INSTACE = null;
    static SyncCall delegateObj = null;

    OkHttpClient client = new OkHttpClient.Builder()//promblemi con mobile fisico
            .connectTimeout(60, TimeUnit.SECONDS)
            .build();
    public static final String BASE_URL = "http://192.168.1.59:8080";
    Retrofit retrofit = new Retrofit.Builder() //initialization di retrofit
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    //initialization of API
    ApiIngredienti apiWebIngredienti = retrofit.create(ApiIngredienti.class);
    ApiRicette apiWebRicette = retrofit.create(ApiRicette.class);

    ApiNegozi apiWebNegozi = retrofit.create(ApiNegozi.class);

    UtenteInterface apiWebUtente = retrofit.create(UtenteInterface.class);

    private WebCtrl(SyncCall d) {
        delegateObj = d;
    } //costruttore

    public static WebCtrl getINSTACE(SyncCall d) {
        if (INSTACE == null) INSTACE = new WebCtrl(d);
        delegateObj = d;
        return INSTACE;
    }


    //Creazione metodi API Ingredienti
    public void getIngrediente(int id) {

        Call<Ingrediente> getSingleIngrediente = apiWebIngredienti.ottieniIngrediente(id);
        getSingleIngrediente.enqueue(new Callback<Ingrediente>() {
            @Override
            public void onResponse(Call<Ingrediente> call, Response<Ingrediente> response) {
                Ingrediente i = response.body();
                delegateObj.handleAsync(i);
            }

            @Override
            public void onFailure(Call<Ingrediente> call, Throwable t) {

            }
        });
    }

    public void getIngredienti() {
        Call<ArrayList<Ingrediente>> getAllIngredienti = apiWebIngredienti.ottieniIngredienti();

        getAllIngredienti.enqueue(new Callback<ArrayList<Ingrediente>>() {
            @Override
            public void onResponse(Call<ArrayList<Ingrediente>> call, Response<ArrayList<Ingrediente>> response) {
                Object lista = response.body();
                delegateObj.handleAsync(lista);
            }

            @Override
            public void onFailure(Call<ArrayList<Ingrediente>> call, Throwable t) {

            }
        });
    }

    public void addIngrediente(Ingrediente i) {
        Call<Ingrediente> postingrediente = apiWebNegozi.InserisciIngredienti(i);
        postingrediente.enqueue(new Callback<Ingrediente>() {
            @Override
            public void onResponse(Call<Ingrediente> call, Response<Ingrediente> response) {
                Ingrediente r = response.body();
                delegateObj.handleAsync(r);
                Log.v("Codice addIngrediente:", String.valueOf(response.code()));
            }

            @Override
            public void onFailure(Call<Ingrediente> call, Throwable t) {

            }
        });
    }

    public void getIngredientiDaRicetta(int idRicetta) {
        Call<ArrayList<Ingrediente>> getAllIngredienti = apiWebIngredienti.ottieniIngredientiDaRicetta(idRicetta);

        getAllIngredienti.enqueue(new Callback<ArrayList<Ingrediente>>() {
            @Override
            public void onResponse(Call<ArrayList<Ingrediente>> call, Response<ArrayList<Ingrediente>> response) {
                Object lista = response.body();
                delegateObj.handleAsync(lista);
            }

            @Override
            public void onFailure(Call<ArrayList<Ingrediente>> call, Throwable t) {

            }
        });
    }


    public void salvaInCarrello(int idUtente, ArrayList<Integer> ingredientiScelti) {
        Call<Void> callAggiungiCarrello = apiWebIngredienti.aggiungiAlCarrello(idUtente, ingredientiScelti);
        callAggiungiCarrello.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.v("Codice:", String.valueOf(response.code()));
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.v("Fallimento:", t.getMessage());
            }
        });
    }

    public void eliminaDaCarrello(int idUtente, int idIngrediente) {
        Call<Void> cancIngrediente = apiWebIngredienti.eliminaIngredienteCarrello(idUtente, idIngrediente);
        cancIngrediente.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.v("Codice", String.valueOf(response.code()));
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.v("Fallimento", t.getMessage());
            }
        });
    }

    public void getCarrello(int idUtente) {
        Call<ArrayList<Ingrediente>> callIngredienti = apiWebIngredienti.OttieniIngredientiCarrello(idUtente);
        callIngredienti.enqueue(new Callback<ArrayList<Ingrediente>>() {
            @Override
            public void onResponse(Call<ArrayList<Ingrediente>> call, Response<ArrayList<Ingrediente>> response) {
                ArrayList<Ingrediente> arr = response.body();
                delegateObj.handleAsync(arr);
                Log.v("Codice:", String.valueOf(response.code()));
            }

            @Override
            public void onFailure(Call<ArrayList<Ingrediente>> call, Throwable t) {
                Log.v("Fallimento:", t.getMessage());
            }
        });
    }

    public void getUltimoIngrediente() {
        Call<Ingrediente> getUltimoIngrediente = apiWebIngredienti.getLastIngrediente();

        getUltimoIngrediente.enqueue(new Callback<Ingrediente>() {
            @Override
            public void onResponse(Call<Ingrediente> call, Response<Ingrediente> response) {
                Ingrediente i = response.body();
                Integer id = i.getId();
                delegateObj.handleAsync(id);
                Log.v("Codice", String.valueOf(response.code()));
            }

            @Override
            public void onFailure(Call<Ingrediente> call, Throwable t) {
                Log.v("Fallimento", t.getMessage());
            }
        });
    }

    public void delIngredienteNegozio(int idIngrediente, int idNegozio){
        Call<Void> delIngrediente = apiWebIngredienti.eliminaIngredienteNegozio(idIngrediente, idNegozio);
        delIngrediente.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.v("Codice", String.valueOf(response.code()));
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.v("Fallimento", t.getMessage());
            }
        });
    }

    //Creazione metodi API Ricette
    public void getRicetta(int id) {
        Call<Ricetta> getSingleRicetta = apiWebRicette.getSingleRicetta(id);
        getSingleRicetta.enqueue(new Callback<Ricetta>() {
            @Override
            public void onResponse(Call<Ricetta> call, Response<Ricetta> response) {
                Ricetta r = response.body();
                delegateObj.handleAsync(r);
            }

            @Override
            public void onFailure(Call<Ricetta> call, Throwable t) {

            }
        });
    }


    public void getRicetteNome(String nome) {
        Call<ArrayList<Ricetta>> callRicetteTipo = apiWebRicette.getRicetteNome(nome);
        callRicetteTipo.enqueue(new Callback<ArrayList<Ricetta>>() {
            @Override
            public void onResponse(Call<ArrayList<Ricetta>> call, Response<ArrayList<Ricetta>> response) {
                Object lista = response.body();
                delegateObj.handleAsync(lista);

            }

            @Override
            public void onFailure(Call<ArrayList<Ricetta>> call, Throwable t) {

            }
        });
    }

    public void getRicetteTipo(String tipo) {
        Call<ArrayList<Ricetta>> callRicetteNome = apiWebRicette.getRicetteTipo(tipo);
        callRicetteNome.enqueue(new Callback<ArrayList<Ricetta>>() {
            @Override
            public void onResponse(Call<ArrayList<Ricetta>> call, Response<ArrayList<Ricetta>> response) {
                Object lista = response.body();
                delegateObj.handleAsync(lista);

            }

            @Override
            public void onFailure(Call<ArrayList<Ricetta>> call, Throwable t) {

            }
        });
    }

    public void getRicettePreferiti(int idUtente) {
        Call<ArrayList<Ricetta>> callRicettePref = apiWebRicette.getPreferiti(idUtente);
        callRicettePref.enqueue(new Callback<ArrayList<Ricetta>>() {
            @Override
            public void onResponse(Call<ArrayList<Ricetta>> call, Response<ArrayList<Ricetta>> response) {
                Object lista = response.body();
                delegateObj.handleAsync(lista);
                Log.v("Codice", String.valueOf(response.code()));
            }

            @Override
            public void onFailure(Call<ArrayList<Ricetta>> call, Throwable t) {
                Log.v("Fallimento", t.getMessage());
            }
        });
    }


    public void postRicettaInPreferiti(int idUtente, int idRicetta) {
        Call<Void> postRicetteInPref = apiWebRicette.postRicettaInPreferiti(idUtente, idRicetta);
        postRicetteInPref.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Object lista = response.body();
                delegateObj.handleAsync(lista);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
            }
        });
    }

    public void deletePreferito(int idUtente, int idRicetta) {
        Call<Void> cancPreferito = apiWebRicette.eliminaRicettaPreferiti(idUtente, idRicetta);
        cancPreferito.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.v("Codice", String.valueOf(response.code()));
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.v("Fallimento", t.getMessage());
            }
        });
    }

    public void prendiRicetta(int id) {
        Call<Ricetta> getSingleRicetta = apiWebRicette.ottieniRicetta(id);
        getSingleRicetta.enqueue(new Callback<Ricetta>() {
            @Override
            public void onResponse(Call<Ricetta> call, Response<Ricetta> response) {
                Ricetta r = response.body();
                delegateObj.handleAsync(r);
            }

            @Override
            public void onFailure(Call<Ricetta> call, Throwable t) {

            }
        });
    }

    //aPI NEGOZIO

    public void getNegozio(int idNegozio) {
        Call<Negozio> callNegozio = apiWebNegozi.ottieniNegozio(idNegozio);
        callNegozio.enqueue(new Callback<Negozio>() {
            @Override
            public void onResponse(Call<Negozio> call, Response<Negozio> response) {
                Negozio negozio = response.body();
                delegateObj.handleAsync(negozio);
                Log.v("Codice", String.valueOf(response.code()));
            }

            @Override
            public void onFailure(Call<Negozio> call, Throwable t) {

            }
        });
    }

    public void getCercaNegozi(int idUtente) {
        Call<ArrayList<Negozio>> callCercaNegozio = apiWebNegozi.ottieniCercaNegozi(idUtente);
        callCercaNegozio.enqueue(new Callback<ArrayList<Negozio>>() {
            @Override
            public void onResponse(Call<ArrayList<Negozio>> call, Response<ArrayList<Negozio>> response) {
                ArrayList<Negozio> negozi = response.body();
                delegateObj.handleAsync(negozi);
            }

            @Override
            public void onFailure(Call<ArrayList<Negozio>> call, Throwable t) {
                Log.v("Fallimento", t.getMessage());
            }
        });
    }

    public void getCercaNegoziDistanzaOrdinati(int idUtente, double latitudineUtente, double longitudineUtente, double distanzaMax) {
        Call<ArrayList<Negozio>> callCercaNegozio = apiWebNegozi.ottieniCercaNegoziDistanza(idUtente, latitudineUtente, longitudineUtente, distanzaMax);
        callCercaNegozio.enqueue(new Callback<ArrayList<Negozio>>() {
            @Override
            public void onResponse(Call<ArrayList<Negozio>> call, Response<ArrayList<Negozio>> response) {
                ArrayList<Negozio> negozi = response.body();
                delegateObj.handleAsync(negozi);
            }

            @Override
            public void onFailure(Call<ArrayList<Negozio>> call, Throwable t) {

            }
        });
    }

    public void postNegozio(Negozio negozio) {
        Call<Void> callPostNegozio = apiWebNegozi.addNegozio(negozio);
        callPostNegozio.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                int code = response.code();
                Log.i("WebCtrl", String.valueOf(code));
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

    public void getNegoziAz(int idUtenteAz) {
        Call<ArrayList<Negozio>> callNegozi = apiWebNegozi.ottieniNegozi(idUtenteAz);
        callNegozi.enqueue(new Callback<ArrayList<Negozio>>() {
            @Override
            public void onResponse(Call<ArrayList<Negozio>> call, Response<ArrayList<Negozio>> response) {
                ArrayList<Negozio> negozi = response.body();
                delegateObj.handleAsync(negozi);
            }

            @Override
            public void onFailure(Call<ArrayList<Negozio>> call, Throwable t) {

            }
        });
    }

    public void delNegozio(int idNegozio) {
        Call<Void> cancNegozio = apiWebNegozi.deleteNegozio(idNegozio);
        cancNegozio.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.v("Codice", String.valueOf(response.code()));
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.v("Fallimento", t.getMessage());
            }
        });
    }

    public void associaNegozio( int idIngrediente, float valore, float prezzo, String unitàMisura, int idNegozio) {
        Call<Void> associaNegozio = apiWebNegozi.associaNegozio(idIngrediente,valore,prezzo,unitàMisura,idNegozio);
        associaNegozio.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.v("Codice associa Negozio", String.valueOf(response.code()));
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.v("Fallimento", t.getMessage());
            }
        });
    }

    //Utente
    public void getUtenteConsumer(String email, String password) {

        Call<UtenteConsumer> getUtenteConsumer = apiWebUtente.loginConsumer(email, password);

        getUtenteConsumer.enqueue(new Callback<UtenteConsumer>() {
            @Override
            public void onResponse(Call<UtenteConsumer> call, Response<UtenteConsumer> response) {
                UtenteConsumer u = response.body();
                delegateObj.handleAsync(u);
            }

            @Override
            public void onFailure(Call<UtenteConsumer> call, Throwable t) {

                if (t instanceof ConnectException || t instanceof SocketTimeoutException) {
                    delegateObj.handleAsync("Manca connesione Spring Boot");

                } else delegateObj.handleAsync(null);

                t.printStackTrace();
            }
        });
    }

    public void getUtenteAzienda(String aziendaEmail, String aziendaPassword) {

        Call<UtenteAzienda> getUtenteAzienda = apiWebUtente.loginAzienda(aziendaEmail, aziendaPassword);
        getUtenteAzienda.enqueue(new Callback<UtenteAzienda>() {

            @Override
            public void onResponse(Call<UtenteAzienda> call, Response<UtenteAzienda> response) {
                UtenteAzienda utenteAzienda = response.body();
                delegateObj.handleAsync(utenteAzienda);
            }

            @Override
            public void onFailure(Call<UtenteAzienda> call, Throwable t) {
                if (t instanceof ConnectException || t instanceof SocketTimeoutException) {
                    delegateObj.handleAsync("Manca connesione Spring Boot");

                } else delegateObj.handleAsync(null);

                t.printStackTrace();
            }
        });
    }


}
