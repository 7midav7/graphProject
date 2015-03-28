package castle;

import view.*;

import javax.swing.*;
import java.awt.*;

/**
 * Created by user on 24.03.2015.
 */
class Visualization extends JFrame{
    private AbstractView view;

    Visualization(int widthTable, int heightTable, int[][] map) {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        setSize(width / 2, height / 2);
        setLocation(width / 4, height / 4);

        Dimension  sizeComponent = new Dimension(width / 2, height / 2);
        Dimension tableComponent = new Dimension(widthTable, heightTable);
        view = new AbstractView();
        BlockFactory vFactory = new CastleBlockFactory(tableComponent,
                sizeComponent, map
                );
        JComponent drawComponent = VisualizationComponent.init(view,
                vFactory, new EmptyBlockFactory(), sizeComponent
        );
        add(drawComponent);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public AbstractView getView() {
        return view;
    }
}
