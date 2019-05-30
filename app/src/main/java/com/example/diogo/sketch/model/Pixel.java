package com.example.diogo.sketch.model;

/**
 * Created by Diogo on 10/05/2017.
 */

public class Pixel extends Figure {
    public char LETTER='P';


    public Pixel() {super();}

    public Pixel(int x, int y) {
        super(x, y);

    }

    public char getLetter() {
        return LETTER;
    }

    @Override
    public void setEnd(int x, int y)
    {
        start.set(x,y);
    }
}
