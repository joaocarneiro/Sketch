package com.example.diogo.sketch.view;

import android.graphics.Canvas;

import com.example.diogo.sketch.model.Figure;
import com.example.diogo.sketch.model.Line;
import com.example.diogo.sketch.model.Rect;


/**
 * Created by Diogo on 10/05/2017.
 */

public class LineView extends FigureView {
    public LineView(Figure elem) {
        super(elem);
    }


    /**
     * Overide do draw da linha
     */
    @Override
    public void draw(Canvas c) {
        Line line=(Line) elem;
        c.drawLine(line.getStart().getX(),line.getStart().getY(),line.getEnd().getX(),line.getEnd().getY(),paint);

    }
}
