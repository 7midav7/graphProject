package view;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by lenovo on 2/16/2015.
 */
public class EdgeBlock extends Rectangle2D.Double implements Block{
    private Color color;
    private String valueUp;
    private String valueDown;
    private JComponent jComponent;

    public EdgeBlock(Rectangle rect, Color color) {
        super(rect.x, rect.y, rect.width, rect.height);
        this.color = color;
        this.valueUp = "";
        this.valueDown = "";
    }

    @Override
    public void markBlock(int color) {
        this.color = new Color(color);
        try{
            Thread.sleep(200);
        } catch (InterruptedException exc){

        }
        jComponent.repaint();
    }

    @Override
    public void writeFirstValue(String value) {
        this.valueUp = value;
        jComponent.repaint();
    }

    @Override
    public void writeSecondValue(String value) {
        this.valueDown = value;
        jComponent.repaint();
    }

    @Override
    public void paintBlock(Graphics2D gr2){
        int x = (int)super.x;
        int y = (int)super.y;
        int w = (int)super.width;
        int h = (int)super.height;

        gr2.setPaint(color);
        gr2.fill(this);
        gr2.setPaint(new Color(0));

        gr2.setPaint(new Color(0));
        gr2.drawString( valueUp, x + 20, y + 20);
        gr2.drawString( valueDown, x + 20, y + 40);
    }

    @Override
    public void connectComponent(JComponent component) {
        jComponent = component;
    }
}
