package com.EmacsIsBetterThanVi.TimeConjuringGeography;

import java.sql.*;

public class CardDB {
    public static ResultSet getEntry(String name){
        try {
            return connection.createStatement().executeQuery("SELECT * FROM cards WHERE card_name = \""+name+"\";");
        } catch (SQLException e) {
            System.err.println("Could not get entry");
            System.exit(1);
            return null;
        }
    }
    public static ResultSet getEntry(int id){
        try {
            return connection.createStatement().executeQuery("SELECT * FROM cards WHERE ID = "+id+";");
        } catch (SQLException e) {
            System.err.println("Could not get entry");
            System.exit(1);
            return null;
        }
    }
    public static int[] search(String terms) {
        try {
            ResultSet rs= connection.createStatement().executeQuery("SELECT * FROM cards WHERE "+terms+";");
            int x=0;
            while(rs.next()) {
                x++;
            }
            if (x==0){
                return new int[0];
            }
            int[] ids = new int[x];
            rs.first();
            x=0;
            do {
                ids[x]=rs.getInt("ID");
            } while (rs.next());
            return ids;
        } catch (SQLException e) {
            System.err.println("Could not get entry");
            System.exit(1);
            return null;
        }
    }
    public static String getSet(String name) {
        ResultSet rs = getEntry(name);
        try {
            if (rs == null) {
                System.err.println("Could not get default set");
                System.exit(1);
            }
            rs.next();
            return rs.getString("set");
        } catch (SQLException ignored) {
            System.err.println("Could not get default set");
            System.exit(1);
            return null;
        }
    }
    public static void disconnect(){
        try {
            connection.close();
        } catch (SQLException ignored) {}
    }
    static Connection connection;
    public static void connect(){
        try {
            connection=DriverManager.getConnection("jdbc:sqlite:cards.db");
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.err.println("Could not open CardDB");
            System.exit(1);
        }
    }

    public static int getRarity(int id) {
        return 0;
    }
}
