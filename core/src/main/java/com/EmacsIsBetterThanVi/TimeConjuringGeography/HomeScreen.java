package com.EmacsIsBetterThanVi.TimeConjuringGeography;

import com.badlogic.gdx.Screen;

public class HomeScreen implements Screen {
    @Override
    public void show() {
        TCG.self.setScreen(new GameScreen());
    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
