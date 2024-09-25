package com.example.food_list.modelli;

public class Ingredienti {
    private int id;
    private String nome;
    private String marca;
    private float valore;
    private String unitàMisura;
    private String valoreUnitàMisura; // composto da valore+unitàMiusra
    private float prezzo;

    public Ingredienti(){
        super();
    }

    public Ingredienti(int id, String nome, String marca){
        this.id = id;
        this.nome = nome;
        this.marca = marca;
    }

    public Ingredienti(String nome, String marca, float valore, String unitàMisura) {
        this.id = 0;
        this.nome = nome;
        this.marca = marca;
        this.valore = valore;
        this.unitàMisura = unitàMisura;
        this.valoreUnitàMisura = valore + unitàMisura;
        this.prezzo = 0;
    }
    public Ingredienti(String nome, String marca, float valore, String unitàMisura, float prezzo) {
        this.id = 0;
        this.nome = nome;
        this.marca = marca;
        this.valore = valore;
        this.unitàMisura = unitàMisura;
        this.valoreUnitàMisura = valore + unitàMisura;
        this.prezzo = prezzo;
    }

    public Ingredienti(int idRec, String nome, String marca, float valore, String unitàMisura) {
        this.id = idRec;
        this.nome = nome;
        this.marca = marca;
        this.valore = valore;
        this.unitàMisura = unitàMisura;
        this.valoreUnitàMisura = valore + unitàMisura;
        this.prezzo = 0;
    }

    public Ingredienti(int id, String nome, String marca, float valore, String unitàMisura, String valoreUnitàMisura,
            float prezzo) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.valore = valore;
        this.unitàMisura = unitàMisura;
        this.valoreUnitàMisura = valoreUnitàMisura;
        this.prezzo = prezzo;
    }

    public Ingredienti(int id, String nome, String marca, float valore, String unitàMisura, float prezzo) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.valore = valore;
        this.unitàMisura = unitàMisura;
        this.prezzo = prezzo;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getValore() {
        return valore;
    }

    public void setValore(float valore) {
        this.valore = valore;
    }

    public String getUnitàMisura() {
        return unitàMisura;
    }

    public void setUnitàMisura(String unitàMisura) {
        this.unitàMisura = unitàMisura;
    }

    public String getValoreUnitàMisura() {
        return valoreUnitàMisura;
    }

    public void setValoreUnitàMisura(String valoreUnitàMisura) {
        this.valoreUnitàMisura = valoreUnitàMisura;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

}
