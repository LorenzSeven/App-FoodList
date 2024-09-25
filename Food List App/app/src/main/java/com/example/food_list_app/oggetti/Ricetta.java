package com.example.food_list_app.oggetti;

import java.util.ArrayList;

public class Ricetta
{
    // metodo prendi ricetta per id
    // metodo prendi ricetta per tipo di piatto: antipasto
    // metodo prendi ingredienti di una ricetta
    // metodo inserisci gli ingredienti per la ricetta

    private int id;
    private String nome;
    private String tipo;
    private String nazionalità;
    private String tempo_preparazione;
    private String difficoltà;
    private String descrizione;
    private String immagine;
    private ArrayList<Ingrediente> lista_ingredienti; // gli ingredienti vengono inseriti dopo
    private float costo; // il costo è calcolato

    public Ricetta(String nome, String tipo, String nazionalità, String tempo_preparazione, String difficoltà, String descrizione, String immagine) {
        this.nome = nome;
        this.tipo = tipo;
        this.nazionalità = nazionalità;
        this.tempo_preparazione = tempo_preparazione;
        this.difficoltà = difficoltà;
        this.descrizione = descrizione;
        this.immagine = immagine;
        this.lista_ingredienti = null;
        this.costo = 0;
    }

    public Ricetta(int id, String nome, String tipo, String nazionalità, String tempo_preparazione, String difficoltà,
                   String descrizione, String immagine) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.nazionalità = nazionalità;
        this.tempo_preparazione = tempo_preparazione;
        this.difficoltà = difficoltà;
        this.descrizione = descrizione;
        this.immagine = immagine;
        this.lista_ingredienti = null;
        this.costo = 0;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNazionalità() {
        return nazionalità;
    }

    public void setNazionalità(String nazionalità) {
        this.nazionalità = nazionalità;
    }

    public String getTempo_preparazione() {
        return tempo_preparazione;
    }

    public void setTempo_preparazione(String tempo_preparazione) {
        this.tempo_preparazione = tempo_preparazione;
    }

    public String getDifficoltà() {
        return difficoltà;
    }

    public void setDifficoltà(String difficoltà) {
        this.difficoltà = difficoltà;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public ArrayList<Ingrediente> getLista_ingredienti() {
        return lista_ingredienti;
    }

    public void setLista_ingredienti(ArrayList<Ingrediente> lista_ingredienti) {
        this.lista_ingredienti = lista_ingredienti;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Ricetta [id=" + id +
                ", nome=" + nome +
                ", tipo=" + tipo +
                ", nazionalità=" + nazionalità +
                ", tempo_preparazione=" + tempo_preparazione +
                ", difficoltà=" + difficoltà +
                ", descrizione=" + descrizione +
                ", immagine=" + immagine +
                ", lista_ingredienti=" + lista_ingredienti +
                ", costo=" + costo + "]";
    }

}
