package castle;

import graph.ContentMutableGraph;
import view.*;

import javax.swing.*;
import java.awt.*;

/**
 * Created by user on 24.03.2015.
 */
class Visualization extends JFrame implements ViewInitable{
    private AbstractView view;
    private Model model;

    Visualization(AbstractView view, Model model) {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        setSize(width / 2, height / 2);
        setLocation(width / 4, height / 4);

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
        JComponent drawComponent = VisualizationComponent.init(view,
                vFactory, new EmptyBlockFactory(), sizeComponent
        );
        add(drawComponent);
    }

    public AbstractView getView() {
        return view;
    }
}
