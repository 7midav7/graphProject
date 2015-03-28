package caravan;


import view.AbstractView;
import view.EmptyBlockFactory;
import view.VisualizationComponent;

import javax.swing.*;
import java.awt.*;

/**
 * Created by lenovo on 3/10/2015.
 */
class Visualization extends JFrame{

    private AbstractView view;

    Visualization(int widthTable, int heightTable) {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        setSize(width / 2, height / 2);
        setLocation(width / 4, height / 4);

        view = new AbstractView();
        CaravanBlockFactory factory = new CaravanBlockFactory(
                new Dimension(widthTable, heightTable),
                new Dimension(width / 2, height / 2)
        );
        EmptyBlockFactory emptyFactory = new EmptyBlockFactory();
        JComponent drawComponent = VisualizationComponent.init(
                view, factory, emptyFactory,
                new Dimension(width / 2, height / 2)
        );
        add(drawComponent);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public AbstractView getView() {
        return view;
    }
}
