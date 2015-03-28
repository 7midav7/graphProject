package view;

import java.awt.*;

/**
 * Created by user on 23.03.2015.
 */
public interface VisualBlock {
    public void markBlock(int color);
    public void writeFirstValue(String value, int color);
    public void writeSecondValue(String value, int color);
}
