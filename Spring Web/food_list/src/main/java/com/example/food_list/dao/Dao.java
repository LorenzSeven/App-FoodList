package com.example.food_list.dao;

import java.sql.*;

/**
 * Dao daoCtrl = Dao.getINSTANCE();
 * cmd = daoCtrl.con.createStatement();
 */
public class Dao {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    

    //accedere DB locale 
    private final static String URL = "jdbc:mysql://localhost:3306/";
     private final static String DATABASE = "db_foodlist";
     private final static String USERNAME = "root";
     private final static String PASSWORD = "password";
     
    
    /*//accedere DB remoto mysqlhostfree
     private final static String URL = "jdbc:mysql://sql8.freemysqlhosting.net/";
     private final static String DATABASE = "sql8611531";
     private final static String USERNAME = "sql8611531";
     private final static String PASSWORD = "Vt1cmVypB3"; */
     

    public static Connection con = null;
    private static Dao INSTANCE = null;

    private Dao() {
    }

    static {

    }

    public static void openConnection() {
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection((URL + DATABASE), USERNAME, PASSWORD);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void closeConnection() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getCon() {
        return con;
    }

    public static Dao getINSTANCE() {
        if (INSTANCE == null)
            INSTANCE = new Dao();
        if (con == null)
            openConnection();

        return INSTANCE;
    }

}
