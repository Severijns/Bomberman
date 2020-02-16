/**
 * Tim Severijns 80%
 * TimerTasken, modelen en views van de voorwerpen en explosies 
 * level opbouw, json, verspreiden en verdwijnen vuur,...
 * 
 * Bram Libens 15%
 * 1ste vorm van bewegen en basis om vaten te laten verdwijnen 
 * gezocht achter werking TimerTask vuur vuur te laten verschijnen en verdwijnen
 * 
 * Rocque Tilmans 5%
 * Javadoc en reset knop aangemaakt
 * 
 * Het pogramma is gebaseerd op dimond cave, zo wordt er gebruik gemaakt van
 * hetzelfde principe voor de view te maken via een 2D array.
 * De afbeeldingen van het spel zijn van Joren Vandeweyer.
 */

package PlayingWithFire;
import PlayingWithFire.model.Level;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * De main klasse voor het spel
 * @author GESE
 */
public class PlayingWithFireMain extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        //maak een level aan
        Level model = new Level(1);
        
        // FXML View
        FXMLLoader lader = new FXMLLoader(getClass().getResource("FXMLPWFView.fxml"));
        Parent root = lader.load();
        
        // FXMLPWFController
        FXMLPWFController controller = lader.getController();
        controller.setModel(model);
        
        // hoofdvenster
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    /**
     * methode voor het spel op te starten
     * @param args 
     */
    public static void main(String[] args) {
        launch(args);
    }
}
