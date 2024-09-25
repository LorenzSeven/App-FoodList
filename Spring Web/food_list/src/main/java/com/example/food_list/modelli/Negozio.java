package com.example.food_list.modelli;

import java.util.ArrayList;

public class Negozio {

    public Negozio() {
        super();
    }

    private int id;

    private String nome;

    private String indirizzo;

    private String orari;

    private int idUtenteAz;

    private double latitudine;

    private double longitudine;
    private String immagineNegozio;

    public String getImmagineNegozio() {
        return immagineNegozio;
    }

    public void setImmagineNegozio(String immagineNegozio) {
        this.immagineNegozio = immagineNegozio;
    }

    float prezzoTotaleIngredienti;
    double distanza;

    int ingredientiPresenti;

    public int getIngredientiPresenti() {
        return ingredientiPresenti;
    }

    public void setIngredientiPresenti(int ingredientiPresenti) {
        this.ingredientiPresenti = ingredientiPresenti;
    }

    ArrayList<Ingredienti> ingNegozio;

    public Negozio(String nome, String indirizzo, String orari, int idUtenteAz, double latitudine, double longitudine) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.orari = orari;
        this.idUtenteAz = idUtenteAz;
        this.latitudine = latitudine;
        this.longitudine = longitudine;
    }

    public double getPrezzoTotaleIngredienti() {
        return prezzoTotaleIngredienti;
    }

    public void setPrezzoTotaleIngredienti(float prezzoTotaleIngredienti) {
        this.prezzoTotaleIngredienti = prezzoTotaleIngredienti;
    }

    public Negozio(String nome, String indirizzo, String orari, int idUtenteAz, double latitudine, double longitudine,
            ArrayList<Ingredienti> ingNegozio) {

        id = 0;

        this.nome = nome;

        this.indirizzo = indirizzo;

        this.orari = orari;

        this.idUtenteAz = idUtenteAz;

        this.latitudine = latitudine;

        this.longitudine = longitudine;

        this.ingNegozio = ingNegozio;

    }

    public Negozio(int id, String nome, String indirizzo, String orari, int idUtenteAz, double latitudine,
            double longitudine, ArrayList<Ingredienti> ingNegozio) {

        this.id = id;

        this.nome = nome;

        this.indirizzo = indirizzo;

        this.orari = orari;

        this.idUtenteAz = idUtenteAz;

        this.latitudine = latitudine;

        this.longitudine = longitudine;

        this.ingNegozio = ingNegozio;

    }

    public Negozio(int id, String nome, String indirizzo, String orari, int idUtenteAz, double latitudine,
            double longitudine, ArrayList<Ingredienti> ingNegozio, String immagineNegozio) {

        this.id = id;

        this.nome = nome;

        this.indirizzo = indirizzo;

        this.orari = orari;

        this.idUtenteAz = idUtenteAz;

        this.latitudine = latitudine;

        this.longitudine = longitudine;

        this.ingNegozio = ingNegozio;

        this.immagineNegozio = immagineNegozio;

    }

    public Negozio(int id, String nome, String indirizzo, String orari, int idUtenteAz, double latitudine,
            double longitudine, ArrayList<Ingredienti> ingNegozio, float prezzoTotaleIngredienti) {

        this.id = id;

        this.nome = nome;

        this.indirizzo = indirizzo;

        this.orari = orari;

        this.idUtenteAz = idUtenteAz;

        this.latitudine = latitudine;

        this.longitudine = longitudine;

        this.ingNegozio = ingNegozio;

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

    public void setLatitudine(double latitudine) {
        this.latitudine = latitudine;
    }

    public double getLongitudine() {
        return longitudine;
    }

    public void setLongitudine(double longitudine) {
        this.longitudine = longitudine;
    }

    public ArrayList<Ingredienti> getIngNegozio() {
        return ingNegozio;
    }

    public void setIngNegozio(ArrayList<Ingredienti> ingNegozio) {
        this.ingNegozio = ingNegozio;
    }

    @Override
    public String toString() {
        return "Negozio [id=" + id + " ,nome" + nome + ",indirizzo=" + indirizzo + ",orari=" + orari + ",idUtenteAz="
                + idUtenteAz + ",latitudine=" + latitudine + ",longitudine=" + longitudine + ",Ingredienti in vendita="
                + ingNegozio + "]";
    }

    public void setDistanza(double distanzaN) {
        this.distanza = distanzaN;
    }

    public double getDistanza() {
        return distanza;
    }
}
