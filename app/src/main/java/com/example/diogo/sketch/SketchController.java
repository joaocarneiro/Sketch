package com.example.diogo.sketch;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.example.diogo.sketch.model.Circle;
import com.example.diogo.sketch.model.Figure;
import com.example.diogo.sketch.model.Line;
import com.example.diogo.sketch.model.Pixel;
import com.example.diogo.sketch.model.Rect;
import com.example.diogo.sketch.model.Sketch;
import com.example.diogo.sketch.view.SketchView;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SketchController extends AppCompatActivity {

    Button reset, load, save;
    RadioButton line, rect,pixel,circle;
    Sketch model;
    SketchView view;
    RadioGroup radioButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model=new Sketch();

        view=new SketchView(this);
       // view.setController(this);

        if (savedInstanceState!=null)
            onLoad();


        // criar Buttons e Draw area
        reset = new Button(this);

        reset.setText("Reset");

        load = new Button(this);
        load.setText("Load");

        save = new Button(this);
        save.setText("Save");

        line = new RadioButton(this);
        line.setText("Line");

        rect = new RadioButton(this);
        rect.setText("Rect");

        pixel = new RadioButton(this);
        pixel.setText("Pixel");

        circle = new RadioButton(this);
        circle.setText("Circle");

        // criar os layouts
        LinearLayout buttons = new LinearLayout(this);
        buttons.setOrientation(LinearLayout.HORIZONTAL);
        buttons.addView(reset);
        buttons.addView(load);
        buttons.addView(save);

        radioButtons = new RadioGroup(this);
        radioButtons.setOrientation(LinearLayout.HORIZONTAL);


        radioButtons.addView(line);
        radioButtons.addView(rect);
        radioButtons.addView(pixel);
        radioButtons.addView(circle);
        radioButtons.check(line.getId());


        LinearLayout top = new LinearLayout(this);
        top.addView(buttons);
        top.setOrientation(LinearLayout.VERTICAL);
        top.addView(radioButtons);



        LinearLayout global = new LinearLayout(this);
        global.setOrientation(LinearLayout.VERTICAL);
        global.addView(top);

        global.addView(view);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onReset();
            }
        });
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLoad();
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSave();
            }
        });

        setContentView(global);
    }
    /**
     * Faz o save
     */

    private void onSave(){
        try {
            OutputStream e = openFileOutput("sketch.txt", Context.MODE_PRIVATE);
            model.save(e);
                }catch (Exception e){
            e.printStackTrace();
        }


    }
    /**
     * Faz o load
     */

    private void onLoad(){

        try  {
            InputStream is = openFileInput("sketch.txt");
            model.load(is);
            view.reload(model);
        }
        catch(IOException e) {
            System.out.println("Error loading file!");
        }
    }

    /**
     * Faz o reset fazendo o clear das listas tanto de Figure como de FigureView
     */
    private void onReset(){
        model.clear();
        view.clear();
    }

    /**
     * Verifica qual dos radiobuttons está ligado e consuante o que for cria o objecto adicionando a linkedlist
     */
    public Figure createSelectedFigure(int x,int y) {
        Figure f=null;
        if (line.isChecked()) f= new Line(x, y);
        if (rect.isChecked()) f= new Rect(x, y);
        if (circle.isChecked()) f= new Circle(x, y);
        if (pixel.isChecked()) f= new Pixel(x, y);
        model.add(f);
        return f;
    }

    /**
     * Feito o overide com o objectivo de carregar o que estava desenhado antes de ser rodado o ecra
     *
     */

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onSave();
        onLoad();
    }
}
