package castle;

import graph.*;
import view.AbstractView;
import view.Observable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by lenovo on 3/10/2015.
 */
public class CastleController {

    private Model model;
    private Visualization visualization;
    private Observable observable;
    private AbstractView view;
    private Algorithm algorithm; // AbstractAlgorithm

    public CastleController() throws GraphLoadingException{

        this.model = new Model();
        GraphLoader loader = new GraphLoader();
        loader.load(model, "castle.in");

        this.view = new AbstractView();
        this.visualization = new Visualization(view, model);
        this.observable = new Observable();
        this.observable.addObserver(this.view);

        ViewInitiator initiator = new ViewInitiator();
        initiator.init(model, observable);

        this.algorithm = new Algorithm(model, observable);
        algorithm.doAlgorithm();
    }

}
