package PlayingWithFire.view;

import javafx.scene.layout.Region;
import PlayingWithFire.model.Vuur;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 * Deze klasse maakt een view aan voor Vuur
 * @author braml
 */
public class VuurView extends Region {
    private Vuur model;
    private Image image1 = new Image("/PlayingWithFire/afbeeldingen/explosie11.png");
    private Image image2 = new Image("/PlayingWithFire/afbeeldingen/explosie21.png");
    
    /**
     * de constructor voor VuurView
     * @param vuur 
     */
    public VuurView (Vuur vuur){
        model = vuur;
        double grootte = LevelView.SIZE;
        Rectangle rechthoek = new Rectangle(grootte, grootte);
        if (model.spelerNr() == 1) {
            rechthoek.setFill(new ImagePattern(image1));
        } else {
            rechthoek.setFill(new ImagePattern(image2));
        }
        getChildren().add(rechthoek);
    }
}
