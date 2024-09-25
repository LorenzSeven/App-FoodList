package com.example.food_list.dao;

import java.sql.*;
import java.util.ArrayList;
import com.example.food_list.modelli.Ingredienti;

public class IngredientiDao {

    public ArrayList<Ingredienti> getIngredienti() {
        ArrayList<Ingredienti> lista = new ArrayList<>();
        Statement cmd;

        try {
            Dao.getINSTANCE();
            cmd = Dao.con.createStatement();
            String query = "SELECT * FROM ingredienti";
            ResultSet res = cmd.executeQuery(query);

            while (res.next()) {
                int idRec = res.getInt("id");
                String nomeRec = res.getString("nome");
                String marcaRec = res.getString("marca");
                String unitàMisuraRec = res.getString("unità_misura");
                float valoreRec = res.getFloat("valore");

                Ingredienti i = new Ingredienti(idRec, nomeRec, marcaRec, valoreRec, unitàMisuraRec);
                lista.add(i);
            }
            res.close();
            cmd.close();
        } catch (SQLException e) {
            System.out.println("Errore metodo getIngredietni: " + e.getMessage());

        }

        System.out.println("Metodo getIngredienti --> Ok");

        return lista;
    }

    public Ingredienti getIngrediente(int id) {
        Ingredienti i;
        Statement cmd;
        try {

            Dao.getINSTANCE();
            cmd = Dao.con.createStatement();
            String query = "SELECT * FROM ingredienti WHERE id = " + id;
            ResultSet res = cmd.executeQuery(query);
            System.out.println(query);

            while (res.next()) {
                int idRec = res.getInt("id");
                String nomeRec = res.getString("nome");
                String marcaRec = res.getString("marca");
                String unitàMisuraRec = res.getString("unità_misura");
                float valoreRec = res.getFloat("valore");

                i = new Ingredienti(idRec, nomeRec, marcaRec, valoreRec, unitàMisuraRec);
                return i;
            }
            res.close();
            cmd.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    public Ingredienti getIngredienteNome(String nome) {
        Ingredienti i;
        Statement cmd;
        try {
            Dao.getINSTANCE();
            cmd = Dao.con.createStatement();
            String query = "SELECT * FROM ingredienti WHERE nome like '" + nome + "'";
            ResultSet res = cmd.executeQuery(query);
            System.out.println(query);

            while (res.next()) {
                int idRec = res.getInt("id");
                String nomeRec = res.getString("nome");
                String marcaRec = res.getString("marca");
                String unitàMisuraRec = res.getString("unità_misura");
                float valoreRec = res.getFloat("valore");

                i = new Ingredienti(idRec, nomeRec, marcaRec, valoreRec, unitàMisuraRec);
                return i;
            }
            res.close();
            cmd.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    // ritorna tutti gli ingredienti di una ricetta
    public ArrayList<Ingredienti> getAllIngriedientiRicetta(int id) {
        ArrayList<Ingredienti> listaIngredienti = new ArrayList<>();
        Statement cmd;

        try {
            Dao.getINSTANCE();
            cmd = Dao.con.createStatement();
            String query = "SELECT * FROM ingredienti join contengono on ingredienti.id = contengono.id_ingrediente where contengono.id_ricetta = "
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

    public int insertIngredienteVedono(Ingredienti i) {
        Statement cmd;
        try {
            Dao.getINSTANCE();
            cmd = Dao.con.createStatement();
            String query = "INSERT INTO ingredienti (nome, marca,unità_misura,valore) VALUES ('" +
                    i.getNome() + "', '" + i.getMarca() + "', '" +
                    i.getUnitàMisura() + "', " + i.getValore() + ")";
            int id = cmd.executeUpdate(query);

            cmd.close();

            return id;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1000;
    }

    public void insertIngredienteCarrello(int idUtente, ArrayList<Integer> idlistaIngredienti) {
        int quantità = 1;
        Statement cmd;
        for (Integer integer : idlistaIngredienti) {
            try {
                Dao.getINSTANCE();
                cmd = Dao.con.createStatement();
                String query = "INSERT INTO aggiungono(quantità,id_utente,id_ingrediente) VALUES(" + quantità + ","
                        + idUtente + "," + integer.intValue() + ")";
                // int id =
                cmd.executeUpdate(query);

                cmd.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        System.out.println(
                "insert Ingredienti nel Carrello --> OK" + "Q:" + quantità + " | n°" + idlistaIngredienti.size());

    }

    public int insertVendono(float prezzo, int idNegozio, int idIngrediente) {
        Statement cmd;
        try {
            Dao.getINSTANCE();
            cmd = Dao.con.createStatement();

            String query = "INSERT INTO vendono(prezzo,id_negozio,id_ingrediente) VALUES(" + prezzo + "," + idNegozio
                    + "," + idIngrediente + ")";
            int id = cmd.executeUpdate(query);
            cmd.close();

            return id;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1000;
    }

    public int getIdIngrediente(Ingredienti i) {
        int idIngrediete = 0;
        Statement cmd;
        try {
            Dao.getINSTANCE();
            cmd = Dao.con.createStatement();
            String query = "SELECT id FROM ingredienti WHERE nome like '" + i.getNome() + "' AND marca like '"
                    + i.getMarca() + "' AND valore=" + i.getValore();
            ResultSet res = cmd.executeQuery(query);
            System.out.println(query);

            while (res.next()) {
                idIngrediete = res.getInt("id");

            }
            res.close();
            cmd.close();

            return idIngrediete;
        } catch (SQLException e) {
            e.getStackTrace();
        }

        return -888;

    }

    // ritorna tutti gli ingredienti di una ricetta
    public ArrayList<Ingredienti> getAllIngredientiCarrello(int idUtente) {
        ArrayList<Ingredienti> listaIngredienti = new ArrayList<>();
        Statement cmd;

        try {
            Dao.getINSTANCE();
            cmd = Dao.con.createStatement();
            String query = "SELECT * FROM ingredienti join aggiungono on ingredienti.id = aggiungono.id_ingrediente where aggiungono.id_utente ="
                    + idUtente;
            ResultSet result = cmd.executeQuery(query);

            while (result.next()) {
                int idRec = result.getInt("id");
                String nomeRec = result.getString("nome");
                String marcaRec = result.getString("marca");
              /*  String unitàMisuraRec = result.getString("unità_misura");
                float valoreRec = result.getFloat("valore");
                Ingredienti i = new Ingredienti(idRec, nomeRec, marcaRec, valoreRec, unitàMisuraRec);*/ 
                Ingredienti i  = new Ingredienti(idRec, nomeRec, marcaRec);
                listaIngredienti.add(i);
            }
            result.close();
            cmd.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Metodo getAllIngredientiCarrello --> Ok");
        return listaIngredienti;
    }

    // elimina associazzione ingredienti e vendono dato un id dalla tabella
    // Aggiungono
    public void deleteAggiungono(int idIngrediente, int idUtente) {
        Statement cmd;

        try {
            Dao.getINSTANCE();
            cmd = Dao.con.createStatement();
            String query = "DELETE FROM aggiungono WHERE id_ingrediente = " + idIngrediente
                    + " AND id_utente = "
                    + idUtente;
            cmd.executeUpdate(query);

            cmd.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Metodo deleteaggiungono --> Ok ");
    }

    // elimina associazzione ingredienti e vendono dato un id
    public void deleteVendono(int idIngrediente, int idNegozio) {
        Statement cmd;

        try {
            Dao.getINSTANCE();
            cmd = Dao.con.createStatement();
            String query = "DELETE FROM vendono WHERE id_ingrediente = " + idIngrediente + " AND id_negozio = "
                    + idNegozio;
            cmd.executeUpdate(query);

            cmd.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Metodo deleteAggiungono --> Ok ");
    }

    // elimina associazzione ingredienti e vendono dato un id
    public void deleteIngrediente(int idIngrediente) {
        Statement cmd;

        try {
            Dao.getINSTANCE();
            cmd = Dao.con.createStatement();
            String query = "DELETE FROM ingredienti WHERE id = " + idIngrediente;
            cmd.executeUpdate(query);

            cmd.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Metodo delteIngrediente --> Ok ");
    }

    //prendi l'ultimo ingrediente inserito

    public Ingredienti getLastIngrediente() {
        Ingredienti i;
        Statement cmd;
        try {

            Dao.getINSTANCE();
            cmd = Dao.con.createStatement();
            String query = "SELECT * FROM ingredienti ORDER BY id DESC LIMIT 1";
            ResultSet res = cmd.executeQuery(query);
            System.out.println(query);

            while (res.next()) {
                int idRec = res.getInt("id");
                String nomeRec = res.getString("nome");
                String marcaRec = res.getString("marca");
                
                i = new Ingredienti(idRec, nomeRec, marcaRec);
                return i;
            }
            res.close();
            cmd.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

}