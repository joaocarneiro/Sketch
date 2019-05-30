package com.example.diogo.sketch.model;

/**
 * Created by Diogo on 10/05/2017.
 */

public class Rect extends Line {
    public char LETTER='R';


    public Rect() {super();}

    public Rect(int x, int y) {

        super(x, y);
        end=new Point(x,y);
    }

    public char getLetter() {
        return LETTER;
    }
}
