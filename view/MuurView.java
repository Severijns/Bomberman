package PlayingWithFire.view;

import PlayingWithFire.model.Muur;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 * Deze klasse maakt een view aan voor Muur
 * @author GESE
 */
public class MuurView extends Region{
    private Muur model;
    private Image image = new Image ("/PlayingWithFire/afbeeldingen/wall.png");
    
    /**
     * de constructor voor MuurView
     * @param model 
     */
    public MuurView(Muur model) {
        this.model = model;
        double SIZE =LevelView.SIZE;
        Rectangle rechthoek = new Rectangle(SIZE,SIZE);
        rechthoek.setFill(new ImagePattern(image));
        getChildren().add(rechthoek);
    }
    
    
}
