package view;

import graph.*;

import java.util.ArrayList;

/**
 * Created by lenovo on 3/10/2015.
 */
public class Observable{

<<<<<<< HEAD
    protected ArrayList<ViewObserver> listObserver = new ArrayList<ViewObserver>();
=======
    private ArrayList<ViewObserver> listObserver = new ArrayList<ViewObserver>();
>>>>>>> origin/master

    public void addObserver(ViewObserver observer ){
        listObserver.add(observer);
    }

<<<<<<< HEAD
    public void init(){
        for (ViewObserver observer: listObserver){
            observer.init();
        }
    }
=======
>>>>>>> origin/master

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

<<<<<<< HEAD
    public void writeFirstValueVertex(int id, String value){
        for (ViewObserver observer : listObserver){
            observer.writeFirstValueVertex(id, value);
        }
    }

    public void writeSecondValueVertex(int id, String value){
        for (ViewObserver observer : listObserver){
            observer.writeSecondValueVertex(id, value);
=======
    public void writeFirstValueVertex(int id, String value, int color){
        for (ViewObserver observer : listObserver){
            observer.writeFirstValueVertex(id, value, color);
        }
    }

    public void writeSecondValueVertex(int id, String value, int color){
        for (ViewObserver observer : listObserver){
            observer.writeSecondValueVertex(id, value, color);
>>>>>>> origin/master
        }
    }

}
