package com.example.diogo.sketch.view;

import android.graphics.Canvas;

import com.example.diogo.sketch.model.Circle;
import com.example.diogo.sketch.model.Figure;

/**
 * Created by Diogo on 10/05/2017.
 */

public class CircleView extends FigureView {
    public CircleView(Figure elem) {
        super(elem);
    }


    /**
     * Overide do draw do circulo
     */
    @Override
    public void draw(Canvas c) {
        Circle circle=(Circle)elem;
        c.drawCircle(circle.getStart().getX(),elem.getStart().getY(),circle.getRadius(),paint);
    }
}
