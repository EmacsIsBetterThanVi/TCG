package com.EmacsIsBetterThanVi.TimeConjuringGeography;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Card extends Sprite {
    private boolean isHidden;
    private boolean isSideways;
    public Texture back;
    public Texture front;
    public Card(String card){
        super();
        front = new Texture(Gdx.files.internal("cards/"+CardDB.getSet(card)+"/"+card+".png"));
        isHidden=false;
        isSideways=false;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }
    public boolean isHidden() {return isHidden; }
    public void setSideways(boolean sideways){
        isSideways=sideways;
    }
    public boolean isSideways(){
        return isSideways;
    }
    @Override
    public void draw(Batch batch) {
        if (isSideways)
            this.setRotation(90);
        else this.setRotation(0);
        if (isHidden) this.setTexture(back);
        else this.setTexture(front);
        super.draw(batch);
    }
}
