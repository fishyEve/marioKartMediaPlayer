
package mariokartfx.controllers;

// important imports:
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;
import mariokartfx.MarioKartFX;


public class TimeTrialsController implements Initializable  {
    
    // String will keep track of WHICH track the user selects
    public static String text = "";
    
    
  // these need to be initalized here, and will come to use later in this class
    @FXML
    private MediaView mediaView;
    @FXML
    private Button playButton, pauseButton, resetButton;   
    private File file;           
    private Media media;
    private MediaPlayer mediaPlayer;

 
    
    public void openVideoWindow() {
        // a method to display a new window with the corresponding video for the
        // map the user chooses
        try {
            // we have a try catch. We try to pull up the fxml created to register
            // a compettior down below
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("mariokartfx/resources/videoPlayer.fxml"));
            Parent root = loader.load();
            MarioKartFX.getVideoStage().setScene(new Scene(root));
            TimeTrialsController timeTrialsController = loader.getController();
            // we use the getter from main and then show it
            MarioKartFX.getVideoStage().show();


        } catch (IOException ex) {
            // this catch catches an IOException.
            System.out.println(ex);

        }
    } // end of openVideoWindow()
    
    
    
    @FXML
    public void onMouseClick(MouseEvent mouseEvent){
        // we create a button and get the text from it
        Button button = (Button) mouseEvent.getSource();
        String buttonText = button.getText();
        // Here we have a switch case, where we will execute certain commands
        // based on the button the user clicked on the main menu
        switch (buttonText){
            case "Sunshine Airport":
                if (buttonText.equals("Sunshine Airport")){
                    // if the user selects sunshine airport, we make the text
                    // that, and then open the display window
                    text = "Sunshine Airport";
                    displayWindow();  
                }
            case "Dolphin Shoals":               
                if (buttonText.equals("Dolphin Shoals")){
                    // if the user selects dolphin shoals, we make the text
                    // that, and then open the display window
                    text = "Dolphin Shoals";
                    displayWindow(); 
                }
            case "Electrodrome":
                if (buttonText.equals("Electrodrome")){
                    // if the user selects Electrodrome, we make the text
                    // that, and then open the display window
                    text = "Electrodrome";
                    displayWindow();
                } 
            case "Mount Wario":
                if (buttonText.equals("Mount Wario")){
                    // if the user selects mount wario, we make the text
                    // that, and then open the display window
                    text = "Mount Wario";
                    displayWindow(); 
                }                    
        }    

    } // end of onMouseClick()
    
    
    
    @Override
    // we will actually use initalize here
    public void initialize(URL url, ResourceBundle rb) {
        // so, if text is sunshine airport, we will specifically play the 
        // sunshine airport mp4
        if (text.equals("Sunshine Airport")) {
            // first we make the specific file with the Sunshine Airport race
            // in it
            file = new File("SunshineAirport_Video.MP4");
            // we make a new media which is that file toString
            media = new Media (file.toURI().toString());
            // then we make a new media player with that media...
            mediaPlayer = new MediaPlayer(media);
            // and then we set it!
            mediaView.setMediaPlayer(mediaPlayer);
        }
        // we do the same thing here as we did for Sunshine, but with Dolphin
        else if (text.equals("Dolphin Shoals")){
            // make the file with Dolphin Shaols mp4
            file = new File("Dolphin_Shoals_Video.MP4");
            // make the media equal to that file but toString..
            media = new Media (file.toURI().toString());
            // make the media player play that media
            mediaPlayer = new MediaPlayer(media);
            // and set it!
            mediaView.setMediaPlayer(mediaPlayer);
            
        }
        // same thing for Electrodrome...
        else if (text.equals("Electrodrome")){
            // make the file...
            file = new File("Electrodrome_Video.MP4");
            // make the media...
            media = new Media (file.toURI().toString());
            // make the mediaPlayer...
            mediaPlayer = new MediaPlayer(media);
            // and set it!
            mediaView.setMediaPlayer(mediaPlayer);
        }
        // same thing one last time for Mount Wario
        else if (text.equals("Mount Wario")){
            // make the file..
            file = new File("Mount_Wario_Video.MP4");
            // make the media...
            media = new Media (file.toURI().toString());
            // make the mediaPlayer
            mediaPlayer = new MediaPlayer(media);
            // and boom, set it
            mediaView.setMediaPlayer(mediaPlayer);
            
        }
      
        
    } // end of initalize()
    
    
    public void displayWindow() {
        // this method will open a video window based on what the text is
        // IF text is Sunshine Airport
        if (text.equals("Sunshine Airport")) {
            // open video window
            openVideoWindow();
        }
        // IF text is Dolphin Shoals
        if (text.equals("Dolphin Shoals"));
        {   // open video window
            openVideoWindow();
        }
        // IF text is Electrodrome
        if (text.equals("Electrodrome")) {
            // open video window
            openVideoWindow();
        }
        // IF text is Mount Wario
        if (text.equals("Mount Wario")) {
            // open video window
            openVideoWindow();
        }
    } // end of displayWindow()
     
    
    //This activates the play button so that it actually plays the video
    @FXML
    public void playMedia(){
        mediaPlayer.play();
    }   // End of playMedia()
    
    //This activates the pause button so that it stops the video
    @FXML
    public void pauseMedia(){
        mediaPlayer.pause();
    }    // End of pauseMedia()
    
    // This activates the reset button so that it sets the progress bar to 0 
    // in the video.
    @FXML
    public void resetMedia(){
        mediaPlayer.seek(Duration.seconds(0.0));
    }    // End of resetMedia
    
    
    
    
    
    public void quit(MouseEvent event){
        // method for the user to quit out of the window
        
        // FIRSTLY we need to set everything back to null so this window 
        // can be reopened
        mediaPlayer = null;
        media = null;
        file = null;
        mediaView = null;
        text = "";
        
        // then we can actually exit
        Button button = (Button) event.getSource();
        String buttonText = button.getText();
        // IF the user hits the button with the text 'Take me back to the Main Menu'
        if (buttonText.equals("Take me back to the Main Menu")){
    
            Stage stage = (Stage) button.getScene().getWindow();
            // and we close the stage to take the user back to the main menu
            stage.close();          
            
        }
    } // end of quit()
    
    
    
    
    public void quitVideo(MouseEvent event){
        // method for the user to quit out of the window SPECIFCALLY for the 
        // video player
        
        // first of all, we need to stop the mediaPlayer
        mediaPlayer.stop();
        
        Button button = (Button) event.getSource();
        String buttonText = button.getText();
        // IF the user hits the button with the text 'QUIT'
        if (buttonText.equals("QUIT")){
    
            Stage stage = (Stage) button.getScene().getWindow();
            // and we close the stage to take the user back to the original window
            stage.close();
            


        }
    } // end of quitVideo()
   
    

    
    
} // end of class
