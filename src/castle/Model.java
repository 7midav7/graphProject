package castle;

import graph.Content;
import graph.ContentMutableGraph;
import graph.DefaultGraph;
import graph.MutableGraph;
import view.Observable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by user on 29.03.2015.
 */
class Model {
    private int width;
    private int height;
    private int[][] map;
//    private Observable observable;
    private ContentMutableGraph graph;


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int[][] getMap() {
        return map;
    }

    public void setMap(int[][] map) {
        this.map = map;
    }

    public ContentMutableGraph getGraph() {
        return graph;
    }

    public void setGraph(ContentMutableGraph graph) {
        this.graph = graph;
    }
}
