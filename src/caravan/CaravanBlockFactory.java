package caravan;

import view.Block;
import view.BorderColor;
import view.VertexBlock;
import view.BlockFactory;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by user on 24.03.2015.
 */
class CaravanBlockFactory implements view.BlockFactory {

    private int curId = 0;
    private ArrayList<VertexBlock> listRectangles = new ArrayList<>();
    private static int SPACE_WIDTH = 50;
    private static int SPACE_HEIGHT = 50;

    public CaravanBlockFactory(Dimension table,
                               Dimension sizeComponent) {
        int blockWidth = (sizeComponent.width - SPACE_WIDTH) / table.width;
        int blockHeight = (sizeComponent.height - SPACE_HEIGHT) / table.height;

        for (int i = 0; i < table.height; ++ i){
            for (int j = 0; j < table.width; ++ j){
                Rectangle rect = new Rectangle(j * blockWidth, i * blockHeight,
                        blockWidth, blockHeight);
                VertexBlock myRect = new VertexBlock(rect, 0xffffff, new BorderColor(0));
                listRectangles.add(myRect);
            }
        }
    }

    @Override
    public boolean hasBlock() {
        return (curId < listRectangles.size());
    }

    @Override
    public Block nextBlock() {
        return listRectangles.get(curId ++);
    }

    @Override
    public void clearIterator() {
        curId = 0;
    }
}
