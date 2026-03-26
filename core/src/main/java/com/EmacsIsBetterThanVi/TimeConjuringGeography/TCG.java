package com.EmacsIsBetterThanVi.TimeConjuringGeography;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class TCG extends Game {
    public static TCG self;
    public static int Players=1; // A deck can only have up to 200 cards in it, despite technically any number being legal.
    @Override
    public void create() {
        self=this;
        Gdx.graphics.setResizable(false);
        Gdx.graphics.setWindowedMode(1200, 800);
        CardDB.connect();
        setScreen(new FirstScreen());
    }
}
