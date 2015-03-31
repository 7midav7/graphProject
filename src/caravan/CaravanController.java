package caravan;

import graph.*;
import view.Marks;
import view.Observable;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * Created by lenovo on 3/10/2015.
 */
public class CaravanController {

    private int width;
    private int height;
    private int from;
    private int to;
    private ContentMutableGraph graph;
    private Observable observable;
    private DepthMarks marks;
    private int TIME_SLEEP = 400;

    private void pause(){
        try{
            Thread.sleep(TIME_SLEEP);
        } catch (InterruptedException exc){

        }
    }

    private void initView(int width, int height){
        this.observable = new Observable();
        Visualization observer = new Visualization(width, height);
        this.observable.addObserver(observer.getView());

        int max = -1, min = 123456789;
        for (int i = 0; i < this.height; ++ i){
            for (int j = 0; j < this.width; ++ j){
                int id = i * this.height + j;
                CaravanContent content = this.graph.getVertexContent(id);
                this.observable.writeFirstValueVertex(id,
<<<<<<< HEAD
                        Integer.toString(content.getHeight()));
=======
                        Integer.toString(content.getHeight()), 0);
>>>>>>> origin/master
                if (max < content.getHeight()){
                    max = content.getHeight();
                }
                if (min > content.getHeight()){
                    min = content.getHeight();
                }
            }
        }

        this.marks = new DepthMarks(min, max);

        for (int i = 0; i < height; ++ i){
            for (int j = 0; j < height; ++ j){
                int id = i * this.height + j;
                CaravanContent content = graph.getVertexContent(id);
                this.observable.markVertex(id, marks.mark(content.getHeight()));
            }
        }

        this.graph = new CaravanObservableGraph(this.graph, observable);
    }

    private void readData(BufferedReader reader) throws IOException{
        StringTokenizer tokenizer = new StringTokenizer( reader.readLine() );

        height = Integer.parseInt(tokenizer.nextToken());
        width = Integer.parseInt(tokenizer.nextToken());

        MutableGraph graph = new DefaultGraph();

        tokenizer = new StringTokenizer( reader.readLine() );
        for ( int i = 0; i < height; ++ i ) {
            for (int j = 0; j < width; ++j){

                int temp = Integer.parseInt(tokenizer.nextToken());

                Content content = new CaravanContent(temp, -1);
                int num = graph.addVertex(content);

                if ( i != 0 ){
                    if ( ( (CaravanContent)graph.getVertexContent(num - height)
                    ).getHeight() >= temp){
                        graph.addEdge(new Content(), num - height, num);
                    }
                    if ( ( (CaravanContent)graph.getVertexContent(num - height)
                    ).getHeight() <= temp){
                        graph.addEdge(new Content(), num, num - height);
                    }
                }
                if ( j != 0){
                    if (((CaravanContent)graph.getVertexContent(num - 1)
                    ).getHeight() >= temp){
                        graph.addEdge(new Content(), num - 1, num);
                    }
                    if (((CaravanContent)graph.getVertexContent(num - 1)
                    ).getHeight() <= temp){
                        graph.addEdge(new Content() ,num, num - 1);
                    }
                }
            }
            tokenizer = new StringTokenizer(reader.readLine());
        }

        this.from = Integer.parseInt(tokenizer.nextToken());
        this.to = Integer.parseInt(tokenizer.nextToken());
        this.graph = graph;

    }

    private void init() throws GraphLoadingException {

        try(FileInputStream fis = new FileInputStream("caravan.in")) {
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader reader = new BufferedReader( isr );
            readData(reader);
        } catch (IOException e){
            throw new GraphLoadingException();
        }

        initView(width, height);
    }

    private void findMinTrace(){
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();

        deque.add(this.from);
        CaravanContent startContent = graph.getVertexContent(this.from);
        startContent.setCameFromId(-1);
        startContent.setLengthWay(0);
        this.graph.setVertexContent(this.from, startContent);



        this.observable.markVertex(this.from, Marks.nextMark(
                startContent.getLengthWay()));
        this.observable.markVertex(this.to, Marks.nextMark(0));

        main_break:
        while (!deque.isEmpty()){

            int curId = deque.pollFirst();
            Vertex curVertex = this.graph.getVertex(curId);
            CaravanContent curContent = (CaravanContent)curVertex.getContent();
            int length = curContent.getLengthWay();

            for (Integer curEdge : curVertex.getListEdge()){
                int idVertex = this.graph.getEdge(curEdge).getToVertex();
                CaravanContent content =
                        this.graph.getVertexContent(idVertex);
                if (content.getLengthWay() == -1){
                    content.setLengthWay(length + 1);
                    content.setCameFromId(curId);

                    this.graph.setVertexContent(idVertex, content);
                    this.observable.markVertex(idVertex,
                            Marks.nextMark(content.getLengthWay())
                    );
                    pause();
                    this.observable.markVertex(idVertex, marks.mark(content.getHeight()));

                    deque.addLast(idVertex);
                }
                if (idVertex == this.to){
                    break main_break;
                }
            }
        }
    }

    private void markMinTrace(){
        int curId = this.to;
        while (curId != -1){
            observable.markVertex(curId, 0x990000);
            pause();
            curId = ((CaravanContent)graph.getVertexContent(curId))
                    .getCameFromId();
        }
    }

    public void doAlgorithm() throws GraphLoadingException {
        init();
        findMinTrace();
        markMinTrace();
    }

}
