package com.EmacsIsBetterThanVi.TimeConjuringGeography;

public class Zone {
    public int[] CardIDs;
    public boolean[] hidden;
    public int x;
    public int y;
    public final boolean stack; // Displays all cards as one.
    public Zone(boolean stack, int size, int x, int y){
        this.stack = stack;
        CardIDs=new int[size];
        hidden = new boolean[size];

    }
    public void draw(){

    }
}
