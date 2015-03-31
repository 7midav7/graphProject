package view;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by user on 23.03.2015.
 */
public class AbstractView implements ViewObserver{
    private ArrayList<VisualBlock> listVertex = new ArrayList<VisualBlock>();
    private ArrayList<VisualBlock> listEdge = new ArrayList<VisualBlock>();
    private ViewInitable viewInitable;

    @Override
    public void markVertex(int id, int color){
        VisualBlock block = listVertex.get(id);
        if (block != null){
            block.markBlock(color);
        }
    }

    @Override
    public void init() {
        viewInitable.init();
    }

    @Override
    public void writeFirstValueVertex(int id, String value){
        VisualBlock block = listVertex.get(id);
        if (block != null){
            block.writeFirstValue(value);
        }
    }

    @Override
    public void writeSecondValueVertex(int id, String value){
        VisualBlock block = listVertex.get(id);
        if (block != null){
            block.writeSecondValue(value);
        }
    }

    @Override
    public void markEdge(int id, int color){
        VisualBlock block = listEdge.get(id);
        if (block != null){
            block.markBlock(color);
        }
    }

    public void addVertexBlock(VisualBlock block){
        listVertex.add(block);
    }

    public void addEdgeBlock(VisualBlock block){
        listEdge.add(block);
    }

    public void removeVertexBlock(int id){
        listVertex.remove(id);
    }

    public void addEdgeBlock(int id){
        listEdge.remove(id);
    }

    public ViewInitable getViewInitable() {
        return viewInitable;
    }

    public void setViewInitable(ViewInitable viewInitable) {
        this.viewInitable = viewInitable;
    }
}
