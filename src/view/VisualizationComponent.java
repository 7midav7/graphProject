package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by user on 23.03.2015.
 */
public class VisualizationComponent extends JComponent {

    protected ArrayList<SwingableBlock> vertexList = new ArrayList<>();
    protected ArrayList<SwingableBlock> edgeList = new ArrayList<>();
    private int DEFAULT_HEIGHT = 1000;
    private int DEFAULT_WIDTH = 1000;


    protected VisualizationComponent(Dimension component) {
        DEFAULT_HEIGHT = component.height;
        DEFAULT_WIDTH = component.width;
    }

    public static VisualizationComponent init(AbstractView view, BlockFactory factoryVertex,
                                      BlockFactory factoryEdge ,Dimension sizeComponent){
        VisualizationComponent component = new VisualizationComponent(sizeComponent);

        while ( factoryVertex.hasBlock() ){
            Block block = factoryVertex.nextBlock();
            component.vertexList.add(block);
            block.connectComponent(component);
            view.addVertexBlock(block);
        }

        while ( factoryEdge.hasBlock() ){
            Block block = factoryEdge.nextBlock();
            component.edgeList.add(block);
            block.connectComponent(component);
            view.addEdgeBlock(block);
        }

        return component;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D gr2 = (Graphics2D) g;

        for (SwingableBlock block: vertexList){
            block.paintBlock(gr2);
        }

        for (SwingableBlock block: edgeList){
            block.paintBlock(gr2);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
