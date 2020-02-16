package PlayingWithFire.view;

import PlayingWithFire.model.PowerUpBliksem;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 * Deze klasse maakt een view aan voor PowerUpBliksem
 * @author GESE
 */
public class PowerUpBliksemView extends Region {

    private PowerUpBliksem model;
    private Image image1 = new Image("/PlayingWithFire/afbeeldingen/powerup.png");
    private Image image2 = new Image("/PlayingWithFire/afbeeldingen/powerup_strength.png");

    /**
     * constructor voor PowerupBliksemView
     * @param bliksem 
     */
    public PowerUpBliksemView(PowerUpBliksem bliksem) {
        model = bliksem;
        double SIZE = LevelView.SIZE;
        Rectangle r1 = new Rectangle(SIZE, SIZE);
        r1.setFill(new ImagePattern(image1));
        Rectangle r2 = new Rectangle(SIZE, SIZE);
        r2.setFill(new ImagePattern(image2));
        getChildren().addAll(r1,r2);
    }
}
