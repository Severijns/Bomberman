package PlayingWithFire.view;

import PlayingWithFire.model.Bom;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 * Deze klasse maakt een view aan voor Bom
 * @author GESE
 */
public class BomView extends Region {

    private Bom model;
    private Image image = new Image ("/PlayingWithFire/afbeeldingen/bom.png");
    
    /**
     * De constructor voor BomView
     * @param bom 
     */
    public BomView(Bom bom) {
        model = bom;
        double SIZE = LevelView.SIZE;
        Rectangle rechthoek = new Rectangle(SIZE,SIZE);
        rechthoek.setFill(new ImagePattern(image));
        getChildren().add(rechthoek);
    }
}
