package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by user on 24.03.2015.
 */
public interface SwingableBlock {
    public void paintBlock(Graphics2D graphics2D);
    public void connectComponent(JComponent component);
}
