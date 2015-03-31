package castle;

import graph.*;
<<<<<<< HEAD
import view.AbstractView;
import view.Observable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
=======
import view.Marks;
import view.Observable;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
>>>>>>> origin/master

/**
 * Created by lenovo on 3/10/2015.
 */
public class CastleController {
<<<<<<< HEAD

    private Model model;
    private Visualization visualization;
    private Observable observable;
    private AbstractView view;
    private Algorithm algorithm; // AbstractAlgorithm

    public CastleController() throws GraphLoadingException{

        this.model = new Model();
        GraphLoader loader = new GraphLoader();
        loader.load(model, "castle.in");

        this.view = new AbstractView();
        this.visualization = new Visualization(view, model);
        this.observable = new Observable();
        this.observable.addObserver(this.view);

        ViewInitiator initiator = new ViewInitiator();
        initiator.init(model, observable);

        this.algorithm = new Algorithm(model, observable);
        algorithm.doAlgorithm();
    }

=======
    private int width;
    private int height;
    private int[][] map;
    private Observable observable;
    private ContentMutableGraph graph;
    private int[] numberRooms;
    private int TIME_SLEEP = 200;

    private void pause(){
        try{
            Thread.sleep(TIME_SLEEP);
        } catch (InterruptedException exc){

        }
    }

    private void initView(){
        this.observable = new Observable();
        Visualization observer = new Visualization(this.width, this.height, this.map);
        this.observable.addObserver(observer.getView());

        for (int i = 0; i < this.height; ++ i){
            for (int j = 0; j < this.width; ++ j){
                CastleContent content =
                        this.graph.getVertexContent(i * this.height + j);
                this.observable.writeFirstValueVertex(i * this.height + j,
                        Integer.toString(content.getTypeRoom()), 0);
            }
        }

        this.graph = new CastleObservableGraph(this.graph, this.observable);
    }

    private void readData(BufferedReader reader) throws IOException{
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        this.width = Integer.parseInt(tokenizer.nextToken());
        this.height = Integer.parseInt(tokenizer.nextToken());
        this.map = new int[this.width][this.height];
        this.numberRooms = new int[this.width * this.height];

        MutableGraph graph = new DefaultGraph();
        for (int i = 0; i < this.height; ++ i){
            tokenizer = new StringTokenizer(reader.readLine());

            for (int j = 0; j < this.width; ++ j){
                this.map[i][j] = Integer.parseInt(tokenizer.nextToken());

                CastleContent content = new CastleContent(this.map[i][j], -1);
                int curId = graph.addVertex(content);

                if ( (this.map[i][j]&1) == 0 && j != 0){
                    graph.addEdge(new Content(), curId, curId - 1);
                    graph.addEdge(new Content(), curId - 1, curId);
                }
                if ( (this.map[i][j]&2) == 0 && i != 0){
                    graph.addEdge(new Content(), curId, curId - this.height);
                    graph.addEdge(new Content(), curId - this.height, curId);
                }
            }
        }

        this.graph = graph;
    }

    private void init() throws GraphLoadingException{
        try(FileInputStream fis = new FileInputStream("castle.in")){
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader reader = new BufferedReader(isr);
            readData(reader);
            initView();
        } catch (IOException exc){
            throw new GraphLoadingException(exc);
        }
    }

    private void deepFirstSearch(int id, int color){
        CastleContent content = this.graph.getVertexContent(id);
        content.setColorRoom(color);
        ++ numberRooms[color];

        this.observable.writeSecondValueVertex(id,
                Integer.toString(color), 0
                );
        this.observable.markVertex(id, 0xbbbb00);
        pause();
        this.observable.markVertex(id, Marks.nextMark(color));
        pause();

        Vertex vertex = this.graph.getVertex(id);
        for (Integer idEdge : vertex.getListEdge()){
            Edge edge = this.graph.getEdge(idEdge);
            int idNeighbour = edge.getToVertex();
            CastleContent contentNeighbour =  this.graph.getVertexContent(
                    idNeighbour
            );
            if ( (contentNeighbour).getColorRoom() == -1){
                deepFirstSearch(idNeighbour, color);
            }
        }

        this.observable.markVertex(id, 0x880000);
        pause();
        this.observable.markVertex(id, Marks.nextMark(color));
        pause();
    }

    private void findRooms(){
        int color = 0;
        for ( int i = 0; i < this.height; ++ i){
            for (int j = 0; j < this.height; ++ j){
                CastleContent content = graph.getVertexContent(i * height + j);
                if (content.getColorRoom() == -1){
                    deepFirstSearch(i * height + j, color++);
                }
            }
        }
    }

    public void findWall(){
        int ans = 0;

        for (int i = 0; i < this.height; ++ i){
            for (int j = 0; j < this.width; ++ j){
                int id = i * this.height + j;
                int colorMainRoom = ((CastleContent)
                        this.graph.getVertexContent(id)).getColorRoom();
                observable.markVertex(id, 0x00bbbb);
                pause();

                if (j > 0 && (map[i][j] & 1) != 0 ) {
                    int idNeighbour = i * height + j - 1;
                    int colorRoom = ((CastleContent)
                            this.graph.getVertexContent(idNeighbour)).getColorRoom();
                    if (ans < numberRooms[colorMainRoom] + numberRooms[colorRoom]){
                        ans = numberRooms[colorMainRoom] + numberRooms[colorRoom];
                    }
                    this.observable.markVertex(idNeighbour, 0x00bb00);
                    pause();
                    this.observable.markVertex(idNeighbour, Marks.nextMark(colorRoom));
                    pause();
                }
                if (i > 0 && (map[i][j] & 2) != 0 ){
                    int idNeighbour = (i - 1) * height + j;
                    int colorRoom = ((CastleContent)
                            this.graph.getVertexContent(idNeighbour)).getColorRoom();
                    if (ans < numberRooms[colorMainRoom] + numberRooms[colorRoom]){
                        ans = numberRooms[colorMainRoom] + numberRooms[colorRoom];
                    }
                    this.observable.markVertex(idNeighbour, 0x00bb00);
                    pause();

                    this.observable.markVertex(idNeighbour, Marks.nextMark(colorRoom));
                    pause();
                }

                this.observable.markVertex(id, Marks.nextMark(colorMainRoom));
                pause();
            }
        }
    }

    public void doAlgorithm() throws GraphLoadingException{
        init();
        findRooms();
        findWall();
    }
>>>>>>> origin/master
}
