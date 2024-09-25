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
import com.example.food_list.dao.NegoziDaoController;
import com.example.food_list.modelli.Ingredienti;
import com.example.food_list.modelli.Negozio;

@CrossOrigin
@RestController
@RequestMapping(value = "NegoziCtrl")
public class NegoziController {

  NegoziDaoController negDao = null;
  IngredientiDao ingDao = null;

  public NegoziController() {

    negDao = new NegoziDaoController();
    // negDao.openConnection("db_test");
    // negDao.openConnection("sql12609785");

    ingDao = new IngredientiDao();
    // ingDao.openConnection("db_test");
  }

  /*
   * @RequestMapping(value="getNegozio", method = RequestMethod.GET)
   * public Negozio getNegozio(@RequestParam("id") int id){
   * 
   * return negDao.getNegozio(id);
   * }
   */

  @RequestMapping(value = "getNegozioPos", method = RequestMethod.GET)
  public Negozio getNegozioPos(@RequestParam("long") float longi, @RequestParam("lat") float lat) {

    return negDao.getNegozioByPos(lat, longi);

  }

  @RequestMapping(value = "getNegozio", method = RequestMethod.GET)
  public Negozio getNegozio(@RequestParam("id") int id) {

    Negozio negozio = negDao.getNegozio(id);
    ArrayList<Ingredienti> ingredienti = negDao.getIngredNegozio(id);
    negozio.setIngNegozio(ingredienti);
    // ingredienti.forEach((ing) -> negozio.getIngNegozio().add(ing));

    return negozio;
  }

  @RequestMapping(value = "getNegozi", method = RequestMethod.GET)
  public ArrayList<Negozio> getNegozi(@RequestParam("idAz") int id) {

    return negDao.getNegozi(id);
  }

  @RequestMapping(value = "postNegozio", method = RequestMethod.POST)
  public void addNegozio(@RequestBody Negozio p) {

    negDao.postNegozio(p);
  }

  @RequestMapping(value = "deleteNegozio", method = RequestMethod.DELETE)
  public void deleteNegozio(@RequestParam("id") int id) {

    negDao.deleteIngredientiNegozio(id);
    negDao.deleteNegozio(id);
  }

  

  // http://localhost:8080/NegoziCtrl/utente/1/cerca/negozio
  @RequestMapping(value = "utente/{id}/cerca/negozio", method = RequestMethod.GET)
  public ArrayList<Negozio> getCercaNegozi(@PathVariable("id") int idUtente) {
    ArrayList<Ingredienti> carrello = ingDao.getAllIngredientiCarrello(idUtente);

    return negDao.getCercaNegozio(idUtente, carrello);
  }

  // http://localhost:8080/NegoziCtrl/utente/1/cerca/negozio/distanza
  @RequestMapping(value = "utente/{id}/cerca/negozio/distanza", method = RequestMethod.GET)
  public ArrayList<Negozio> getCercaNegoziOrdinato(@PathVariable("id") int idUtente,
      @RequestParam("latitudineUtente") double latitudineUtente,
      @RequestParam("longitudineUtente") double longitudineUtente,
      @RequestParam("distanzaMax") double distanzaMax) {

    ArrayList<Ingredienti> carrelloIngredienti = ingDao.getAllIngredientiCarrello(idUtente);

    ArrayList<Negozio> listaNegoizi = negDao.getCercaNegozio(idUtente, carrelloIngredienti);

    return negDao.getNegoziOrdiantiDistanzaUtente(listaNegoizi, latitudineUtente, longitudineUtente, distanzaMax);
  }

  // http://localhost:8080/NegoziCtrl/aggiungi/ingrediente/ingredienti
  @RequestMapping(value = "aggiungi/ingrediente/ingredienti", method = RequestMethod.POST)
  public Ingredienti inserisciIngrediente(@RequestBody Ingredienti i) {
    negDao.insertIngredienti(i);
    
    return ingDao.getLastIngrediente();
  
  }

  // http://localhost:8080/NegoziCtrl/associaANegozio
  @RequestMapping(value = "associaANegozio", method = RequestMethod.POST)
  public void associaANegozio(int idIngrediente, float valore, float prezzo, String unitàMisura, int idNegozio) {
   
    negDao.associaANegozio(idIngrediente, valore, prezzo, unitàMisura, idNegozio);
  }

}
