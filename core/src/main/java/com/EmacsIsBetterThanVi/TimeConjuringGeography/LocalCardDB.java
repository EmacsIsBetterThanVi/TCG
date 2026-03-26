package com.EmacsIsBetterThanVi.TimeConjuringGeography;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LocalCardDB extends CardDB {
    public static void connect(){
        try {
            connection= DriverManager.getConnection("jdbc:sqlite:"+System.getProperty("user.home")+"/localCards.db");
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.err.println("Could not open LocalCardDB");
            System.exit(1);
        }
    }
    // Columns: ID, Foil, Status(One of 0-Pack, 1-Crafted, 2-Gifted; matters for dismantling and selling, only pack can be dismantled, but gifted cards also can not be sold)
    public static int inLibrary(int id, int foil){ // Foil 0 - Normal, Foil 1 - Foil, Foil 2 - Cold Foil, Foil 3 - Rainbow Foil, Foil 4 - Gold Foil
        try {
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM cards WHERE ID = " + id + ";");
            int x = 0;
            while (rs.next()) {
                x++;
            }
            return x;
        } catch (SQLException ignored) {

        }
    }
}
