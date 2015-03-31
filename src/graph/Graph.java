package graph;

/**
 * Created by lenovo on 3/10/2015.
 */
public interface Graph {
    public boolean hasVertex(int id);

    public boolean hasEdge(int id);

    public <T extends Vertex>  T getVertex(int id);

    public <T extends  Edge> T getEdge(int id);

    public <T extends Content> T getVertexContent(int id);

    public <T extends Content> T getEdgeContent(int id);
}
