package com.EmacsIsBetterThanVi.TimeConjuringGeography;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

/** First screen of the application. Displayed after the application is created. */
public class FirstScreen implements Screen {
    TextureRegion background;
    Texture texture;
    SpriteBatch batch;
    BitmapFont font;
    float alpha = 1.0f;
    boolean alphaDelta = false;
    @Override
    public void show() {
        font = new BitmapFont(Gdx.files.internal("TITLEFONT.fnt"));
        texture = new Texture(Gdx.files.internal("Title.png"));
        background = new TextureRegion(texture, 0, 0, 1200, 900);
        batch = new SpriteBatch();
        batch.getProjectionMatrix().setToOrtho2D(0, 0, 1200, 900);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLACK);
        batch.begin();
        batch.draw(texture, 0, 0);
        if (alphaDelta) alpha += delta/2.5f;
        else alpha -= delta/4;
        if (alpha > 1){
            alpha=1.0f;
            alphaDelta=!alphaDelta;
        }

        if (alpha < 0.1){
            alpha=0.1f;
            alphaDelta=!alphaDelta;
        }
        font.setColor(0.796f, 0, 1.0f, alpha);
        font.draw(batch, "PLAY", 500, 300);
        batch.end();
        if (Gdx.input.isTouched()){
            TCG.self.setScreen(new HomeScreen());
        }
    }

    @Override
    public void resize(int width, int height) {
        // If the window is minimized on a desktop (LWJGL3) platform, width and height are 0, which causes problems.
        // In that case, we don't resize anything, and wait for the window to be a normal size before updating.
        if(width <= 0 || height <= 0) return;

    }

    @Override
    public void pause() {
        // Invoked when your application is paused.
    }

    @Override
    public void resume() {
        // Invoked when your application is resumed after pause.
    }

    @Override
    public void hide() {
        this.dispose();
    }

    @Override
    public void dispose() {
        font.dispose();
        texture.dispose();
        batch.dispose();
    }
}
