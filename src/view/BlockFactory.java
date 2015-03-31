package view;

/**
 * Created by user on 24.03.2015.
 */
public interface BlockFactory {
    public boolean hasBlock();
    public Block nextBlock();
    public void clearIterator();
}
