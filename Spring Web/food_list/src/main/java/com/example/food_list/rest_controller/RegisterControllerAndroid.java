package com.example.food_list.rest_controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.food_list.dao.userDaoController;
import com.example.food_list.modelli.Utente;
import com.example.food_list.modelli.UtenteAzienda;

@RestController
@RequestMapping(value="User")
public class RegisterControllerAndroid {
    
 
    userDaoController userDao = null;


    public RegisterControllerAndroid(){

        userDao = new userDaoController();
        //userDao.openConnection("sql12609785");
    }

        //http:localhost:8080/User/registerUtente
        @RequestMapping(value="registerUtente", method = RequestMethod.POST)
        public void addUtente(@RequestBody Utente utente) {

            System.out.println("aggiunto in utenti: " + utente.getId() + " " + utente.getNomeUtente() + " " + utente.getEmailUtente() + " " + utente.getPassword());
            userDao.addUtente(utente);
        }

        //http:localhost:8080/User/registerAzienda
        @RequestMapping(value="registerAzienda", method = RequestMethod.POST)
        public void addAzienda(@RequestBody UtenteAzienda azienda) {
            System.out.println("aggiunto in aziende: " + azienda.getId() + " " + azienda.getBrandAzienda() + " " + azienda.getEmailAzienda() + " " + azienda.getPasswordAzienda());
            userDao.addAzienda(azienda);
        }

        //username
        //email
        //password
}    

