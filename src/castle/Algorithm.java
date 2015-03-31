package castle;

import graph.ContentMutableGraph;
import graph.Edge;
import graph.MutableGraph;
import graph.Vertex;
import view.Marks;
import view.Observable;

/**
 * Created by user on 29.03.2015.
 */
class Algorithm {
    private Model model;
    private Observable observable;
    private int TIME_SLEEP = 200;
    private int[] numberRooms;

    public Algorithm(Model model, Observable observable) {
        this.model = model;
        this.observable = observable;
        numberRooms = new int[ model.getHeight() * model.getWidth()];
    }

    private void pause(){
        try{
            Thread.sleep(TIME_SLEEP);
        } catch (InterruptedException exc){

        }
    }

    private void init(){

    }

    private void deepFirstSearch(int id, int color){
        ContentMutableGraph graph = model.getGraph();

        CastleContent content = graph.getVertexContent(id);
        content.setColorRoom(color);
        ++ numberRooms[color];

        observable.writeSecondValueVertex(id,
                Integer.toString(color)
        );
        observable.markVertex(id, 0xbbbb00);
        pause();
        observable.markVertex(id, Marks.nextMark(color));
        pause();

        Vertex vertex = graph.getVertex(id);
        for (Integer idEdge : vertex.getListEdge()){
            Edge edge = graph.getEdge(idEdge);
            int idNeighbour = edge.getToVertex();
            CastleContent contentNeighbour =  graph.getVertexContent(
                    idNeighbour
            );
            if ( (contentNeighbour).getColorRoom() == -1){
                deepFirstSearch(idNeighbour, color);
            }
        }

        observable.markVertex(id, 0x880000);
        pause();
        observable.markVertex(id, Marks.nextMark(color));
        pause();
    }

    private void findRooms(){

        int height = model.getHeight();
        int width = model.getWidth();
        ContentMutableGraph graph =  model.getGraph();

        int color = 0;
        for ( int i = 0; i < height; ++ i){
            for (int j = 0; j < width; ++ j){
                CastleContent content = graph.getVertexContent(i * height + j);
                if (content.getColorRoom() == -1){
                    deepFirstSearch(i * height + j, color++);
                }
            }
        }
    }

    public void findWall(){
        int height = model.getHeight();
        int width = model.getWidth();
        ContentMutableGraph graph = model.getGraph();
        int[][] map = model.getMap();

        int ans = 0;

        for (int i = 0; i < height; ++ i){
            for (int j = 0; j < width; ++ j){
                int id = i * height + j;
                int colorMainRoom = ((CastleContent)
                        graph.getVertexContent(id)).getColorRoom();
                observable.markVertex(id, 0x00bbbb);
                pause();

                if (j > 0 && (map[i][j] & 1) != 0 ) {
                    int idNeighbour = i * height + j - 1;
                    int colorRoom = ((CastleContent)
                            graph.getVertexContent(idNeighbour)).getColorRoom();
                    if (ans < numberRooms[colorMainRoom] + numberRooms[colorRoom]){
                        ans = numberRooms[colorMainRoom] + numberRooms[colorRoom];
                    }
                    observable.markVertex(idNeighbour, 0x00bb00);
                    pause();
                    observable.markVertex(idNeighbour, Marks.nextMark(colorRoom));
                    pause();
                }
                if (i > 0 && (map[i][j] & 2) != 0 ){
                    int idNeighbour = (i - 1) * height + j;
                    int colorRoom = ((CastleContent)
                            graph.getVertexContent(idNeighbour)).getColorRoom();
                    if (ans < numberRooms[colorMainRoom] + numberRooms[colorRoom]){
                        ans = numberRooms[colorMainRoom] + numberRooms[colorRoom];
                    }
                    observable.markVertex(idNeighbour, 0x00bb00);
                    pause();

                    observable.markVertex(idNeighbour, Marks.nextMark(colorRoom));
                    pause();
                }

                observable.markVertex(id, Marks.nextMark(colorMainRoom));
                pause();
            }
        }
    }

    public void doAlgorithm(){
        init();
        findRooms();
        findWall();
    }
}
