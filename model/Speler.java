package PlayingWithFire.model;

/**
 * Deze klasse maakt een speler aan en erft van voorwerp
 * @author GESE
 */
public class Speler extends Voorwerp {

    private boolean dood;
    private int x,y,range,aantalBommen,geplaatsteBommen,nr;
    private boolean isBreekbaar;
    
    /**
     * een constructor voor de eigenschappen van de speler
     * @param speler welke speler is het?
     * @param x x-waarde van de speler
     * @param y y-waarde van de speler
     */
    public Speler(int speler, int x, int y) {
        dood = false;
        nr = speler;
        isBreekbaar = true;
        this.x=x;
        this.y=y;
        range = 2;
        aantalBommen= 1;
        geplaatsteBommen =0;
    }

    /**
     * methode voor te bepalen als de speler dood is
     * @return dood als de speler dood is
     */
    public boolean isDood() {
        return dood;
    }
    
    /**
     * methode voor de speler dood te maken
     */
    public void sterf(){
        dood = true;
    }

    /**
     * Wat is het nummer van de speler?
     * @return het nr van de speler
     */
    public int getNr() {
        return nr;
    }

    /**
     * Wat is de x-waarde van de speler?
     * @return de x-waarde van de speler
     */
    public int getX() {
        return x;
    }

    /**
     * setter om de x-waarde te veranderen
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Wat is de y-waarde van de speler
     * @return de y-waarde van de speler
     */
    public int getY() {
        return y;
    }

    /**
     * setter om de y-waarde te veranderen
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Wat is de range?
     * @return the range
     */
    public int getRange() {
        return range;
    }

    /**
     * Setter om de range te veranderen
     * @param range the range to set
     */
    public void setRange(int range) {
        this.range = range;
    }

    /**
     * Wat is het aantal bommen dat de speler kan plaatsen?
     * @return the aantalBommen
     */
    public int getAantalBommen() {
        return aantalBommen;
    }

    /**
     * Hoeveel bommen zijn er geplaatst?
     * @return the geplaatsteBommen
     */
    public int getGeplaatsteBommen() {
        return geplaatsteBommen;
    }

    /**
     * setter om het aantal bommen dat de speler kan plaatsen te veranderen
     * @param aantalBommen the aantalBommen to set
     */
    public void setAantalBommen(int aantalBommen) {
        this.aantalBommen = aantalBommen;
    }

    /**
     * setter om het aantal geplaatse bommen te veranderen
     * @param geplaatsteBommen het aantal geplaatste bommen
     */
    public void setGeplaatsteBommen(int geplaatsteBommen) {
        this.geplaatsteBommen = geplaatsteBommen;
    }
    
}
