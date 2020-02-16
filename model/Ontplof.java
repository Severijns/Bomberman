package PlayingWithFire.model;

import PlayingWithFire.view.LevelView;
import java.util.TimerTask;
import javafx.application.Platform;

/**
 * Deze klasse erft van timertask en is gemaakt om de bom na een bepaalde tijd 
 * te doen ontploffen
 * @author GESE
 */
public class Ontplof extends TimerTask {
    private Bom bom;
    private LevelView view;
    private Level model;

    /**
     * een constructor voor ontplof
     * @param model het model van het spel
     * @param view de view van het spel
     * @param bom de bom die ontploft
     */
    public Ontplof(Level model, LevelView view, Bom bom) {
        this.bom = bom;
        this.view = view;
        this.model = model;
    }

    /**
     * de run methode gaat de bom laten ontploffen en de view updaten 
     */
    public void run() {
        if(this.bom.ontploft()) return;
        model.ontplof(this.bom);
        Platform.runLater(view::update);
    }

}
