package com.example.diogo.sketch.view;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.diogo.sketch.model.Figure;

/**
 * Created by Diogo on 10/05/2017.
 */

public abstract class FigureView {
    protected Paint paint;
    protected Figure elem;


    /**
     * Construtor de FigureView
     */
    public FigureView(Figure elem) {
        this.elem = elem;
        paint=new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10.0f);
    }

    public Figure getFigure(){
        return elem;
    }

    public abstract void draw(Canvas c) ;


}
