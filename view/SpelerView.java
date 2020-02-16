package PlayingWithFire.view;

import PlayingWithFire.model.Speler;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 * Deze klasse maakt een view aan voor Speler
 * @author GESE
 */
public class SpelerView extends Region {

    
    private Speler model;
    private Image image1 = new Image ("/PlayingWithFire/afbeeldingen/player1.png");
    private Image image2 = new Image ("/PlayingWithFire/afbeeldingen/player2.png");
    private Image image3 = new Image ("/PlayingWithFire/afbeeldingen/dead.png");
    
    /**
     * constructor voor SpelerView
     * @param speler 
     */
    public SpelerView(Speler speler) {
        model = speler;
        double grootte = LevelView.SIZE;
        Rectangle rechthoek = new Rectangle(grootte, grootte);
        if (speler.isDood()){
            rechthoek.setFill(new ImagePattern(image3));
        }
        else if (model.getNr() == 1) {
            rechthoek.setFill(new ImagePattern(image1));
        } else {
            rechthoek.setFill(new ImagePattern(image2));
        }

        getChildren().add(rechthoek);
    }

}
