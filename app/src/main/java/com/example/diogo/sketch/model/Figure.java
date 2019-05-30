package com.example.diogo.sketch.model;

/**
 * Created by Diogo on 10/05/2017.
 */

public abstract class Figure {

    protected Point start;
    protected Point end;

    public Point getEnd() {
        return end;
    }

    public Figure() {
    }

    public Figure(int x,int y) {

        start=new Point(x,y);
    }

    public abstract char getLetter();

    public Point getStart(){
        return start;
    }

    public void setEnd(int x,int y) {
        end.set(x, y);
    }

    /**
     * Cada toString ira ser redefenido em cada objecto consuante o objecto irá ser escrito de maneira diferente na
     * String que depois e usada no save do Sketch
     */

    public String toString(){
        String s="("+start.getX()+","+start.getY()+")";
        return s;
    }

    /**
     * Cada from string sera utilizado no load de maneira a intrepertar o texto de cada objecto seja ele line,circle,
     * rect e criar o objecto em questao retornando o indice que termina
     */
    protected int  fromString(String s,int idx){
            String x="";
            String y="";
            boolean writeY=false;
        while ( idx < s.length()) {
                if(s.charAt(idx)==',')
                    writeY=true;
                if(s.charAt(idx)==')')
                    break;
                if(s.charAt(idx)>='0' && s.charAt(idx)<='9') {
                    if(writeY)
                        y += s.charAt(idx);
                    else
                        x += s.charAt(idx);
                }
            ++idx;
        }
        start= new Point(Integer.parseInt(x),Integer.parseInt(y));
        return idx;

    }



}
