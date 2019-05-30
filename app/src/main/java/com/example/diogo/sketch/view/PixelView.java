package com.example.diogo.sketch.view;

import android.graphics.Canvas;
import android.graphics.Picture;

import com.example.diogo.sketch.model.Figure;
import com.example.diogo.sketch.model.Pixel;

/**
 * Created by Diogo on 10/05/2017.
 */

public class PixelView extends FigureView {
    public PixelView(Figure elem) {
        super(elem);

    }


    /**
     * Overide do draw do pixel
     */
    @Override
    public void draw(Canvas c) {
        Pixel pixel=(Pixel)elem;
        c.drawPoint(pixel.getStart().getX(),pixel.getStart().getY(),paint);
    }

}
