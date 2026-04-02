package com.EmacsIsBetterThanVi.TimeConjuringGeography;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

// Game Screen implements the display for the game during a match.
// Currently, it only supports 2 players, but more may be added latter
public class GameScreen implements Screen {
    BitmapFont font;
    Texture board;
    public Sprite playerBoard;
    public Sprite player3Board;
    public Sprite player2Board;
    public Sprite player4Board;
    public Card[] cards;
    public Sprite fullView;
    public SpriteBatch batch;
    public int players;

    public Card getCard(int player, int id){
        return cards[(player-1)*213+id];
    }
    public Card getBack(int player){
        return cards[(player-1)*213];
    }
    @Override
    public void show() {
        font = new BitmapFont();
        font.setColor(0.796f, 0, 1.0f, 1.0f);
        board = new Texture(Gdx.files.internal("board.png"));
        cards = new Card[213*TCG.Players+1]; // Card 0 is the card back of player 1, cards 1-212 are the first player's. Card 213 is the card back of player 2. Cards 214-424 are the second player's, and so on.
        playerBoard = new Sprite(board, 0, 0, 1200, 900);
        if (players>2) {
            player3Board = new Sprite(board, 0, 0, 1200, 900);
            player3Board.setPosition(-300, 225);
            player3Board.setScale(0.5f);
            player3Board.flip(true, true);
        }
        player2Board = new Sprite(board, 0, 0, 1200, 900);
        player4Board = new Sprite(board, 0, 0, 1200, 900);
        playerBoard.setScale(0.5f);
        player2Board.setScale(0.5f);
        player4Board.setScale(0.5f);
        playerBoard.setPosition(300, -225);
        player2Board.setPosition(300, 225);
        player4Board.setPosition(-300, -225);
        player4Board.flip(true, true);
        batch = new SpriteBatch();
        batch.getProjectionMatrix().setToOrtho2D(0, 0, 1200, 900);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(new Color(0.694f, 0.055f, 0.055f, 1.0f));
        batch.begin();
        playerBoard.draw(batch);
        player2Board.draw(batch);
        player3Board.draw(batch);
        player4Board.draw(batch);
        batch.end();
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
