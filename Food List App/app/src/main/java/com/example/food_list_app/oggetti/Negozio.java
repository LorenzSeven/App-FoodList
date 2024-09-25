package com.example.food_list_app.oggetti;

import java.util.ArrayList;

public class Negozio {

    private int id;

    private String nome;

    private String indirizzo;

    private String orari;

    private int idUtenteAz;

    private double latitudine;

    private double longitudine;


    float prezzoTotaleIngredienti;
    float distanza;

    int ingredientiPresenti;


    public int getIngredientiPresenti() {
        return ingredientiPresenti;
    }

    public void setIngredientiPresenti(int ingredientiPresenti) {
        this.ingredientiPresenti = ingredientiPresenti;
    }

    private String immagineNegozio;

    public String getImmagineNegozio() {
        return immagineNegozio;
    }

    public void setImmagineNegozio(String immagineNegozio) {
        this.immagineNegozio = immagineNegozio;
    }
    private ArrayList<Ingrediente> ingNegozio;

    public Negozio(String n, String i, String ore, int idAz, double lat, double lon, ArrayList<Ingrediente> ingN) {

        id = 0;
        this.nome = n;
        this.indirizzo = i;
        this.orari = ore;
        this.idUtenteAz = idAz;
        this.latitudine = lat;
        this.longitudine = lon;
        this.ingNegozio = ingN;
    }

    public Negozio(String n, String i, String ore, int idAz, double lat, double lon) {

        id = 0;
        this.nome = n;
        this.indirizzo = i;
        this.orari = ore;
        this.idUtenteAz = idAz;
        this.latitudine = lat;
        this.longitudine = lon;
    }

    public Negozio(int id, String n, String i, String ore, int idAz, double lat, double lon, ArrayList<Ingrediente> ingN) {

        this.id = id;
        this.nome = n;
        this.indirizzo = i;
        this.orari = ore;
        this.idUtenteAz = idAz;
        this.latitudine = lat;
        this.longitudine = lon;
        this.ingNegozio = ingN;
    }
    public Negozio(int id, String n, String i, String ore, int idAz, double lat, double lon, ArrayList<Ingrediente> ingN, float prezzoTotaleIngredienti) {

        this.id = id;
        this.nome = n;
        this.indirizzo = i;
        this.orari = ore;
        this.idUtenteAz = idAz;
        this.latitudine = lat;
        this.longitudine = lon;
        this.ingNegozio = ingN;
        this.prezzoTotaleIngredienti = prezzoTotaleIngredienti;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getOrari() {
        return orari;
    }

    public void setOrari(String orari) {
        this.orari = orari;
    }

    public int getIdUtenteAz() {
        return idUtenteAz;
    }

    public void setIdUtenteAz(int idUtenteAz) {
        this.idUtenteAz = idUtenteAz;
    }

    public double getLatitudine() {
        return latitudine;
    }

    public void setLatitudine(float latitudine) {
        this.latitudine = latitudine;
    }

    public double getLongitudine() {
        return longitudine;
    }

    public void setLongitudine(double longitudine) {
        this.longitudine = longitudine;
    }

    public float getPrezzoTotaleIngredienti() {
        return prezzoTotaleIngredienti;
    }

    public void setPrezzoTotaleIngredienti(float prezzoTotaleIngredienti) {
        this.prezzoTotaleIngredienti = prezzoTotaleIngredienti;
    }

    public  float getDistanza(){
        return  distanza;
    }
    public  void setDistanza(float distanza){
        this.distanza = distanza;
    }
    public ArrayList<Ingrediente> getIngNegozio() {
        return ingNegozio;
    }

    public void setIngNegozio(ArrayList<Ingrediente> ingNegozio) {
        this.ingNegozio = ingNegozio;
    }

    @Override
    public String toString() {
        return "Negozio:[id= " + id + ", nome= " + nome + ", indirizzo= " + indirizzo + ", orari= " + orari + ", idUtenteAz= " + idUtenteAz + ", latitudine= " + latitudine + ", longitudine= " + longitudine + ", ingredienti negozio= " + ingNegozio + "]";
    }
}