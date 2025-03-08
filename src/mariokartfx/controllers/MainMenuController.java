
package mariokartfx.controllers;
// important imports for this controller
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import mariokartfx.MarioKartFX;


public class MainMenuController implements Initializable  {
    // this is the CONTROLLER for the main menu


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // this is here because netBeans automatically put it in
    } // end of initialize()  
    
    
    private void openIdAndNameEntryWindow() {
        // When the user registered a competitor, they need a window to open
        // where they can etner competitor information. This method handles that
        try{
            // we have a try catch. We try to pull up the fxml created to register
            // a compettior down below
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("mariokartfx/resources/registerCompetitorWindow.fxml"));
            Parent root = loader.load();
            MarioKartFX.getRegisterCompetitorStage().setScene(new Scene(root));
            RegisterCompetitorWindowController registerCompetitorController = loader.getController();
            // we use the getter from main and then show it
            MarioKartFX.getRegisterCompetitorStage().show();
            
        }catch(IOException ex){
            // this catch catches an IOException.
            System.out.println(ex);
            
        }
    } // end of openIdAndNameEntryWindow()
    
    
    private void performTimeTrialWindow() {
        // method to pull up a seperate window for time trials
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("mariokartfx/resources/timeTrials.fxml"));
            Parent root = loader.load();
            MarioKartFX.getTimeTrialStage().setScene(new Scene(root));
            TimeTrialsController timeTrialController = loader.getController();
            // use the getter from the main to show the scene
            MarioKartFX.getTimeTrialStage().show();    
        }catch(IOException ex){
            // this catch catches an IOException
            System.out.println(ex);
        }
        
    } // end of performTimeTrialWindow
    
    
    public void displayWindow() {
        // this method will handle displaying the display window
        // I think I'm funny
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("mariokartfx/resources/display.fxml"));
            Parent root = loader.load();
            MarioKartFX.getDisplayStage().setScene(new Scene(root));
            DisplayController displayController = loader.getController();
            // use the getter from the main to show the scene
            MarioKartFX.getDisplayStage().show();
        } catch (IOException ex) {
            // this catch catches an IOException
            System.out.println(ex);
        }

    } // end of displayWindow()
    
    

    @FXML
    private void onMouseClick(MouseEvent mouseEvent) {
        // this is the onMouseClick method. Used to deal with the user clicking 
        // buttons on the main menu.
        // Labelled as an FXML for good coding practice
        
        // we create a button and get the text from it
        Button button = (Button) mouseEvent.getSource();
        String buttonText = button.getText();
        // Here we have a switch case, where we will execute certain commands
        // based on the button the user clicked on the main menu
        switch (buttonText){
            case "Register Competitor":
                // if the user chooses to register a competitor...we need to
                // open the window for the user to do so.
                openIdAndNameEntryWindow();
                // add one to count to keep track of how many registered 
                // competitors we have    
                break;
            case "Race":
                // open a window for the user to perform a time trial
                performTimeTrialWindow();
                break;
            case "Display Competitors":
                // we need to open a window that'll show all of the competitors
                displayWindow();
                
                break;
            case "Quit":
                // platform.exit() terminates the window
                Platform.exit();
                break;

        }
    } // end of onMouseClick()
    
    
} // end of class
