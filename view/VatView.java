package PlayingWithFire.view;

import PlayingWithFire.model.Vat;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 * Deze klasse maakt een view aan voor Vat
 * @author GESE
 */
public class VatView extends Region {

    private Vat model;
    private Image image = new Image("/PlayingWithFire/afbeeldingen/barrel.png");

    /**
     * de constructor voor VatView
     * @param vat 
     */
    public VatView(Vat vat) {
        model = vat;
        double SIZE = LevelView.SIZE;
        Rectangle rechthoek = new Rectangle(SIZE, SIZE);
        rechthoek.setFill(new ImagePattern(image));
        getChildren().add(rechthoek);
    }
}
