package caravan;

import graph.*;
<<<<<<< HEAD
=======
import view.Marks;
>>>>>>> origin/master
import view.Observable;

/**
 * Created by user on 24.03.2015.
 */
class CaravanObservableGraph extends ObservableGraph{

    public CaravanObservableGraph(Graph graph, Observable view) {
        super(graph, view);
    }

    @Override
    public void setVertexContent(int id, Content content) {
        super.setVertexContent(id, content);
        view.writeFirstValueVertex(id, Integer.toString(
                ((CaravanContent) content).getHeight()
<<<<<<< HEAD
        ));
        view.writeSecondValueVertex(id, Integer.toString(
                ((CaravanContent) content).getLengthWay()
        ));
=======
        ), 0);
        view.writeSecondValueVertex(id, Integer.toString(
                ((CaravanContent) content).getLengthWay()
        ), Marks.nextMark(((CaravanContent) content).getHeight()));
>>>>>>> origin/master
    }
}
