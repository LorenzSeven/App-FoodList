package com.example.food_list_app.oggetti;

//definisco gli attributi dell'utente
public class UtenteConsumer {
    Integer id;
    String nomeUtente;
    String emailUtente;
    String passwordUtente;
    String immagineUtente;

    public UtenteConsumer(Integer id, String username, String email, String password, String immagine_profilo) {
        System.out.println("Costruttore Utente");
        System.out.println("DOPO INIT IdUtente Costruttore Utente");

        this.id = id;
        nomeUtente = username;
        emailUtente = email;
        passwordUtente = password;
        immagineUtente = immagine_profilo;
        System.out.println("FINE Costruttore Utente");
    }

    public UtenteConsumer(Integer id, String nomeUtente, String emailUtente, String passwordUtente) {
        this.id = id;
        this.nomeUtente = nomeUtente;
        this.emailUtente = emailUtente;
        this.passwordUtente = passwordUtente;
    }

    public Integer getId() {
        System.out.println("PRIMA RETURN IdUtente");
        return id;
    }

    public void setId(Integer id) {
        System.out.println("PRIMA SET IdUtente");
        this.id = 0;
        System.out.println("DOPO SET IdUtente");
    }

    public String getNomeUtente() {
        return nomeUtente;
    }

    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    public String getEmailUtente() {
        return emailUtente;
    }

    public void setEmailUtente(String emailUtente) {
        this.emailUtente = emailUtente;
    }

    public String getPassword() {
        return passwordUtente;
    }

    public void setPasswordUtente(String passwordUtente) {
        this.passwordUtente = passwordUtente;
    }

    public String getImmagineUtente() {
        return immagineUtente;
    }

    public void setImmagineUtente(String immagineUtente) {
        this.immagineUtente = immagineUtente;
    }
}
