package com.example.food_list.dao;

import java.sql.*;

import com.example.food_list.modelli.Utente;
import com.example.food_list.modelli.UtenteAzienda;

public class userDaoController {

	/*
	 * public static final String driver = "com.mysql.jdbc.Driver";
	 * private String url = "jdbc:mysql://sql12.freemysqlhosting.net/";
	 * private String username = "sql12609785";
	 * private String password = "5MWLTPrw6r";
	 * private Connection con = null;
	 */

	/*
	 * public void openConnection(String dbName) {
	 * try {
	 * Class.forName(driver);
	 * url += dbName;
	 * con = DriverManager.getConnection(url, username, password);
	 * }
	 * catch(Exception ex) {
	 * ex.printStackTrace();
	 * }
	 * }
	 * 
	 * public void closeConnection() {
	 * try {
	 * con.close();
	 * } catch (SQLException e) {
	 * e.printStackTrace();
	 * }
	 * }
	 */


	//UTENTE//
	
	public int addUtente(Utente utente) {
		Statement cmd;
		try {
			Dao.getINSTANCE();
			cmd = Dao.con.createStatement();
			String query = "INSERT INTO utenti_consumer (username, email, password, immagine_profilo) values (\""
					+ utente.nomeUtente + "\", \"" + utente.emailUtente + "\", \"" + utente.passwordUtente + "\", \""
					+ utente.immagineUtente + "\")";
			int id = cmd.executeUpdate(query);

			cmd.close();

			return id;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -1000;
	}

	public Utente getUtente(String emailUtente, String passwordUtente) {
		Utente utente = null;

		Statement cmd;
		try {
			Dao.getINSTANCE();
			cmd = Dao.con.createStatement();
			String query = "SELECT * FROM utenti_consumer WHERE email=" + emailUtente + " AND password=" + passwordUtente;
			System.out.println(query);
			ResultSet res = cmd.executeQuery(query);
			while (res.next()) {
				int idRec = res.getInt("id");
				String usernameRec = res.getString("username");
				String emailRec = res.getString("email");
				String passwordeRec = res.getString("password");
				String immagineRec = res.getString("immagine_profilo");

				utente = new Utente(idRec, usernameRec, emailRec, passwordeRec, immagineRec);
			}

			res.close();
			cmd.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.out.println("Utente è nullo: "+emailUtente+"| "+passwordUtente);
		}
		System.out.println("getUtente --> ok");
		return utente;
	}


	//AZIENDA//

	public int addAzienda(UtenteAzienda azienda) {
		Statement cmd;
		try {
			Dao.getINSTANCE();
			cmd = Dao.con.createStatement();
			String query = "INSERT INTO utenti_azienda (email, password, brand, immagine_brand, sede_legale, p_iva) values (\""
					+ azienda.emailAzienda + "\", \"" + azienda.passwordAzienda + "\", \""
					+ azienda.brandAzienda + "\", \"" + azienda.immagineAzienda + "\", \""
					+ azienda.sedeAzienda  + "\", \"" + azienda.PartitaAzienda  + "\")";
			int id = cmd.executeUpdate(query);

			cmd.close();

			return id;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -1000;
	}

	public UtenteAzienda getAzienda(String emailAzienda, String passwordAzienda) {
		UtenteAzienda azienda = null;

		Statement cmd;
		try {
			Dao.getINSTANCE();
			cmd = Dao.con.createStatement();
			String query = "SELECT * FROM utenti_azienda WHERE email=" + emailAzienda + " AND password=" + passwordAzienda;
			System.out.println(query);
			ResultSet res = cmd.executeQuery(query);
			while (res.next()) {
				int idAz = res.getInt("id");
				String emailAz = res.getString("email");
				String passwordAz = res.getString("password");
				String brandAz = res.getString("brand");
				String imgAz = res.getString("immagine_brand");
				String sedeAz = res.getString("sede_legale");
				String partitaAz = res.getString("p_iva");
				azienda = new UtenteAzienda(idAz, emailAz, passwordAz, brandAz, imgAz, sedeAz, partitaAz);
			}

			res.close();
			cmd.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return azienda;
	}


	//UTENTE SITO//

	public Utente getUtenteSito(String emailUtente, String passwordUtente) {
		Utente utente = null;

		Statement cmd;
		try {
			Dao.getINSTANCE();
			cmd = Dao.con.createStatement();
			String query = "SELECT * FROM utenti_consumer WHERE email='" + emailUtente + "' AND password='"+ passwordUtente+ "'";
			System.out.println(query);
			ResultSet res = cmd.executeQuery(query);
			while (res.next()) {
				int idRec = res.getInt("id");
				String usernameRec = res.getString("username");
				String emailRec = res.getString("email");
				String passwordeRec = res.getString("password");
				String immagineRec = res.getString("immagine_profilo");

				utente = new Utente(idRec, usernameRec, emailRec, passwordeRec, immagineRec);
			}

			res.close();
			cmd.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utente;
	}


	//AZIENDA SITO//

	public UtenteAzienda getAziendaSito(String emailAzienda, String passwordAzienda) {
		UtenteAzienda azienda = null;

		Statement cmd;
		try {
			Dao.getINSTANCE();
			cmd = Dao.con.createStatement();
			String query = "SELECT * FROM utenti_azienda WHERE email='" + emailAzienda + "' AND password='"
					+ passwordAzienda + "'";
			System.out.println(query);
			ResultSet res = cmd.executeQuery(query);
			while (res.next()) {
				int idAz = res.getInt("id");
				String emailAz = res.getString("email");
				String passwordAz = res.getString("password");
				String brandAz = res.getString("brand");
				String imgAz = res.getString("immagine_brand");
				String sedeAz = res.getString("sede_legale");
				String partitaAz = res.getString("p_iva");
				azienda = new UtenteAzienda(idAz, emailAz, passwordAz, brandAz, imgAz, sedeAz, partitaAz);
			}

			res.close();
			cmd.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return azienda;
	}

}



