package com.example.diogo.sketch.model;

/**
 * Created by Diogo on 10/05/2017.
 */

public class Line extends Figure{
    protected Point end;
    public char LETTER='L';

    public Line() {
        super();
    }

    public Line(int x, int y) {
        super(x, y);
        end=new Point(x,y);
    }

    @Override
    public char getLetter() {
        return LETTER;
    }

    @Override
    public void setEnd(int x, int y) {
        end.set(x,y);
    }
    public Point getEnd(){
        return end;
    }

    public String toString(){
        String s="("+start.getX()+","+start.getY()+")"+" "+"("+end.getX()+","+end.getY()+")";
        return s;
    }

    protected int  fromString(String s,int idx) {
        idx = super.fromString(s, idx)+1;
        String x = "";
        String y = "";
        boolean writeY = false;
        while (idx < s.length()) {
            if (s.charAt(idx) == ',')
                writeY = true;
            if (s.charAt(idx) == ')')
                break;
            if (s.charAt(idx) >= '0' && s.charAt(idx) <='9') {
                if (writeY)
                    y += s.charAt(idx);
                else
                    x += s.charAt(idx);
            }
            ++idx;
        }
        end = new Point(Integer.parseInt(x), Integer.parseInt(y));
        return idx;
    }
    }

