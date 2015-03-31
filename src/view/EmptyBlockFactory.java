package view;

/**
 * Created by user on 24.03.2015.
 */
public class EmptyBlockFactory implements  BlockFactory{
    @Override
    public boolean hasBlock() {
        return false;
    }

    @Override
    public Block nextBlock() {
        return null;
    }

    @Override
    public void clearIterator() {

    }
}
