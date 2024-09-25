package com.example.food_list.rest_controller;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.food_list.dao.userDaoController;
import com.example.food_list.modelli.Utente;
import com.example.food_list.modelli.UtenteAzienda;

@RestController
@RequestMapping(value="User")
public class LoginController {
    
    ArrayList<Utente> utenti = null;
    userDaoController userDao = null;

    public LoginController() {
        userDao = new userDaoController();
        //userDao.openConnection("db_test");
    }

  
    //http://localhost:8080/User/login
    @RequestMapping(value="login", method=RequestMethod.POST)
    public Utente returnUserData(@RequestParam("emailUtente") String emailUtente, 
    @RequestParam("passwordUtente") String passwordUtente) {

            
    return userDao.getUtente(emailUtente, passwordUtente);
    }  
    
    //http:localhost:8080/User/loginAzienda
    @RequestMapping(value="loginAzienda", method=RequestMethod.POST)
    public UtenteAzienda returnAziendaData(@RequestParam("emailAzienda") String emailAzienda, 
    @RequestParam("passwordAzienda") String passwordAzienda) {

            
    return userDao.getAzienda(emailAzienda, passwordAzienda);
    }  

    
}
