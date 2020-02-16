/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlayingWithFire.model;

import PlayingWithFire.view.LevelView;
import java.util.TimerTask;
import javafx.application.Platform;

/**
 * Deze klasse zorgt ervoor dat het vuur verdwijnt na een gekoze tijd
 * @author GESE
 */
public class Verdwijn extends TimerTask {
    private Vuur vuur;
    private LevelView view;
    private Level model;

    /**
     * een constructor voor verdwijn
     * @param model het model van het spel
     * @param vuur het vuur dat moet verdwijnen
     * @param view de view van het spel
     */
    public Verdwijn(Level model, Vuur vuur, LevelView view) {
        this.vuur = vuur;
        this.view = view;
        this.model = model;
    }

    /**
     * run methode roept de functie verdwijn op na een bepaalde tijd en uppdate 
     * de view
     */
    public void run() {
        model.verdwijn(this.vuur);
        Platform.runLater(view::update);
    }

}
