package castle;

import graph.ContentMutableGraph;
import view.Observable;

/**
 * Created by user on 29.03.2015.
 */
class ViewInitiator {
    public void init(Model model, Observable observable){
        int width = model.getWidth();
        int height = model.getHeight();
        ContentMutableGraph graph = model.getGraph();

        observable.init();

        for (int i = 0; i < height; ++ i){
            for (int j = 0; j < width; ++ j){
                CastleContent content =
                        graph.getVertexContent(i * height + j);
                observable.writeFirstValueVertex(i * height + j,
                        Integer.toString(content.getTypeRoom()));
            }
        }

    }
}
