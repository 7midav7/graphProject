package castle;

import graph.Content;
import graph.ContentMutableGraph;
import graph.DefaultGraph;
import graph.ObservableGraph;
import view.Observable;

/**
 * Created by user on 24.03.2015.
 */
class CastleObservableGraph extends ObservableGraph {

    public CastleObservableGraph(ContentMutableGraph graph, Observable view) {
        super(graph, view);
    }

    @Override
    public void setVertexContent(int id, Content content) {
        super.setVertexContent(id, content);

    }
}
