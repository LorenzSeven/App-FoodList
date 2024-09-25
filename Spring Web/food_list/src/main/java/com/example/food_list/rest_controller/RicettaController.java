package com.example.food_list.rest_controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.food_list.dao.RicettaDaoController;
import com.example.food_list.modelli.Ingredienti;
import com.example.food_list.modelli.Ricetta;

//http://localhost:8080/Ricette

@CrossOrigin
@RestController // controlla quello che sta sotto
@RequestMapping(value = "Ricette") // directory Ricette
public class RicettaController {
  RicettaDaoController ricDao = null;

  public RicettaController() {
    ricDao = new RicettaDaoController();
  }

  // http://localhost:8080/Ricette/getRicetta?id=1
  @RequestMapping(value = "getRicetta", method = RequestMethod.GET)
  public Ricetta getRicetta(@RequestParam("id") int id) {
    return ricDao.getRicetta(id);
  }

  // http://localhost:8080/Ricette/getRicette
  @RequestMapping(value = "getRicette", method = RequestMethod.GET)
  public ArrayList<Ricetta> getRicette() {
    return ricDao.getRicette();
  }

  // http://localhost:8080/Ricette/getRicettaIng?id=4
  @RequestMapping(value = "getRicettaIng", method = RequestMethod.GET)
  public Ricetta getRicettaIng(@RequestParam("id") int id) {
    Ricetta ricetta = ricDao.getRicetta(id);
    ArrayList<Ingredienti> ingredienti = ricDao.getRicettaIngr(id);
    if (ingredienti.size() == 0)
      System.out.println("ArrayList<Ingredienti> --> vuota");
    ricetta.setLista_ingredienti(ingredienti);

    return ricetta;
  }

  // http://localhost:8080/Ricette/postRicetta?idUtente=5&idRicetta=8
  @RequestMapping(value = "postRicetta", method = RequestMethod.POST)
  public void addRicetta(@RequestParam("idRicetta") int idRicetta, @RequestParam("idUtente") int idUtente) {
    ricDao.postRicetta(idRicetta, idUtente);
  }

  // http://localhost:8080/Ricette/getRicetteDaPreferiti?id=5
  @RequestMapping(value = "getRicetteDaPreferiti", method = RequestMethod.GET)
  public ArrayList<Ricetta> getRicetteDaPreferiti(@RequestParam("id") int idUtente) {
    return ricDao.getRicetteDaPrefer(idUtente);
  }

  // http://localhost:8080/Ricette/getRicette/nazionalità/italiana
  @RequestMapping(value = "getRicette/nazionalità/{nazionalità}", method = RequestMethod.GET)
  public ArrayList<Ricetta> getRicetteNazionalità(@PathVariable("nazionalità") String nazionalità) {
    return ricDao.getRicetteNazionalità(nazionalità);
  }

  // http://localhost:8080/Ricette/getRicette/nome/tiramisù
  @RequestMapping(value = "getRicette/nome/{nome}", method = RequestMethod.GET)
  public ArrayList<Ricetta> getRicetteNome(@PathVariable("nome") String nome) {
    return ricDao.getRicetteNome(nome);
  }

  // http://localhost:8080/Ricette/getRicette/tipo/primo
  @RequestMapping(value = "getRicette/tipo/{tipo}", method = RequestMethod.GET)
  public ArrayList<Ricetta> getRicetteTipo(@PathVariable("tipo") String tipo) {
    return ricDao.getRicetteTipo(tipo);
  }
  

  // http://localhost:8080/Ricette/deleteRicetta?idUtente=5&idRicetta=8
  @RequestMapping(value = "deleteRicetta", method = RequestMethod.DELETE)
  public void deleteRicetta(@RequestParam("idUtente") int idUtente, @RequestParam("idRicetta") int idRicetta) {
    ricDao.deleteRicettaDaPrefer(idUtente, idRicetta);
  }

  // http://localhost:8080/Ricette/getRicetteIngrperTipo/tipo/primo
  @RequestMapping(value = "getRicetteIngrperTipo/tipo/{tipo}", method = RequestMethod.GET)
  public ArrayList<Ricetta> getRicetteIngrperTipo(@PathVariable("tipo") String tipo) {
    return ricDao.getRicetteIngrperTipo(tipo);
  }

  // http://localhost:8080/Ricette/postCarrello/quantità=200&idUtente=2&idIngrediente=5
  @RequestMapping(value = "postCarrello", method = RequestMethod.POST)
  public void addCarrello(@RequestParam("quantità") int quantità, @RequestParam("idUtente") int idUtente,
      @RequestParam("idIngrediente") int idIngrediente) {
    ricDao.postCarrello(quantità, idUtente, idIngrediente);
  }


    // http://localhost:8080/Ricette/utente/1/carrello
    @RequestMapping(value = "utente/{id}/carrello", method = RequestMethod.GET)
    public ArrayList<Ingredienti> ottieniIngredentiIDUtente(@PathVariable("id") int id) {
        return ricDao.getIngredientiIdutente(id);
    }

}
