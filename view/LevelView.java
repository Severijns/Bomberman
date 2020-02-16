package PlayingWithFire.view;

import PlayingWithFire.model.Bom;
import PlayingWithFire.model.Explosie;
import PlayingWithFire.model.PowerUpBliksem;
import PlayingWithFire.model.Level;
import PlayingWithFire.model.Muur;
import PlayingWithFire.model.PowerUpBom;
import PlayingWithFire.model.Speler;
import PlayingWithFire.model.Vat;
import PlayingWithFire.model.Voorwerp;
import PlayingWithFire.model.Vuur;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 * Deze klasse maakt een view aan voor het Level
 * @author GESE
 */
public class LevelView extends Region {

    private Level model;
    public static final int SIZE = 40;
    private Image image = new Image("/PlayingWithFire/afbeeldingen/floor.png");
    
    /**
     * de constructor voor LevelView
     * @param model 
     */
    public LevelView(Level model) {
        this.model = model;
        update();
    }

    /**
     * een methode die het spel update en de voorwerpen toevoegt aan het spel
     * door de 2 verschillende 2d arrays te doorlopen 
     */
    public void update() {
        int b = model.getBreedte();
        int h = model.getHoogte();
        getChildren().clear();

        Rectangle achtergrond = new Rectangle(SIZE * (model.getBreedte() - 1), SIZE * (model.getHoogte() - 1));
        achtergrond.setFill(new ImagePattern(image));
        achtergrond.setTranslateX(SIZE);
        achtergrond.setTranslateY(SIZE);
        getChildren().add(achtergrond);

       
        
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < h; j++) {
                Voorwerp vw = model.getVoorwerpOp(i, j);
                Explosie ex = model.getExplosieOp(i, j);
                if (ex instanceof Bom) {
                    Bom bom = (Bom) ex;
                    BomView bv = new BomView(bom);
                    bv.setTranslateX(i * SIZE);
                    bv.setTranslateY(j * SIZE);
                    getChildren().add(bv);
                }
                if (ex instanceof Vuur) {
                    Vuur vuur = (Vuur) ex;
                    VuurView vv = new VuurView(vuur);
                    vv.setTranslateX(i * SIZE);
                    vv.setTranslateY(j * SIZE);
                    getChildren().add(vv);
                }
                if (vw instanceof Vat) {
                    Vat steen = (Vat) vw;
                    VatView sv = new VatView(steen);
                    sv.setTranslateX(i * SIZE);
                    sv.setTranslateY(j * SIZE);
                    getChildren().add(sv);
                } else if (vw instanceof Speler) {
                    Speler sp = (Speler) vw;
                    SpelerView sv = new SpelerView(sp);
                    sv.setTranslateX(i * SIZE);
                    sv.setTranslateY(j * SIZE);
                    getChildren().add(sv);
                } else if (vw instanceof PowerUpBliksem) {
                    PowerUpBliksem pu = (PowerUpBliksem) vw;
                    PowerUpBliksemView puv = new PowerUpBliksemView(pu);
                    puv.setTranslateX(i * SIZE);
                    puv.setTranslateY(j * SIZE);
                    getChildren().add(puv);
                } else if (vw instanceof PowerUpBom) {
                    PowerUpBom pub = (PowerUpBom) vw;
                    PowerUpBomView pubv = new PowerUpBomView(pub);
                    pubv.setTranslateX(i * SIZE);
                    pubv.setTranslateY(j * SIZE);
                    getChildren().add(pubv);   
                } else if (vw instanceof Muur) {
                    Muur muur = (Muur) vw;
                    MuurView mv = new MuurView(muur);
                    mv.setTranslateX(i * SIZE);
                    mv.setTranslateY(j * SIZE);
                    getChildren().add(mv);
                }

            }
        }
    }
}
