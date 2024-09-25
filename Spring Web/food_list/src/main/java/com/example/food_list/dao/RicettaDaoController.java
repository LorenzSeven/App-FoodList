package com.example.food_list.dao;

import java.sql.*;
import java.util.ArrayList;

import com.example.food_list.modelli.Ingredienti;
import com.example.food_list.modelli.Ricetta;

public class RicettaDaoController {

    // ritorna la singola ricetta
    public Ricetta getRicetta(int id) {
        Ricetta r = null;
        Statement cmd;

        try {
            Dao.getINSTANCE();
            cmd = Dao.con.createStatement();
            String query = "SELECT * FROM Ricette where id = " + id;
            ResultSet result = cmd.executeQuery(query);

            while (result.next()) {
                int idRec = result.getInt("id");
                String nomeRec = result.getString("nome");
                String tipoRec = result.getString("tipo");
                String nazionalitàRec = result.getString("nazionalità");
                String tempo_preparazioneRec = result.getString("tempo_preparazione");
                String difficoltàRec = result.getString("difficoltà");
                String descrizioneRec = result.getString("descrizione");
                String immagineRec = result.getString("immagine");
                ArrayList<Ingredienti> ingredientiRec = null;

                r = new Ricetta(idRec, nomeRec, tipoRec, nazionalitàRec, tempo_preparazioneRec, difficoltàRec,
                        descrizioneRec, immagineRec, ingredientiRec);

            }
            result.close();
            cmd.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }

        System.out.println("Metodo getRicetta --> Ok");
        return r;
    }

    // ritorna tutte le ricette
    public ArrayList<Ricetta> getRicette() {
        ArrayList<Ricetta> listaRicette = new ArrayList<>();
        Statement cmd;

        try {
            Dao.getINSTANCE();
            cmd = Dao.con.createStatement();
            String query = "SELECT * FROM ricette";
            ResultSet result = cmd.executeQuery(query);

            while (result.next()) {
                int idRec = result.getInt("id");
                String nomeRec = result.getString("nome");
                String tipoRec = result.getString("tipo");
                String nazionalitàRec = result.getString("nazionalità");
                String tempo_preparazioneRec = result.getString("tempo_preparazione");
                String difficoltàRec = result.getString("difficoltà");
                String descrizioneRec = result.getString("descrizione");
                String immagineRec = result.getString("immagine");
                ArrayList<Ingredienti> ingredientiRec = null;

                Ricetta r = new Ricetta(idRec, nomeRec, tipoRec, nazionalitàRec, tempo_preparazioneRec, difficoltàRec,
                        descrizioneRec, immagineRec, ingredientiRec);
                listaRicette.add(r);
            }

            result.close();
            cmd.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }

        System.out.println("Metodo getRicette --> Ok");
        return listaRicette;
    }

    // ritorna tutte le ricette per nazionalità
    public ArrayList<Ricetta> getRicetteNazionalità(String nazionalità) {
        ArrayList<Ricetta> listaRicette = new ArrayList<>();
        Statement cmd;

        try {
            Dao.getINSTANCE();
            cmd = Dao.con.createStatement();
            String query = "SELECT * FROM ricette WHERE nazionalità = '" + nazionalità + "'";
            ResultSet result = cmd.executeQuery(query);

            while (result.next()) {
                int idRec = result.getInt("id");
                String nomeRec = result.getString("nome");
                String tipoRec = result.getString("tipo");
                String nazionalitàRec = result.getString("nazionalità");
                String tempo_preparazioneRec = result.getString("tempo_preparazione");
                String difficoltàRec = result.getString("difficoltà");
                String descrizioneRec = result.getString("descrizione");
                String immagineRec = result.getString("immagine");
                ArrayList<Ingredienti> ingredientiRec = null;

                Ricetta r = new Ricetta(idRec, nomeRec, tipoRec, nazionalitàRec, tempo_preparazioneRec, difficoltàRec,
                        descrizioneRec, immagineRec, ingredientiRec);
                listaRicette.add(r);
            }

            result.close();
            cmd.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }

        System.out.println("Metodo getRicetteNazionalità --> Ok");
        return listaRicette;
    }

    // ritorna tutte le ricette per nome
    public ArrayList<Ricetta> getRicetteNome(String nome) {
        ArrayList<Ricetta> listaRicette = new ArrayList<>();
        Statement cmd;

        try {
            Dao.getINSTANCE();
            cmd = Dao.con.createStatement();
            String query = "SELECT * FROM ricette WHERE nome like '" + nome + "%' ORDER BY nome";
            ResultSet result = cmd.executeQuery(query);

            while (result.next()) {
                int idRec = result.getInt("id");
                String nomeRec = result.getString("nome");
                String tipoRec = result.getString("tipo");
                String nazionalitàRec = result.getString("nazionalità");
                String tempo_preparazioneRec = result.getString("tempo_preparazione");
                String difficoltàRec = result.getString("difficoltà");
                String descrizioneRec = result.getString("descrizione");
                String immagineRec = result.getString("immagine");
                ArrayList<Ingredienti> ingredientiRec = null;

                Ricetta r = new Ricetta(idRec, nomeRec, tipoRec, nazionalitàRec, tempo_preparazioneRec, difficoltàRec,
                        descrizioneRec, immagineRec, ingredientiRec);
                listaRicette.add(r);
            }

            result.close();
            cmd.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }

        System.out.println("Metodo getRicetteNome --> Ok");
        return listaRicette;
    }

    // ritorna tutte le ricette per tipo
    public ArrayList<Ricetta> getRicetteTipo(String tipo) {
        ArrayList<Ricetta> listaRicette = new ArrayList<>();
        Statement cmd;

        try {
            Dao.getINSTANCE();
            cmd = Dao.con.createStatement();
            String query = "SELECT * FROM ricette WHERE tipo like '" + tipo + "'";
            ResultSet result = cmd.executeQuery(query);

            while (result.next()) {
                int idRec = result.getInt("id");
                String nomeRec = result.getString("nome");
                String tipoRec = result.getString("tipo");
                String nazionalitàRec = result.getString("nazionalità");
                String tempo_preparazioneRec = result.getString("tempo_preparazione");
                String difficoltàRec = result.getString("difficoltà");
                String descrizioneRec = result.getString("descrizione");
                String immagineRec = result.getString("immagine");
                ArrayList<Ingredienti> ingredientiRec = null;

                Ricetta r = new Ricetta(idRec, nomeRec, tipoRec, nazionalitàRec, tempo_preparazioneRec, difficoltàRec,
                        descrizioneRec, immagineRec, ingredientiRec);
                listaRicette.add(r);
            }

            result.close();
            cmd.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }

        System.out.println("Metodo getRicetteTipo --> Ok");
        return listaRicette;
    }

    // ritorna tutti gli ingredienti di una ricetta
    public ArrayList<Ingredienti> getRicettaIngr(int id) {
        ArrayList<Ingredienti> listaIngredienti = new ArrayList<>();
        Statement cmd;

        try {
            Dao.getINSTANCE();
            cmd = Dao.con.createStatement();
            String query = "SELECT * FROM Ingredienti join contengono on ingredienti.id = contengono.id_ingrediente where contengono.id_ricetta = "
                    + id;
            ResultSet result = cmd.executeQuery(query);

            while (result.next()) {
                int idRec = result.getInt("id");
                String nomeRec = result.getString("nome");
                String marcaRec = result.getString("marca");
                String unitàMisuraRec = result.getString("unità_misura");
                float valoreRec = result.getFloat("valore");
                Ingredienti i = new Ingredienti(idRec, nomeRec, marcaRec, valoreRec, unitàMisuraRec);
                listaIngredienti.add(i);
            }
            result.close();
            cmd.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Metodo getIngredienti --> Ok");
        return listaIngredienti;
    }

    // prendi la ricetta e mettela nella tabella salvano (POST)
    public int postRicetta(int idRicetta, int idUtente) {
        Statement cmd;

        try {
            Dao.getINSTANCE();
            cmd = Dao.con.createStatement();
            String query = "INSERT INTO salvano (id_utente_consumer, id_ricetta) values (\""
                    + idUtente + "\",\"" + idRicetta + "\")";
            int id = cmd.executeUpdate(query);
            cmd.close();
            return id;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Metodo postRicettaInSalvano(Preferiti) --> Ok");
        return -1000;
    }

    // prendi dall'entità salvano e ottieni le ricette che un utente ha salvato
    // (GET)
    public ArrayList<Ricetta> getRicetteDaPrefer(int idUtente) {
        ArrayList<Ricetta> listaRicette = new ArrayList<>();
        Statement cmd;

        try {
            Dao.getINSTANCE();
            cmd = Dao.con.createStatement();
            String query = "SELECT id_utente_consumer, ricette.id, nome, tipo, nazionalità, tempo_preparazione, difficoltà, descrizione, immagine FROM Ricette join salvano on ricette.id = salvano.id_ricetta where id_utente_consumer = "
                    + idUtente;
            ResultSet result = cmd.executeQuery(query);

            while (result.next()) {
                int idRec = result.getInt("id");
                String nomeRec = result.getString("nome");
                String tipoRec = result.getString("tipo");
                String nazionalitàRec = result.getString("nazionalità");
                String tempo_preparazioneRec = result.getString("tempo_preparazione");
                String difficoltàRec = result.getString("difficoltà");
                String descrizioneRec = result.getString("descrizione");
                String immagineRec = result.getString("immagine");
                ArrayList<Ingredienti> ingredientiRec = null;

                Ricetta r = new Ricetta(idRec, nomeRec, tipoRec, nazionalitàRec, tempo_preparazioneRec, difficoltàRec,
                        descrizioneRec, immagineRec, ingredientiRec);
                listaRicette.add(r);
            }
            result.close();
            cmd.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Metodo getRicetteDaPreferiti --> Ok");
        return listaRicette;
    }

    // metodo cancella ricetta dai salvano (preferiti) (DELETE)
    public int deleteRicettaDaPrefer(int idUtente, int idRicetta) {
        Statement cmd;

        try {
            Dao.getINSTANCE();
            cmd = Dao.con.createStatement();
            String query = "Delete from salvano where id_utente_consumer =  " + idUtente + " and id_ricetta = "
                    + idRicetta;
            int id = cmd.executeUpdate(query);
            cmd.close();
            return id;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Metodo deleteRicettaDaSalvano(Preferiti) --> Ok");
        return -1000;
    }

    // metodo prendi gli ingredienti di tutte le ricette che hanno quel tipo (GET)

    public ArrayList<Ricetta> getRicetteIngrperTipo(String tipo) {
        ArrayList<Ricetta> listaRicette = new ArrayList<>();
        Statement cmd;

        try {
            Dao.getINSTANCE();
            cmd = Dao.con.createStatement();
            String query = "SELECT * FROM ricette WHERE tipo like '" + tipo + "'";
            ResultSet result = cmd.executeQuery(query);

            while (result.next()) {
                int idRec = result.getInt("id");
                String nomeRec = result.getString("nome");
                String tipoRec = result.getString("tipo");
                String nazionalitàRec = result.getString("nazionalità");
                String tempo_preparazioneRec = result.getString("tempo_preparazione");
                String difficoltàRec = result.getString("difficoltà");
                String descrizioneRec = result.getString("descrizione");
                String immagineRec = result.getString("immagine");
                ArrayList<Ingredienti> ingredientiRec = getRicettaIngr(idRec);

                Ricetta r = new Ricetta(idRec, nomeRec, tipoRec, nazionalitàRec, tempo_preparazioneRec, difficoltàRec,
                        descrizioneRec, immagineRec, ingredientiRec);
                listaRicette.add(r);
            }

            result.close();
            cmd.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        System.out.println("Metodo getRicetteIngredientiperTipo --> Ok");
        return listaRicette;
    }

    // metodo inserisci gli ingredienti nel carrello (POST)
    public int postCarrello(int quantità, int idUtente, int idIngrediente) {
        Statement cmd;

        try {
            Dao.getINSTANCE();
            cmd = Dao.con.createStatement();
            String query = "insert into aggiungono (quantità, id_utente, id_ingrediente) values (\""
                    + quantità + "\",\"" + idUtente + "\",\"" + idIngrediente + "\")";
            int id = cmd.executeUpdate(query);
            cmd.close();
            return id;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Metodo postCarrello--> Ok");
        return -1000;
    }
    
    // mi da tutti gli ingredienti di quell'ID utente
    public ArrayList<Ingredienti> getIngredientiIdutente(int idUtente) {
        ArrayList<Ingredienti> listaIngredienti = new ArrayList<>();
        Statement cmd;
        try {
            Dao.getINSTANCE();
            cmd = Dao.con.createStatement();
            String query = "SELECT ingredienti.* from ingredienti inner join aggiungono on ingredienti.id = aggiungono.id_ingrediente where id_utente =" + idUtente;
            Ingredienti ingr;
            ResultSet res = cmd.executeQuery(query);
            System.out.println(query);

            while (res.next()) {
                int idRec = res.getInt("ingredienti.id");
                String nomeRec = res.getString("nome");
                String marcaRec = res.getString("marca");
                //String unitàMisuraRec = res.getString("unità_misura");
                //float valoreRec = res.getFloat("valore");

                ingr = new Ingredienti(idRec, nomeRec, marcaRec);
                listaIngredienti.add(ingr);
            }
            res.close();
            cmd.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Metodo getIngredientiIdutente--> Ok");
        return listaIngredienti;
    }

}