package com.example.diogo.sketch.model;

import static java.lang.Math.sqrt;

/**
 * Created by Diogo on 10/05/2017.
 */

public class Circle extends Figure{


        private int radius;
        public char LETTER='C';

        public Circle() {
            super();
        }

        public Circle(int x, int y) {
            super(x, y);
        }

        @Override
        public char getLetter() {
            return LETTER;
        }

        @Override
        public void setEnd(int x, int y) {
            int x2=(x-start.getX())*(x-start.getX());
            int y2=(y-start.getY())*(y-start.getY());
            radius=(int)sqrt(x2+y2);
        }
        public Point getEnd(){
            return end;
        }

        public int getRadius() {
            return radius;
        }

        public String toString(){
            String s="("+start.getX()+","+start.getY()+")"+"|"+radius+"|";
            return s;
        }

    protected int fromString(String s,int idx){
        idx=super.fromString(s,idx);
        String radius="";
        idx = s.indexOf('|')+1;
        while ( idx < s.length()) {
            if(s.charAt(idx)=='|')
                break;
            if(s.charAt(idx)>='0' && s.charAt(idx)<='9') {
                    radius += s.charAt(idx);

            }
            ++idx;
        }
       this.radius =Integer.parseInt(radius);
        return idx;

    }
 }


