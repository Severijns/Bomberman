package PlayingWithFire;

import PlayingWithFire.model.Bom;
import PlayingWithFire.model.Level;
import PlayingWithFire.model.Ontplof;
import PlayingWithFire.view.LevelView;
import java.net.URL;
import java.util.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

/**
 * De klasse FXMLPWFController werkt in op het model en creërt data voor de view
 *
 * @author GESE
 */
public class FXMLPWFController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane levelPane;

    @FXML
    private Button reset;

    @FXML
    private AnchorPane menu;

    @FXML
    private Button level1;

    @FXML
    private Button level2;

    private Level model;
    private LevelView view;
    private int k;

    /**
     * methode geeft de datamembers een actie mee
     */
    public void initialize() {
        levelPane.setOnKeyPressed(this::beweegKeyBoard);
        levelPane.setVisible(false);
        menu.setVisible(true);
        level1.setOnAction(event -> level(0));
        level2.setOnAction(event -> level(1));
        reset.setOnAction(event -> reset());
    }

    /**
     * methode voor het spel te starten
     *
     * @param model
     */
    public void setModel(Level model) {
        this.model = model;
        view = new LevelView(model);
        model.setView(view);

        levelPane.getChildren().clear();
        levelPane.getChildren().add(view);
        reset.setFocusTraversable(false);
        view.update();
    }

    /**
     * methode voor de knoppen te koppelen aan bepaalde handelingen
     *
     * @param e
     */
    private void beweegKeyBoard(KeyEvent e) {
        switch (e.getCode()) {
            case LEFT:
                model.beweegLinks(1);
                break;
            case RIGHT:
                model.beweegRechts(1);
                break;
            case UP:
                model.beweegBoven(1);
                break;
            case DOWN:
                model.beweegOnder(1);
                break;
            case Q:
                model.beweegLinks(2);
                break;
            case D:
                model.beweegRechts(2);
                break;
            case Z:
                model.beweegBoven(2);
                break;
            case S:
                model.beweegOnder(2);
                break;
            case ENTER:
                plaatsBom(1);
                break;
            case SPACE:
                plaatsBom(2);
                break;
        }
        view.update();
    }

    /**
     * methode om een bom te plaatsen
     *
     * @param nr nummer van de speler
     */
    private void plaatsBom(int nr) {
        Bom bom = model.plaatsBom(nr);

        if (bom == null) {
            return;
        }

        Ontplof o = new Ontplof(model, view, bom);
        Timer t1 = new Timer(true);
        t1.schedule(o, 2000);
    }

    /**
     * methode voor het spel te resetten
     */
    private void reset() {
        model = new Level(this.k);
        view = new LevelView(model);
        model.setView(view);
        levelPane.getChildren().clear();
        levelPane.setVisible(true);
        levelPane.getChildren().add(view);
        reset.setFocusTraversable(false);
        view.update();
    }

    /**
     * methode voor het level op te starten
     *
     * @param k
     */
    public void level(int k) {
        menu.setVisible(false);
        levelPane.setVisible(true);
        level1.setFocusTraversable(false);
        menu.setFocusTraversable(false);
        levelPane.setFocusTraversable(true);
        this.k = k;
        this.reset();
    }

}
