package com.example.diogo.sketch.model;

/**
 * Created by Diogo on 10/05/2017.
 */

public class Point {
    int x;
    int y;

    public Point(){}

    public Point(int x,int y) {
        this.x = x;
        this.y= y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public void set(int x,int y){
        this.x=x;
        this.y=y;
    }

    public String toString(){
        return null;
    }


    protected int  fromString(String s, int idx){return 0;}

}
