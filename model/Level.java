package PlayingWithFire.model;

import PlayingWithFire.view.LevelView;
import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.Timer;

/**
 * Met deze klasse maak je het level aan
 * @author GESE
 */
public class Level {

    private Voorwerp[][] rooster;
    private Explosie[][] bommen;
    private int[][][] json;
    private int breedte, hoogte,x2, y2;
    private Speler speler1;
    private Speler speler2;
    private LevelView view;

    /**
     * deze constructor maakt het level aan, de muren worden geplaatst volgens 
     * het json document, de spelers krijgen hun vaste plaats en de vaten 
     * worden random verdeeld over het veld
     * @param k k is de waarde van het gekozen leven
     */
    public Level(int k) {
        Gson gson = new Gson();
        try {
            json = gson.fromJson(new FileReader("src/PlayingWithFire/Layout.json"), int[][][].class);
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }

        hoogte = json[k].length;
        breedte = json[k][0].length;

        bommen = new Explosie[breedte][hoogte];
        rooster = new Voorwerp[breedte][hoogte];

        for (int i = 0; i < breedte; i++) {
            for (int j = 0; j < hoogte; j++) {
                if (json[k][j][i] == 1) {
                    rooster[i][j] = new Muur();
                }
            }
        }

        speler1 = new Speler(1, 1, 1);
        speler2 = new Speler(2, breedte - 2, hoogte - 2);
        rooster[speler1.getX()][speler1.getY()] = speler1;
        rooster[speler2.getX()][speler2.getY()] = speler2;

        for (int i = 0; i < breedte; i++) {
            for (int j = 0; j < hoogte; j++) {
                if (getVoorwerpOp(i, j) != null) {
                    continue;
                }

                if (i == 1 && j == 2
                        || i == 2 && j == 1
                        || i == breedte - 2 && j == hoogte - 3
                        || i == breedte - 3 && j == hoogte - 2) {
                    continue;
                }

                Random rand = new Random();
                int upperbound = 101;
                int kans = rand.nextInt(upperbound);
                if (kans < 80) {
                    rooster[i][j] = new Vat();
                }
            }
        }
    }
    
    /**
     * Een setter voor de view 
     * @param view 
     */
    public void setView(LevelView view) {
        this.view = view;
    }
    
    /**
     * Welk voorwerp bevind zich op deze plaats in rooster?
     * @param x x-waarde van het voorwerp
     * @param y y-waarde van het voorwerp
     * @return het type voorwerp op x,y in de array rooster
     */
    public Voorwerp getVoorwerpOp(int x, int y) {
        if (x < 0 || x >= breedte) {
            return null;
        }
        if (y < 0 || y >= hoogte) {
            return null;
        }
        return rooster[x][y];
    }
    
    /**
     * Waar bevindt de explosie plaats?
     * @param x x-waarde van de explosie
     * @param y y-waarde van de explosie
     * @return positie van de explosie en slaat die op in array bommen
     */
    public Explosie getExplosieOp(int x, int y) {
        if (x < 0 || x >= breedte) {
            return null;
        }
        if (y < 0 || y >= hoogte) {
            return null;
        }
        return bommen[x][y];
    }
    
    /**
     * Wat is de breedte van het speelveld?
     * @return de breedte
     */
    public int getBreedte() {
        return breedte;
    }

    /**
     * Wat is de hoogte van het speelveld?
     * @return de hoogte
     */
    public int getHoogte() {
        return hoogte;
    }

    /**
     * De methode gaat controleren of de speler in een powerup loopt
     * bij bliksem vergroot de range van de bommen met 1
     * bij een bom vergroot het aantal bommen dat geplaatst kan worden met 1
     * @param speler speler in het spel
     * @param x2 x-waarde van de powerup
     * @param y2 y-waarde van de powerup
     */
    public void powerup(Speler speler, int x2, int y2) {
        if (getVoorwerpOp(speler.getX() + x2, speler.getY() + y2) instanceof PowerUpBliksem) {
            speler.setRange(speler.getRange() + 1);
            rooster[speler.getX()][speler.getY()] = null;
            rooster[speler.getX()+x2][speler.getY()+y2] = null;
        }
        if (getVoorwerpOp(speler.getX() + x2, speler.getY() + y2) instanceof PowerUpBom) {
            speler.setAantalBommen(speler.getAantalBommen() + 1);
            rooster[speler.getX()][speler.getY()] = null;
            rooster[speler.getX()+x2][speler.getY()+y2] = null;
        }
    }
   

    /**
     * Methode voor een speler naar rechts te bewegen
     * @param nr het nummer van de speler
     */
    public void beweegRechts(int nr) {
        Speler speler = this.getSpeler(nr);
        x2=1;
        y2=0;
        powerup(speler, x2, y2);

        if (getVoorwerpOp(speler.getX() + 1, speler.getY()) != null) {
            return;
        }

        rooster[speler.getX()][speler.getY()] = null;
        speler.setX(speler.getX() + 1);
        rooster[speler.getX()][speler.getY()] = speler;
    }

    /**
     * Methode voor een speler naar links te bewegen
     * @param nr het nummer van de speler
     */
    public void beweegLinks(int nr) {
        Speler speler = this.getSpeler(nr);
        x2=-1;
        y2=0;
        powerup(speler, x2, y2);

        if (getVoorwerpOp(speler.getX() - 1, speler.getY()) != null) {
            return;
        }

        rooster[speler.getX()][speler.getY()] = null;
        speler.setX(speler.getX() - 1);
        rooster[speler.getX()][speler.getY()] = speler;
    }

    /**
     * Methode voor een speler naar boven te bewegen
     * @param nr nummer van de speler
     */
    public void beweegBoven(int nr) {
        Speler speler = this.getSpeler(nr);
        x2=0;
        y2=-1;
        powerup(speler, x2, y2);

        if (getVoorwerpOp(speler.getX(), speler.getY() - 1) != null) {
            return;
        }

        rooster[speler.getX()][speler.getY()] = null;
        speler.setY(speler.getY() - 1);
        rooster[speler.getX()][speler.getY()] = speler;
    }

    /**
     * Methode voor een speler naar onder te bewegen
     * @param nr nummer van de speler
     */
    public void beweegOnder(int nr) {
        Speler speler = this.getSpeler(nr);
        x2=0;
        y2=1;
        powerup(speler, x2, y2);
        
        if (getVoorwerpOp(speler.getX(), speler.getY() + 1) != null) {
            return;
        }
        rooster[speler.getX()][speler.getY()] = null;
        speler.setY(speler.getY() + 1);
        rooster[speler.getX()][speler.getY()] = speler;
    }

    /**
     * Welke speler hoort bij het nummer?
     * @param nr het nummer van de speler
     * @return null als er geen speler beweegt
     */
    private Speler getSpeler(int nr) {
        if (nr == 1) {
            return this.speler1;
        }
        if (nr == 2) {
            return this.speler2;
        }
        return null;
    }

    /**
     * Methode plaatst een bom waar de speler staat
     * @param nr nummer van de speler die de bom plaatst
     * @return bom als het plaatsen ervan mogelijk is
     */
    public Bom plaatsBom(int nr) {
        Speler speler = this.getSpeler(nr);
        if (speler.isDood())return null;
        if (speler.getGeplaatsteBommen() >= speler.getAantalBommen()) {
            return null;
        }
        speler.setGeplaatsteBommen(speler.getGeplaatsteBommen() + 1);
        Bom bom = new Bom(speler);
        bommen[bom.getX()][bom.getY()] = bom;

        return bom;
    }

    /**
     *Methode voor de ontploffing
     * @param bom de bom die ontploft
     */
    public void ontplof(Bom bom) {
        bom.ontplof();

        Speler speler = this.getSpeler(bom.getNrSpeler());
        speler.setGeplaatsteBommen(speler.getGeplaatsteBommen() - 1);

        int[][] richtingen = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
        };

        for (int i = 0; i < richtingen.length; i++) {
            int dx = richtingen[i][0];
            int dy = richtingen[i][1];

            int x = bom.getX();
            int y = bom.getY();

            bommen[x][y] = null;

            verspreid(x, y, dx, dy, bom.getRange(), speler);
        }

    }

    /**
     * recursieve functie om vuur te verspreiden
     *
     * @param x x-waarde van de bom
     * @param y y-waarde van de bom
     * @param dx verplaatsing in de x richting
     * @param dy verplaatsing in de y richting
     * @param range de lengte van de verspreiding van de explosie
     * @param speler de speler waarvan het vuur moet verspreiden 
     */
    public void verspreid(int x, int y, int dx, int dy, int range, Speler speler) {
        Voorwerp vw = getVoorwerpOp(x, y);
        Explosie bvw = (Explosie) bommen[x][y];

        if (vw instanceof Speler) {
            ((Speler) vw).sterf();
        }

        if (vw instanceof Muur) {
            return;
        }

        if (bvw instanceof Bom) {
            ontplof((Bom) bvw);
        }

        maakVuur(x, y, speler);

        if (vw instanceof Vat) {
            rooster[x][y] = null;
            Random rand = new Random();
            int upperbound = 101;
            int kans = rand.nextInt(upperbound);
            if (kans < 16) {
                if (kans < 8) {
                    rooster[x][y] = new PowerUpBom();
                } else {
                    rooster[x][y] = new PowerUpBliksem();
                }
            }
            return;
        }

        if (range == 0) {
            return;
        }

        verspreid(x + dx, y + dy, dx, dy, range - 1, speler);
    }

    /**
     * Methode om het vuur te creëren en opslaat in array bommen 
     * @param x x-waarde van het vuur
     * @param y y-waarde van het vuur
     * @param speler welke speler heeft de bom geplaatst
     */
    public void maakVuur(int x, int y, Speler speler) {
        Vuur vuur = new Vuur(x, y, speler);

        bommen[x][y] = vuur;

        Verdwijn v = new Verdwijn(this, vuur, view);
        Timer t = new Timer(true);
        t.schedule(v, 500);
    }

    /**
     * Methode om het vuur te laten verdwijnen
     * @param vuur het vuur wat moet verdwijnen
     */
    public void verdwijn(Vuur vuur) {
        bommen[vuur.getX()][vuur.getY()] = null;
    }

}
