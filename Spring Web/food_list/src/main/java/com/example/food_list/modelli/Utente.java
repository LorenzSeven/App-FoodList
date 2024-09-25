package com.example.food_list.modelli;

//definisco gli attributi dell'utente
public class Utente {
    Integer id;
    public String nomeUtente;
    public String emailUtente;
    public String passwordUtente;
    public String immagineUtente;

    public Utente(Integer id, String username, String email, String password, String immagine_profilo) {
        this.id = id;
        nomeUtente = username;
        emailUtente = email;
        passwordUtente = password;
        immagineUtente = immagine_profilo;
    }

    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = 0;
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

    public String getPassword () {
        return passwordUtente;
    }
    public void setPasswordUtente(String passwordUtente) {
        this.passwordUtente = passwordUtente;
    }

    public String getImmagineUtente () {
        return immagineUtente;
    }
    public void setImmagineUtente(String immagineUtente) {
        this.immagineUtente = immagineUtente;
    }
}
