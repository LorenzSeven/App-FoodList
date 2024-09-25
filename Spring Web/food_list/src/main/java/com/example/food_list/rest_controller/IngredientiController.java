package com.example.food_list.rest_controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.food_list.dao.IngredientiDao;
import com.example.food_list.modelli.Ingredienti;

// classe Controller

//http://localhost:8080/negozio

@CrossOrigin
@RestController
@RequestMapping(value = "negozio")
public class IngredientiController {

    IngredientiDao ingDao = null;

    public IngredientiController() {

        ingDao = new IngredientiDao();// istanza Dao Ingredienti

    }
    //http://localhost:8080/negozio/dbingredienti
    @RequestMapping(value = "dbingredienti")
    public ArrayList<Ingredienti> getDBTabelleIngredienti() {
        return ingDao.getIngredienti();
    }

    // http://localhost:8080/negozio/1/ingredienti/aggiungi?prezzo=2.323
    @RequestMapping(value = "{id}/ingredienti/aggiungi", method = RequestMethod.GET)
    public void addIngridentiVenduti(@PathVariable("id") int idNegozio, @RequestParam("prezzo") float prezzo,
            @RequestBody Ingredienti i) {
        ingDao.insertIngredienteVedono(i);
        int idIngrediete = ingDao.getIdIngrediente(i);
        ingDao.insertVendono(prezzo, idNegozio, idIngrediete);
    }

    // http://localhost:8080/negozio/utente/1/aggiungi/carrello
    @RequestMapping(value = "utente/{id}/aggiungi/carrello", method = RequestMethod.POST)
    public void addIngridentiCarrello(@PathVariable("id") int idUtente,
            @RequestBody ArrayList<Integer> idlistaIngredienti) {
        ingDao.insertIngredienteCarrello(idUtente, idlistaIngredienti);

    }

    // http://localhost:8080/negozio/utente/1/ingredienti/elimina?idIngrediente=1&idNegozio=2;
    @RequestMapping(value = "utente/1/ingredienti/elimina", method = RequestMethod.DELETE)
    public void deleteVendono(@RequestParam("idIngrediente") int idIngrediente,
            @RequestParam("idNegozio") int idNegozio) {
        ingDao.deleteVendono(idIngrediente, idNegozio);

    }

    // http://localhost:8080/negozio/utente/aggiungono/ingredienti/elimina?idIngrediente=1&idUtente=2;
    @RequestMapping(value = "utente/aggiungono/ingredienti/elimina", method = RequestMethod.DELETE)
    public void deleteAggiungono(@RequestParam("idIngrediente") int idIngrediente,
            @RequestParam("idUtente") int idUtente) {
        ingDao.deleteAggiungono(idIngrediente, idUtente);

    }

    // http://localhost:8080/negozio/getIngrediente/1
    @RequestMapping(value = "getingrediente/{id}")
    public Ingredienti ottieniPersona(@PathVariable("id") int id) {
        return ingDao.getIngrediente(id);
    }

    // http://localhost:8080/negozio/getnome/spaghettti
    @RequestMapping(value = "getnome/{nome}")
    public Ingredienti ottieniPersona1(@PathVariable("nome") String nome) {
        return ingDao.getIngredienteNome(nome);
    }

    // http://localhost:8080/negozio/ingrediente?nome=spaghetti
    @RequestMapping(value = "ingrediente", method = RequestMethod.GET)
    public Ingredienti ottieniPersona2(@RequestParam("nome") String nome) {
        return ingDao.getIngredienteNome(nome);
    }

    // http://localhost:8080/negozio/addData
    @RequestMapping(value = "addData", method = RequestMethod.POST)
    public void addNegozio(Ingredienti i) {
        ingDao.insertIngredienteVedono(i);
    }

    // http://localhost:8080/negozio/ricetta/ingredienti?id=1
    @RequestMapping(value = "ricetta/ingredienti", method = RequestMethod.GET)
    public ArrayList<Ingredienti> ottieniAllIngredientiRicetta(@RequestParam("id") int id) {
        return ingDao.getAllIngriedientiRicetta(id);
    }

    // http://localhost:8080/negozio/getLastIngrediente
    @RequestMapping(value = "getLastIngrediente", method = RequestMethod.GET)
    public Ingredienti prendiUltimoIngrediente(){
        return ingDao.getLastIngrediente();
    }

    @RequestMapping(value = "saluto")
    public String saluto() {
        return "ciao";
    }
}