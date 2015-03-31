package castle;

import graph.Content;
import graph.DefaultGraph;
import graph.GraphLoadingException;
import graph.MutableGraph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by user on 29.03.2015.
 */
class GraphLoader {

    public void load(Model model, String name) throws GraphLoadingException{
        try(FileInputStream fis = new FileInputStream(name)){
            InputStreamReader isr = new InputStreamReader(fis);
            readData(isr, model);
        } catch (IOException e){
            throw new GraphLoadingException();
        }
    }



    private void readData(InputStreamReader isr, Model model) throws IOException {
        BufferedReader reader = new BufferedReader(isr);
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int width = Integer.parseInt(tokenizer.nextToken());
        int height = Integer.parseInt(tokenizer.nextToken());
        int[][] map = new int[width][height];

        MutableGraph graph = new DefaultGraph();
        for (int i = 0; i < height; ++ i){
            tokenizer = new StringTokenizer(reader.readLine());

            for (int j = 0; j < width; ++ j){
                map[i][j] = Integer.parseInt(tokenizer.nextToken());

                CastleContent content = new CastleContent(map[i][j], -1);
                int curId = graph.addVertex(content);

                if ( (map[i][j]&1) == 0 && j != 0){
                    graph.addEdge(new Content(), curId, curId - 1);
                    graph.addEdge(new Content(), curId - 1, curId);
                }
                if ( (map[i][j]&2) == 0 && i != 0){
                    graph.addEdge(new Content(), curId, curId - height);
                    graph.addEdge(new Content(), curId - height, curId);
                }
            }
        }

        model.setHeight(height);
        model.setWidth(width);
        model.setGraph(graph);
        model.setMap(map);
    }
}
