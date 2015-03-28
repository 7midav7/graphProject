package graph;

import view.Observable;

/**
 * Created by user on 24.03.2015.
 */
public class ObservableGraph extends DefaultGraph {
    protected Observable view;

    public ObservableGraph(Graph graph, Observable view) {
        super();

        int curId = 0;
        while (graph.hasVertex(curId)){
            listVertex.add(graph.getVertex(curId));
            ++curId;
        }
        curId = 0;
        while (graph.hasEdge(curId)){
            listEdge.add(graph.getEdge(curId));
            ++curId;
        }

        this.view = view;
    }
}
