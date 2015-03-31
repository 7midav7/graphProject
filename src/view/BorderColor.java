package view;

import java.awt.*;

/**
 * Created by lenovo on 2/17/2015.
 */
public class BorderColor {

    public enum Type {WEST, NORTH, EAST, SOUTH};

    private int northBorder;
    private int westBorder;
    private int eastBorder;
    private int southBorder;

    public BorderColor(int northBorder, int westBorder, int eastBorder, int southBorder) {
        this.northBorder = northBorder;
        this.westBorder = westBorder;
        this.eastBorder = eastBorder;
        this.southBorder = southBorder;
    }

    public BorderColor(int color) {
        this.northBorder = color;
        this.westBorder = color;
        this.eastBorder = color;
        this.southBorder = color;
    }

    public int getColor(Type type ){
        switch (type){
            case WEST: return westBorder;
            case NORTH: return northBorder;
            case EAST: return eastBorder;
            case SOUTH: return southBorder;
            default: return 0;
        }
    }

    public void setColor(Type type, int value ){
        switch (type){
            case WEST: westBorder = value; break;
            case NORTH: northBorder = value; break;
            case EAST: eastBorder = value; break;
            case SOUTH: southBorder = value; break;
        }
    }

    public void setColor(int type, int value){
        if ( (type&1) != 0 ){
            northBorder = value;
        }
        if ( (type&2) != 0 ){
            eastBorder = value;
        }
        if ( (type&4) != 0 ){
            southBorder = value;
        }
        if ( (type&8) != 0){
            westBorder = value;
        }
    }
}
