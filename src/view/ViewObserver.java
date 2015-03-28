package view;

import graph.Graph;

/**
 * Created by lenovo on 3/10/2015.
 */
public interface ViewObserver {
    public void markVertex(int id, int color);
    public void markEdge(int id, int color);
    public void writeFirstValueVertex(int id, String value);
    public void writeSecondValueVertex(int id, String value);
}
