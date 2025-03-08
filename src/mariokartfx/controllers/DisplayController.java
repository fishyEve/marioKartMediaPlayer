
package mariokartfx.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mariokartfx.MarioKartFX;


public class DisplayController implements Initializable {
    // Initalize the label here
    @FXML
    private Label competitors;
    

    // We'll keep this here because it seems important
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }     // end of initalize

    
    public void display(MouseEvent event){
        // this method will display the competitor information to the user
        Button button = (Button) event.getSource();
        String buttonText = button.getText();
        // if the user hits the button that says 'They're not here...'
        if (buttonText.equals("They're not here...")){
            // then we display the competitors arrayList
            String people = MarioKartFX.competitors.toString();
            // Get rid of the brackets 
            people = people.substring(1, people.length()-1);
            

            competitors.setText(people.replace(",", ""));
        }
        
    } // end of display()
    
    public void quit(MouseEvent event){
        // method for when the user exits the window
        Button button = (Button) event.getSource();
        String buttonText = button.getText();
        // IF the user hits the button with the text 'Ok' I've seen enough...'
        if (buttonText.equals("Ok, I've seen enough, take me back to the main menu")){
            Stage stage = (Stage) button.getScene().getWindow();
            // and we close the stage to take the user back to the main menu
            stage.close();
        }
    } // end of quit()
    

  
    
} // end of class
