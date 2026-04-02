package com.EmacsIsBetterThanVi.TimeConjuringGeography;

import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LocalCardDB {
    private static Connection connection;

    public static void connect(){
        try {
            connection= DriverManager.getConnection("jdbc:sqlite:"+System.getProperty("user.home")+"/.emacsisbetterthanvi/TCG/LocalCards.db");
            System.out.println("Connection to LocalCardDB has been established.");
        } catch (SQLException e) {
            System.err.println(e.getMessage());//"Could not open LocalCardDB\nGenerating new LocalCardDB");
            System.exit(1);
        }
    }
    // Columns: ID, card, Foil,Status(One of 0-Pack, 1-Crafted, 2-Gifted; matters for dismantling, pack cards can be dimantled into base and foil, while crafted are dismantled into coins. Gifted can not be dismantled, but are exceedingly uncommon, and used only for the starting deck)
    public static int inLibrary(int id, int foil){ // Foil 0 - Normal, Foil 1 - Foil, Foil 2 - Cold Foil, Foil 3 - Rainbow Foil, Foil 4 - Gold Foil
        try {
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM cards WHERE ID = " + id + ";");
            int x = 0;
            while (rs.next()) {
                x++;
            }
            return x;
        } catch (SQLException ignored) {
            return 0;
        }
    }
}
