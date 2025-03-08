
package mariokartfx;
// important imports:
import java.io.IOException;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
// Eve Collier + Devin Rollins
// evecollier3@gmail.com + drollins1108@gmail.com
// CSC 2290 Object Oriented Programming
// Program 5: JavaFX

    /*
    “I (we) will practice academic and personal integrity and excellence of
character and expect the same from others.” 
As an academic community, Florida Southern College is firmly committed to 
honor and integrity in the pursuit of knowledge. Therefore, as a member
of this academic community, each student acknowledges  responsibility  for 
his  or  her  actions  and  commits  to  the  highest  standards  of integrity.  
In doing so through this Honor Code, each student makes a covenant with the
college  not to engage in any form of academic dishonesty, fraud, cheating, 
or theft.  Further information on the Honor Code is available in the
current Catalog.
     */


public class MarioKartFX extends Application {
    // Each stage we have needs to start off as null
    private static Stage registerCompetitorStage = null;
    private static Stage timeTrialStage = null;
    public static Stage displayStage = null;
    public static Stage videoStage = null;
    // this arrayList will store all competitor information
    public static ArrayList <String> competitors = new ArrayList<>();
    


    public void start(Stage primaryStage) throws Exception {
        // the start method will be used to display the main menu
        
        // The following lines will load the scene that displays the main
        // menu created with scene builder
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("resources/mainMenu.fxml"));
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("Mario Kart Main Menu");
        primaryStage.setScene(new Scene(root));
        // this shows the scene
        primaryStage.show();
        // We ALSO need to create a stage for registering a competitor
        createRegisterCompetitorStage();
        // and the same for time trials/race
        createTimeTrialStage();
        // and once more for the display stage
        createDisplayStage();
        // and again for the video stage
        createVideoStage();
   
    } // end of start()
    

    
    public void createRegisterCompetitorStage(){
        // this method deals with the creation of the stage for registering
        // a competitor
        registerCompetitorStage = new Stage();
        registerCompetitorStage.setTitle("Registration");
        // Modality seems imoprtant to set
        registerCompetitorStage.initModality(Modality.APPLICATION_MODAL); 
    } // end of createRegisterCompetitorStage()
    
    
    public void createVideoStage(){
        // this method deals with the creation of a stage for displaying videos
        videoStage = new Stage();
        videoStage.setTitle("Video Player");
        // modality, why not
        videoStage.initModality(Modality.APPLICATION_MODAL);            
    } // end of createVideoStage()
    
    
    public void createTimeTrialStage(){
        // this method creates a stage for performing a time trial
        timeTrialStage = new Stage();
        timeTrialStage.setTitle("Time Trial");
        // Modality seems imoprtant to set
        timeTrialStage.initModality(Modality.APPLICATION_MODAL);
        
    } // end of createTimeTrialStage()
    
    public void createDisplayStage(){
        // this method creates a stage for displaying competitors
        displayStage = new Stage();
        displayStage.setTitle("Competitors");
        // Modality seems imoprtant to set
        displayStage.initModality(Modality.APPLICATION_MODAL);
        
    } // end of createDisplayStage()
    
    
    public static Stage getVideoStage(){
        // a getter for the video stage
        return videoStage;
    } // end of getVideoStage()
    
    
    public static Stage getRegisterCompetitorStage(){
        // this method is a getter for the regisgerCompetitorStage
        return registerCompetitorStage;
        
    } // end of getRegisterCompetitorStage()
    
    
    
    public static Stage getDisplayStage(){
        // a getter for the displayStage
        return displayStage;
    } // end of getDisplayStage()
    
     
    
    public static Stage getTimeTrialStage(){
        // a getter for timeTrialStage()   
        return timeTrialStage;      
    } // end of getTimeTrialStage()
    
    
    public static void main(String [] args){
        // this displays the java FX scene
        launch (args);
    } // end of main()
    
} // end of class
