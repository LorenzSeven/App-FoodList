package com.example.food_list_app.oggetti;

public class Ingrediente {
    private int id;
    private String nome;
    private String marca;
    private float valore;
    private float prezzo;
    private String unitàMisura;
    private String valoreUnitàMisura;

    private boolean isChecked;

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

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public void setValoreUnitàMisura(String valoreUnitàMisura) {
        this.valoreUnitàMisura = valoreUnitàMisura;
    }

    public boolean getIsChecked() { return isChecked; }

    public void setIsChecked(boolean isCheded) {
        this.isChecked = isCheded;
    }


    public Ingrediente(int id, String nome, String marca, float prezzo, float valore, String unitàMisura) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.prezzo = prezzo;
        this.valore = valore;
        this.unitàMisura = unitàMisura;
        this.valoreUnitàMisura = valore + unitàMisura;
        isChecked = false;
    }

    public Ingrediente(int id, String nome, String marca, float valore, String unitàMisura) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.prezzo = 0;
        this.valore = valore;
        this.unitàMisura = unitàMisura;
        this.valoreUnitàMisura = valore + unitàMisura;
        isChecked = false;
    }

    public Ingrediente(String nome, String marca, float valore, String unitàMisura, float prezzo) {
        this.id = 0;
        this.nome = nome;
        this.marca = marca;
        this.prezzo = prezzo;
        this.valore = valore;
        this.unitàMisura = unitàMisura;
        this.valoreUnitàMisura = valore + unitàMisura;
        isChecked = false;
    }
    public Ingrediente(String nome) { //esempio usato
        this.nome = nome;
    }

    public  Ingrediente(String nome,String marca){
        this.nome =  nome;
        this.marca = marca;
    }

}
