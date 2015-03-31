package view;

import graph.*;

import java.util.ArrayList;

/**
 * Created by lenovo on 3/10/2015.
 */
public class Observable{

    protected ArrayList<ViewObserver> listObserver = new ArrayList<ViewObserver>();

    public void addObserver(ViewObserver observer ){
        listObserver.add(observer);
    }

    public void init(){
        for (ViewObserver observer: listObserver){
            observer.init();
        }
    }

    public void markVertex(int id, int color){
        for (ViewObserver observer : listObserver){
            observer.markVertex(id, color);
        }
    }

    public void markEdge(int id, int color){
        for (ViewObserver observer : listObserver){
            observer.markEdge(id, color);
        }
    }

    public void writeFirstValueVertex(int id, String value){
        for (ViewObserver observer : listObserver){
            observer.writeFirstValueVertex(id, value);
        }
    }

    public void writeSecondValueVertex(int id, String value){
        for (ViewObserver observer : listObserver){
            observer.writeSecondValueVertex(id, value);
        }
    }

}
