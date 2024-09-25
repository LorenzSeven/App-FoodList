package com.example.food_list.rest_controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.food_list.dao.userDaoController;
import com.example.food_list.modelli.Utente;
import com.example.food_list.modelli.UtenteAzienda;

@CrossOrigin
@RestController
@RequestMapping(value = "User")
public class LoginControllerSito {

    ArrayList<Utente> utenti = null;
    userDaoController userDao = null;

    public LoginControllerSito() {
        userDao = new userDaoController();
        // userDao.openConnection("db_test");
    }

    // http:localhost:8080/User/sitoLogin
    @RequestMapping(value = "sitoLogin", method = RequestMethod.POST)
    public Utente returnUserData(@RequestParam("emailUtente") String emailUtente,
            @RequestParam("passwordUtente") String passwordUtente) {

        return userDao.getUtenteSito(emailUtente, passwordUtente);
    }

    // http:localhost:8080/User/sitoLoginAzienda
    @RequestMapping(value = "sitoLoginAzienda", method = RequestMethod.POST)
    public UtenteAzienda returnAzData(@RequestParam("emailAzienda") String emailAzienda,
            @RequestParam("passwordAzienda") String passwordAzienda) {

        return userDao.getAziendaSito(emailAzienda, passwordAzienda);
    }

    // http:localhost:8080/User/profilo/consumer?passwordUtente=prova&emailUtente=ok
    @RequestMapping(value = "profilo/consumer")
    public Utente returnUserDataConsumer(@RequestParam("emailUtente") String emailUtente,
            @RequestParam("passwordUtente") String passwordUtente) {
        return userDao.getUtenteSito(emailUtente, passwordUtente);
    }
       // http:localhost:8080/User/profilo/azienda
       @RequestMapping(value = "profilo/azienda", method = RequestMethod.GET)
       public UtenteAzienda returnAzDataAzienda(@RequestParam("emailAzienda") String emailAzienda,
               @RequestParam("passwordAzienda") String passwordAzienda) {

           return userDao.getAziendaSito(emailAzienda, passwordAzienda);
       }
}
