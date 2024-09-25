package com.example.food_list.modelli;

//definisco gli attributi dell'utente
public class UtenteAzienda {
    Integer id;
    public String emailAzienda;
    public String passwordAzienda;
	public String brandAzienda;
    public String immagineAzienda;
	public String sedeAzienda;
	public String PartitaAzienda;

    public UtenteAzienda(Integer id, String email, String password, String brand, String immagine, String sedeLegale, String PartitaIva) {
        this.id = id;
        emailAzienda = email;
        passwordAzienda = password;
		brandAzienda = brand;
        immagineAzienda = immagine;
		sedeAzienda = sedeLegale;
		PartitaAzienda = PartitaIva;
    }

    public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmailAzienda() {
		return emailAzienda;
	}
	public void setEmailAzienda(String emailAzienda) {
		this.emailAzienda = emailAzienda;
	}

    public String getPasswordAzienda() {
        return passwordAzienda;
    }
    public void setPasswordAzienda(String passwordAzienda) {
        this.passwordAzienda = passwordAzienda;
    }

    public String getBrandAzienda () {
        return brandAzienda;
    }
    public void setBrandAzienda(String brandAzienda) {
        this.brandAzienda = brandAzienda;
    }

    public String getImmagineAzienda () {
        return immagineAzienda;
    }
    public void setImmagineAzienda(String immagineAzienda) {
        this.immagineAzienda = immagineAzienda;
    }

    public String getSedeAzienda () {
        return sedeAzienda;
    }
    public void setSedeAzienda(String sedeAzienda) {
        this.sedeAzienda = sedeAzienda;
    }

    public String getPartitaAzienda () {
        return PartitaAzienda;
    }
    public void setPartitaAzienda(String partitaAzienda) {
        this.PartitaAzienda = partitaAzienda;
    }

}
