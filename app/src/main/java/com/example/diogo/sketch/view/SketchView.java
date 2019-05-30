package com.example.diogo.sketch.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Switch;

import com.example.diogo.sketch.SketchController;
import com.example.diogo.sketch.model.Circle;
import com.example.diogo.sketch.model.Figure;
import com.example.diogo.sketch.model.Line;
import com.example.diogo.sketch.model.Pixel;
import com.example.diogo.sketch.model.Rect;
import com.example.diogo.sketch.model.Sketch;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Diogo on 10/05/2017.
 */

public class SketchView extends View {
    private static final float STROKE_WIDTH =2.0f ;
    private Paint paint ;
    private SketchController ctrl;
    private Figure fgr;


    LinkedList<FigureView> figureviews=new LinkedList<>();


    /**
     * Construtor de SketchView
     */

    public SketchView(SketchController sketchController) {
        super(sketchController);
        ctrl=sketchController;
        paint=new Paint();
        paint.setColor(Color.RED);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(STROKE_WIDTH);
    }


    /**
     * recebe uma Figure e consuante essa Figure cria uma FigureView em expecifico
     *
     */
    private FigureView createView(Figure f){
            if (f instanceof Circle) return new CircleView(f);
            if (f instanceof Rect) return new RectView(f);
            if (f instanceof Line) return new LineView(f);
            if (f instanceof Pixel) return new PixelView(f);
        return null;
    }

    /**
     * Precorre a linkedList de FigureView chamando o draw
     */
    @Override
    public void onDraw(Canvas canvas){
        canvas.drawRect(5.0f, 5.0f, (float) (getWidth() - 5), (float) (getHeight() - 5), this.paint);
        for (FigureView i:figureviews)
            {
                i.draw(canvas);
            }
        }


    /**
     * Define o que fazer dependendo da ação realizada
     */
    public boolean onTouchEvent(MotionEvent evt){
        switch (evt.getAction()){
            case MotionEvent.ACTION_DOWN : fgr=ctrl.createSelectedFigure((int)evt.getX(),(int)evt.getY());
                                           figureviews.add(createView(fgr));break;
            case MotionEvent.ACTION_MOVE : fgr.setEnd((int)evt.getX(),(int)evt.getY());break;
        }

        invalidate();
    return true;
    }

    /**
     * Limpa a linkedlist de FigureView
     */
    public void clear(){
        figureviews.clear();
        invalidate();
    }

    /**
     * Limpa a linkedlist de FigureViews e precorre a lista de Figure preenchendo novamente a lista de FigureView
     */

    public void reload(Sketch model){
        figureviews.clear();
        LinkedList<Figure>  figureList= model.getList();
        for (int i = 0; i < figureList.size(); i++) {
            figureviews.add(createView(figureList.get(i)));
        }
        invalidate();
    }




}
