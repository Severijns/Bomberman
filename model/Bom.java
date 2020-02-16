package PlayingWithFire.model;

/**
 * Met deze klasse kan je een bom aanmaken die erft van klasse explsie
 * @author GESE
 */
public class Bom extends Explosie {

    private int x, y, range, nrSpeler;
    private boolean ontploft = false;

    /**
     * Constructor voor een bom te maken met een coordinaat, range van de
     * explosie en het nummer van de speler die hem plaats
     *
     * @param speler geef de speler mee die de bom plaats
     */
    public Bom(Speler speler) {
        x = speler.getX();
        y = speler.getY();
        range = speler.getRange();
        nrSpeler = speler.getNr();
    }

    /**
     * Wat is het x-coördinaat van de bom?
     *
     * @return x de x-waarde van de bom
     */
    public int getX() {
        return x;
    }

    /**
     * Verander de x waarde van de bom
     *
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Wat is het y-coördinaat van de bom?
     *
     * @return y het y-coördinaat van de bom
     */
    public int getY() {
        return y;
    }

    /**
     * verander de y waarde van de bom
     *
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Wat is de range van de explosie van de bom?
     *
     * @return the range
     */
    public int getRange() {
        return range;
    }

    /**
     * Welke speler plaatst de bom?
     *
     * @return the nrSpeler
     */
    public int getNrSpeler() {
        return nrSpeler;
    }

    /**
     * Laat de bom ontploffen
     */
    public void ontplof() {
        this.ontploft = true;
    }

    /**
     * Is de bom ontploft?
     *
     * @return true wanneer de bom is ontploft
     */
    public Boolean ontploft() {
        return this.ontploft;
    }
}
