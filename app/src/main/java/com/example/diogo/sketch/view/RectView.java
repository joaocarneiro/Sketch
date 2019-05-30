package com.example.diogo.sketch.view;

import android.graphics.Canvas;

import com.example.diogo.sketch.model.Figure;
import com.example.diogo.sketch.model.Rect;

/**
 * Created by Diogo on 10/05/2017.
 */

public class RectView extends FigureView{
    public RectView(Figure elem) {
        super(elem);
    }



    /**
     * Overide do draw do rectangulo
     */
    @Override
    public void draw(Canvas c) {
        Rect rect= (Rect)elem;
        if(rect.getEnd().getX()<rect.getStart().getX()){
            c.drawRect(rect.getEnd().getX(),rect.getStart().getY(),rect.getStart().getX(),rect.getEnd().getY(),paint);
        }

        if(rect.getEnd().getY()<rect.getStart().getY()){
            c.drawRect(rect.getStart().getX(),rect.getEnd().getY(),rect.getEnd().getX(),rect.getStart().getY(),paint);
        }

        if(rect.getEnd().getY() < rect.getStart().getY()  &&    rect.getEnd().getX() < rect.getStart().getX()){
            c.drawRect(rect.getEnd().getX(),rect.getEnd().getY(),rect.getStart().getX(),rect.getStart().getY(),paint);
        }


        c.drawRect(rect.getStart().getX(),rect.getStart().getY(),rect.getEnd().getX(),rect.getEnd().getY(),paint);


    }
}
