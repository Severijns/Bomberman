package PlayingWithFire.model;

/**
 * een klasse die voor het vuur zorgt en erft van explosie
 * @author GESE
 */
public class Vuur extends Explosie {
    
    private int x, y;
    private Speler speler;

    /**
     * constructor van het vuur
     * @param x x-waarde waar de explosie plaatsvindt
     * @param y y-waarde waar de explosie plaatsvindt
     * @param speler de speler die de bom heeft geplaatst
     */
    public Vuur(int x, int y, Speler speler) {
        this.x = x;
        this.y = y;
        this.speler = speler;
    }

    /**
     * Wat is de x-waarde?
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * Wat is de y-waarde?
     * @return the y
     */
    public int getY() {
        return y;
    }
    
    /**
     * Van welke speler is het vuur?
     * @return het nummer van de speler
     */
    public int spelerNr(){
        return speler.getNr();
    }
    
}
