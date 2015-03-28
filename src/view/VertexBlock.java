package view;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by lenovo on 2/16/2015.
 */
public class VertexBlock extends Rectangle2D.Double implements Block{
    protected Color color;
    protected Color colorUp;
    protected Color colorDown;
    private String valueUp;
    private String valueDown;
    protected JComponent component;
    protected BorderColor borderColor;

    public VertexBlock(Rectangle rect, int color, BorderColor bColor) {
        super(rect.x, rect.y, rect.width, rect.height);
        this.color = new Color(color);
        this.colorUp = new Color(0);
        this.colorDown = new Color(0);
        this.borderColor = bColor;
        this.valueUp = "";
        this.valueDown = "";
    }


    @Override
    public void paintBlock(Graphics2D gr2) {
        int x = (int)super.x;
        int y = (int)super.y;
        int w = (int)super.width;
        int h = (int)super.height;

        gr2.setPaint(color);
        gr2.fill(this);

        gr2.setStroke(new BasicStroke(2));

        gr2.setPaint(new Color(borderColor.getColor(BorderColor.Type.NORTH)));
        gr2.drawLine(x, y, x + w, y);
        gr2.setPaint(new Color(borderColor.getColor(BorderColor.Type.WEST)));
        gr2.drawLine(x, y, x, y + h);
        gr2.setPaint(new Color(borderColor.getColor(BorderColor.Type.EAST)));
        gr2.drawLine(x + w, y, x + w, y + h);
        gr2.setPaint(new Color(borderColor.getColor(BorderColor.Type.SOUTH)));
        gr2.drawLine(x, y + h, x + w, y + h);

        gr2.setStroke(new BasicStroke(2));

        gr2.setPaint(this.colorUp);
        gr2.drawString(valueUp, x + 20, y + 20);
        gr2.setPaint(this.colorDown);
        gr2.drawString( valueDown, x + 20, y + 35);
    }

    @Override
    public void markBlock(int color) {
        this.color = new Color(color);
        this.component.repaint();
    }

    @Override
    public void writeFirstValue(String value, int color) {
        this.valueUp = value;
        this.colorUp = new Color(color);
        this.component.repaint();
    }

    @Override
    public void writeSecondValue(String value, int color) {
        this.valueDown = value;
        this.colorDown = new Color(color);
        this.component.repaint();
    }

    @Override
    public void connectComponent(JComponent component) {
        this.component = component;
    }
}
