package castle;

<<<<<<< HEAD
import graph.ContentMutableGraph;
=======
>>>>>>> origin/master
import view.*;

import javax.swing.*;
import java.awt.*;

/**
 * Created by user on 24.03.2015.
 */
<<<<<<< HEAD
class Visualization extends JFrame implements ViewInitable{
    private AbstractView view;
    private Model model;

    Visualization(AbstractView view, Model model) {
=======
class Visualization extends JFrame{
    private AbstractView view;

    Visualization(int widthTable, int heightTable, int[][] map) {
>>>>>>> origin/master
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        setSize(width / 2, height / 2);
        setLocation(width / 4, height / 4);

<<<<<<< HEAD
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        this.view = view;
        this.model = model;
        view.setViewInitable(this);
    }

    @Override
    public void init(){
        Dimension  sizeComponent = new Dimension(getWidth(), getHeight());
        Dimension tableComponent = new Dimension(model.getWidth(), model.getHeight());
        BlockFactory vFactory = new CastleBlockFactory(tableComponent,
                sizeComponent, model.getMap()
        );
=======
        Dimension  sizeComponent = new Dimension(width / 2, height / 2);
        Dimension tableComponent = new Dimension(widthTable, heightTable);
        view = new AbstractView();
        BlockFactory vFactory = new CastleBlockFactory(tableComponent,
                sizeComponent, map
                );
>>>>>>> origin/master
        JComponent drawComponent = VisualizationComponent.init(view,
                vFactory, new EmptyBlockFactory(), sizeComponent
        );
        add(drawComponent);
<<<<<<< HEAD
=======

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
>>>>>>> origin/master
    }

    public AbstractView getView() {
        return view;
    }
}
