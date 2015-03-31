package castle;

import view.Block;
import view.BorderColor;
import view.VertexBlock;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by user on 24.03.2015.
 */
class CastleBlockFactory implements view.BlockFactory {

    private int curId = 0;
    private ArrayList<VertexBlock> listRectangles = new ArrayList<>();
    private static int SPACE_WIDTH = 50;
    private static int SPACE_HEIGHT = 50;

    public CastleBlockFactory(Dimension table,
                               Dimension sizeComponent, int[][] map) {
        int blockWidth = (sizeComponent.width - SPACE_WIDTH) / table.width;
        int blockHeight = (sizeComponent.height - SPACE_HEIGHT) / table.height;

        for (int i = 0; i < table.height; ++ i){
            for (int j = 0; j < table.width; ++ j){
                Rectangle rect = new Rectangle(j * blockWidth, i * blockHeight,
                        blockWidth, blockHeight);

                BorderColor bColor = new BorderColor(0xffffff);
                int temp = 0;
                if ( (map[i][j] & 1) != 0 ){
                    temp |= 8;
                }
                if ( (map[i][j] & 2) != 0 ){
                    temp |= 1;
                }
                if ( (map[i][j] & 4) != 0 ){
                    temp |= 2;
                }
                if ( (map[i][j] & 8) != 0 ){
                    temp |= 4;
                }

                bColor.setColor(temp, 0);

                VertexBlock myRect = new VertexBlock(rect, 0xffffff, bColor);
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
