package com.example.food_list.dao;

import java.sql.*;
import java.util.ArrayList;

import com.example.food_list.modelli.Ingredienti;
import com.example.food_list.modelli.Negozio;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NegoziDaoController {

    /*
     * public static final String driver = "com.mysql.jdbc.Driver";
     * /*
     * private String url = "jdbc:mysql://localhost:3306/";
     * private String username = "root";
     * private String password = "password";
     */
    /*
     * private static String url = "jdbc:mysql://sql8.freemysqlhosting.net/";
     * private final static String username = "sql8611531";
     * private final static String password = "Vt1cmVypB3";
     * private static Connection con = null;
     */

    /*
     * public void openConnection(String dbName) {
     * try {
     * Class.forName(driver);
     * url += dbName;
     * con = DriverManager.getConnection(url, username, password);
     * } catch (Exception ex) {
     * ex.printStackTrace();
     * }
     * }
     * 
     * public void closeConnection() {
     * 
     * try {
     * con.close();
     * } catch (SQLException e) {
     * e.printStackTrace();
     * }
     * }
     */

    public Negozio getNegozio(int id) {
        Negozio p = null;

        Statement cmd;
        try {
            Dao.getINSTANCE();
            cmd = Dao.con.createStatement();
            String query = "SELECT * FROM negozi WHERE id=" + id;
            ResultSet res = cmd.executeQuery(query);
            while (res.next()) {
                int idRec = res.getInt("id");
                String nome = res.getString("nome");
                String indirizzoRec = res.getString("indirizzo");
                String orariRec = res.getString("orari");
                int idAzRec = res.getInt("id_utente_azienda");
                float latRec = res.getFloat("latitudine");
                float longRec = res.getFloat("longitudine");
                String imgNegRec = res.getString("immagine_negozio");
                ArrayList<Ingredienti> ingNegRec = null;

                p = new Negozio(idRec, nome, indirizzoRec, orariRec, idAzRec, latRec, longRec, ingNegRec, imgNegRec);
            }
            res.close();
            cmd.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    public Negozio getNegozioByPos(float latitudine, float longitudine) {
        Negozio p = null;

        Statement cmd;
        try {
            Dao.getINSTANCE();
            cmd = Dao.con.createStatement();
            String query = "SELECT * FROM negozi WHERE latitudine =" + latitudine + "AND longitudine="
                    + longitudine;
            ResultSet res = cmd.executeQuery(query);
            while (res.next()) {
                int idRec = res.getInt("id");
                String nome = res.getString("nome");
                String indirizzoRec = res.getString("indirizzo");
                String orario = res.getString("orari");
                int idAzRec = res.getInt("id_utente_azienda");
                float latRec = res.getFloat("latitudine");
                float longRec = res.getFloat("longitudine");
                ArrayList<Ingredienti> ingNegRec = getIngredNegozio(idRec);

                p = new Negozio(idRec, nome, indirizzoRec, orario, idAzRec, latRec, longRec, ingNegRec);
            }
            res.close();
            cmd.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    public ArrayList<Negozio> getNegozi(int id) {
        ArrayList<Negozio> puntiVendita = new ArrayList<>();

        Statement cmd;

        try {
            Dao.getINSTANCE();
            cmd = Dao.con.createStatement();
            String query = "SELECT * FROM negozi WHERE id_utente_azienda=" + id;
            ResultSet res = cmd.executeQuery(query);
            System.out.println("Mando Negozi");
            while (res.next()) {
                int idRec = res.getInt("id");
                String nome = res.getString("nome");
                String indirizzoRec = res.getString("indirizzo");
                String orariRec = res.getString("orari");
                int idAzRec = res.getInt("id_utente_azienda");
                float latRec = res.getFloat("latitudine");
                float longRec = res.getFloat("longitudine");
                String immagineNegozio = res.getString("immagine_negozio");
                ArrayList<Ingredienti> ingNegRec = getIngredNegozio(idRec);

                Negozio p = new Negozio(idRec, nome, indirizzoRec, orariRec, idAzRec, latRec, longRec, ingNegRec,
                        immagineNegozio);
                puntiVendita.add(p);
            }
            res.close();
            cmd.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return puntiVendita;
    }

    public ArrayList<Negozio> getCercaNegozio(int idUtente, ArrayList<Ingredienti> carrello) {
        ArrayList<Negozio> negozi = new ArrayList<>();

        Statement cmd;
        String idIngreientiQuery = "";
        for (int i = 0; i < carrello.size(); i++) {
            idIngreientiQuery += carrello.get(i).getId();
            if (i != carrello.size() - 1)
                idIngreientiQuery += ",";

        }
        try {
            Dao.getINSTANCE();
            cmd = Dao.con.createStatement();
            String query = "SELECT negozi.*,sum(vendono.prezzo) AS sum_prezzi,count(ingredienti.id) as ingredienti_presenti FROM negozi JOIN vendono ON negozi.id = vendono.id_negozio JOIN ingredienti ON ingredienti.id = vendono.id_ingrediente JOIN aggiungono ON aggiungono.id_ingrediente = ingredienti.id WHERE aggiungono.id_utente ="
                    + idUtente + " AND ingredienti.id in(" + idIngreientiQuery + ") GROUP BY negozi.id";
            ResultSet res = cmd.executeQuery(query);
            while (res.next()) {
                int idRec = res.getInt("id");
                String nome = res.getString("nome");
                String indirizzoRec = res.getString("indirizzo");
                String orariRec = res.getString("orari");
                int idAzRec = res.getInt("id_utente_azienda");
                float latRec = res.getFloat("latitudine");
                float longRec = res.getFloat("longitudine");
                float prezzoTotaleIngredienti = res.getFloat("sum_prezzi");
                String immagineNegozio = res.getString("immagine_negozio");
                ArrayList<Ingredienti> ingNegRec = getIngredNegozio(idRec);

                Negozio n = new Negozio(idRec, nome, indirizzoRec, orariRec, idAzRec, latRec, longRec, ingNegRec,
                        prezzoTotaleIngredienti);

                int ingredieni_presenti = res.getInt("ingredienti_presenti");
                n.setIngredientiPresenti(ingredieni_presenti);
                n.setImmagineNegozio(immagineNegozio);

                negozi.add(n);
            }
            res.close();
            cmd.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Cerca Negozio --> Ok");

        return negozi;
    }

    public ArrayList<Ingredienti> getIngredNegozio(int id) {
        ArrayList<Ingredienti> ingredienti = new ArrayList<>();

        Statement cmd;

        try {
            Dao.getINSTANCE();
            cmd = Dao.con.createStatement();
            String query = "SELECT * FROM ingredienti JOIN vendono ON ingredienti.id=vendono.id_ingrediente WHERE vendono.id_negozio="
                    + id;
            ResultSet res = cmd.executeQuery(query);
            while (res.next()) {
                int idRec = res.getInt("id");
                String nomeRec = res.getString("nome");
                String marcaRec = res.getString("marca");
                String unitàMisuraRec = res.getString("unità_misura");
                float valoreRec = res.getFloat("valore");
                float prezzoRec = res.getFloat("prezzo");

                Ingredienti i = new Ingredienti(idRec, nomeRec, marcaRec, valoreRec, unitàMisuraRec, prezzoRec);
                ingredienti.add(i);
            }
            res.close();
            cmd.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ingredienti;
    }

    public int postNegozio(Negozio p) {
        Statement cmd;
        try {
            Dao.getINSTANCE();
            cmd = Dao.con.createStatement();
            String query = "INSERT INTO negozi (nome, id_utente_azienda, indirizzo,orari, latitudine, longitudine) values (\""
                    + p.getNome() + "\",\"" + p.getIdUtenteAz() + "\",\"" + p.getIndirizzo() + "\",\"" + p.getOrari()
                    + "\",\"" + p.getLatitudine() + "\",\""
                    + p.getLongitudine() + "\")";
            int id = cmd.executeUpdate(query);

            cmd.close();

            return id;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1000;
    }

    public int deleteIngredientiNegozio(int idNegozio) {
        Statement cmd;
        try {
            Dao.getINSTANCE();
            cmd = Dao.con.createStatement();
            String query = " DELETE from venduti WHERE id_negozio =" + idNegozio;
            int id = cmd.executeUpdate(query);
            cmd.close();
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1000;
    }

    public int deleteNegozio(int idNegozio) {
        Statement cmd;
        try {
            Dao.getINSTANCE();
            cmd = Dao.con.createStatement();
            String query = "DELETE from negozi WHERE id =" + idNegozio;
            int id = cmd.executeUpdate(query);
            cmd.close();
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1000;
    }

    public ArrayList<Negozio> getNegoziOrdiantiDistanzaUtente(ArrayList<Negozio> negoziDB,
            double latitudineUtente, double longitudineUtente, double distanzaMax) {
        ArrayList<Double> allDistanze = new ArrayList<>();
        ArrayList<Negozio> negoziVicini = new ArrayList<>();

        // calcolo distanze di tutti i negozi dall'utente
        for (Negozio nDB : negoziDB) {

            double distanzaN = calcoloDistanza(nDB.getLatitudine(), nDB.getLongitudine(), latitudineUtente,
                    longitudineUtente);

            if (distanzaN <= distanzaMax) {
                allDistanze.add(distanzaN);
                nDB.setDistanza(distanzaN);// setDistanza al negozio
                negoziVicini.add(nDB); // creazione di un array solo dei negozi vicini
            }

        }

        if (negoziVicini.size() == 0) {
            System.out.println("!! Non ci sono negozi nella tua area !! | distanzaMax: " + distanzaMax);
            return null;
        }

        System.out.println("metodo ordinaNegozioDistanaza-->ok");

        System.out.println("Distanza max dai negozi-->" + distanzaMax + "| Numeri negozi: " + negoziVicini.size());
        // oridna negozi dal più vicino al più lontano dall'utente
        return ordinaNegoziDB(negoziVicini, allDistanze);

    }

    private static final double RAGGIO_TERRA = 6371; // Raggio della Terra in km
    /// calcolo distanza di un singolo Negozio dall'Utente

    private double calcoloDistanza(double latitudineNegozio, double longitudineNegozio, double latitudineUtente,
            double longitudineUtente) {
        double latRadNegozio = Math.toRadians(latitudineNegozio);
        double latRadUtente = Math.toRadians(latitudineUtente);
        double diffLatRad = Math.toRadians(latitudineUtente - latitudineNegozio);
        double diffLonRad = Math.toRadians(longitudineUtente - longitudineNegozio);
        double a = Math.sin(diffLatRad / 2) * Math.sin(diffLatRad / 2) + Math.cos(latRadNegozio)
                * Math.cos(latRadUtente) * Math.sin(diffLonRad / 2) * Math.sin(diffLonRad / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distanza = RAGGIO_TERRA * c;
        return distanza;
    }

    // ordian NegozioDB mentre ordina ArrayList distanze ASC
    private ArrayList<Negozio> ordinaNegoziDB(ArrayList<Negozio> negoziDB, ArrayList<Double> allDistanze) {
        boolean sorted = false;
        Negozio tempN;
        Double tempD;

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < negoziDB.size() - 1; i++) {
                if (allDistanze.get(i) > allDistanze.get(i + 1)) {

                    tempN = negoziDB.get(i);
                    tempD = allDistanze.get(i);

                    negoziDB.set(i, negoziDB.get(i + 1));
                    allDistanze.set(i, allDistanze.get(i + 1));

                    negoziDB.set(i + 1, tempN);
                    allDistanze.set(i + 1, tempD);

                    sorted = false;
                }
            }
        }

        return negoziDB;
    }

    // Implemento un metodo Post in cui utente aziendale inserisce degli ingredienti
    // alla sua affiliazione

    public int insertIngredienti(Ingredienti i) {
        Statement cmd;
        try {
            Dao.getINSTANCE();
            cmd = Dao.con.createStatement();

            String query = "INSERT INTO Ingredienti(nome, marca) VALUES(" + "'" + i.getNome() + "'" + ","
                    + "'" + i.getMarca() + "'" + ")";

            int id = cmd.executeUpdate(query);
            cmd.close();

            System.out.println("metodo insertIngredienti -->ok");
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1000;
    }

    public int associaANegozio(int idIngrediente, float valore, float prezzo, String unitàMisura, int idNegozio) {
        Statement cmd;
        try {
            Dao.getINSTANCE();
            cmd = Dao.con.createStatement();

            String query = "INSERT INTO vendono(prezzo, id_ingrediente, id_negozio, valore, unità_misura) VALUES ("
                    + prezzo + "," + idIngrediente + "," + idNegozio + "," + valore + ",'"
                    + unitàMisura + "')";

            int id = cmd.executeUpdate(query);
            cmd.close();

            System.out.println("metodo AssociaNegozio -->ok");
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1000;
    }

}