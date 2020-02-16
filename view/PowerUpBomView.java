package PlayingWithFire.view;

import PlayingWithFire.model.PowerUpBom;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 * Deze klasse maakt een view aan voor PowerUpBom
 * @author GESE
 */
public class PowerUpBomView extends Region{
    
    private PowerUpBom model;
    private Image image1 = new Image("/PlayingWithFire/afbeeldingen/bom.png");
    private Image image2 = new Image("/PlayingWithFire/afbeeldingen/powerup.png");

    /**
     * de constructor voor PowerupBomView
     * @param bom 
     */
    public PowerUpBomView(PowerUpBom bom) {
        model = bom;
        double SIZE = LevelView.SIZE;
        Rectangle r1 = new Rectangle(SIZE, SIZE);
        r1.setFill(new ImagePattern(image1));
        Rectangle r2 = new Rectangle(SIZE, SIZE);
        r2.setFill(new ImagePattern(image2));
        getChildren().addAll(r1,r2);
    }
}
