package ca.gbc.mobile.adrianpaiva.matchit;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;


/*
*************************************************
* Adrian Paiva
* 100864588
* ‎Friday, ‎October ‎3, ‎2014
* lastEdit: October ‎11, ‎2014
**************************************************/

public class Card {

    private int image;
    private boolean flipped;
    private int pairId;

    public Card(int image, int pairId) {

        flipped = false;
        this.image = image;
        this.pairId = pairId;
    }

    public boolean isFlipped() {
        return flipped;
    }

    public int getPairId() {
        return pairId;
    }

    public void setFlipped(boolean flipped) {
        this.flipped = flipped;

    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;

    }



}
