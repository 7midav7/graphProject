package caravan;

/**
 * Created by user on 27.03.2015.
 */
class DepthMarks {
    private int maxDepth;
    private int minDepth;

    public DepthMarks(int maxDepth, int minDepth) {
        if (maxDepth > minDepth) {
            this.maxDepth = maxDepth;
            this.minDepth = minDepth;
        } else {
            this.maxDepth = minDepth;
            this.minDepth = maxDepth;
        }
    }

    public int mark(int value){
        int temp = (maxDepth - minDepth) / 60;
        int k = value / temp;
        return (240 - k*4) *256*256 + (120 - k*2 )*256 + 60 - k;
    }

    public int getMaxDepth() {
        return maxDepth;
    }

    public void setMaxDepth(int maxDepth) {
        this.maxDepth = maxDepth;
    }

    public int getMinDepth() {
        return minDepth;
    }

    public void setMinDepth(int minDepth) {
        this.minDepth = minDepth;
    }
}
