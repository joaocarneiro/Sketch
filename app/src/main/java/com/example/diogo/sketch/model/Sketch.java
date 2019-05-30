package com.example.diogo.sketch.model;

import android.os.Bundle;

import com.example.diogo.sketch.SketchController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Diogo on 10/05/2017.
 */

public class Sketch extends SketchController {


    LinkedList<Figure> list=new LinkedList<>();

    public Iterator<Figure> iterator(){
        return list.iterator();
    }
    public void add(Figure f){
        list.add(f);
    }
    public void clear(){
        list.clear();
    }

    public void save (OutputStream o){
        PrintWriter a = new PrintWriter(o);
        a.println(list.size());
        for (int i = 0; i < list.size(); i++) {
                String s=list.get(i).getLetter()+" "+list.get(i).toString();
                a.println(s);
            }
        a.flush();
        a.close();
    }

    public void load(InputStream is) throws IOException {
        Scanner a = new Scanner(is);
        Figure f=null;
        String v = a.next();
        while (a.hasNext()){
            int aux=0;

            switch (a.next().charAt(aux)){
                case 'R':f=new Rect();break;
                case 'L':f= new Line();break;
                case 'P':f=new Pixel();break;
                case 'C':f=new Circle();break;
            }
            System.out.println(v);

            f.fromString(a.nextLine(), aux);
            list.add(f);

            ++aux;
        }
    }


    public LinkedList<Figure> getList() {
        return list;
    }
}
