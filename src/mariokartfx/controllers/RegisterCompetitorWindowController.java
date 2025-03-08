package mariokartfx.controllers;
// important imports:

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mariokartfx.MarioKartFX;

public class RegisterCompetitorWindowController implements Initializable {
    public static String [] characters = {"Mario", "Luigi", "Peach", "Yoshi", "Bowser", "Donkey Kong", "Toad", "Koopa Troopa","Daisy", "Shy Guy", "Wario", "Waluigi", "Baby Mario", "Baby Luigi", "Baby Peach", "Baby Daisy"};
    public static String [] bikes = {"Standard Bike", "Comet", "Sports Bike", "The Duke", "Flame Rider", "Varmint", "Mr. Scooty", "Jet Bike", "Yoshi Bike"};
    // Initalize the labels here
    @FXML
    private Label firstNameError;
    @FXML
    private Label lastNameError;
    @FXML
    private Label IDError;
    @FXML
    private Label characterError;
    @FXML
    private Label bikeError;

    // Then initalize the text fields
    @FXML
    private TextField firstNameText;
    @FXML
    private TextField lastNameText;
    @FXML
    private TextField IDText;
    @FXML
    private TextField characterText;
    @FXML
    private TextField bikeText;

    // and lastly, the buttons
    @FXML
    private Button firstNameButton;
    @FXML
    private Button lastNameButton;
    @FXML
    private Button IDButton;
    @FXML
    private Button characterButton;
    @FXML
    private Button bikeButton;
    
    // we also need to initalize a counter, to see if the user actually attempted
    // to submit all five buttons
    int counter = 0;

    
    public int readAndVerifyCharacter(int numChoices) { //Chawactweows uwu UwU
        // This method will scan the user's choice for the menu and make sure
        // it's 'legal', that meaning, it's equal to one of the numeric choices,
        // is actually a number, and so on. If it's not a legal choice, an 
        // error message will be displayed to the user

        // we get the text from the user
        String userNum = characterText.getText();

        // Next we have to make sure the input is a digit
        if (containsOnlyDigits(userNum)) {
            // If this passes, this means the input is a digit. Now we can
            // parse the input as an int
            int userNum2 = Integer.parseInt(userNum);

            // Next we need to make sure the user selected a number within
            // the choices avalible to them on the menu
            if (userNum2 <= numChoices && userNum2 > 0) {
                return userNum2;
            }

            // If the if doesn't pass, that means the user selected a
            // number not avaliable                 
            else {
                characterError.setText("They are programming me to not have emotions. Try again.");
                return 0;
            }
        }
        //If the user gets to this point, that means the user didn't put 
        // a number in
        else {
            characterError.setText("Please try again, or else Cazalas will fail me.");
            return 0;
        }

    } // END of readAndVerifyChoice()
    
    
    

    public int readAndVerifyBike(int numChoices) {
        // This method will scan the user's choice for the menu and make sure
        // it's 'legal', that meaning, it's equal to one of the numeric choices,
        // is actually a number, and so on. If it's not a legal choice, an 
        // error message will be displayed to the user

        String userNum = bikeText.getText();

        // Next we have to make sure the input is a digit
        if (containsOnlyDigits(userNum)) {
            // If this passes, this means the input is a digit. Now we can
            // parse the input as an int
            int userNum2 = Integer.parseInt(userNum);

            // Next we need to make sure the user selected a number within
            // the choices avalible to them on the menu
            if (userNum2 <= numChoices && userNum2 > 0) {
                return userNum2;

            }

            // If the if doesn't pass, that means the user selected a
            // number not avaliable                 
            else {
                bikeError.setText("Lady Gaga's coming for you. Unless you fix that error.");
                return 0;
            }
        }
        //If the user gets to this point, that means the user didn't put 
        // a number in
        else {
            bikeError.setText("Eventually by Tame Imapala is a good song. Try again, though.");
            return 0;
        }

    } // END of readAndVerifyChoice()
    
    
    
    

    public static boolean containsOnlyDigits(String userInput) {
        // This method will check if string userInput contains only digits
        boolean onlyDigits = true;
        // Here we're simply initializing the boolean variable

        // This for loop will loop through each character of the string
        for (int i = 0; i < userInput.length(); i++) {
            // IF the character is a digit, it will set the onlyDigits boolean 
            // equal to true
            if (Character.isDigit(userInput.charAt(i))) {
                onlyDigits = true;
            }
            // On the other hand, if the character is NOT a digit, the 
            // onlyDigits boolean will be set equal to false
            else {
                return false;
            }
        }
        // We exit the loop, then the onlyDigits boolean is returned
        return onlyDigits;

    } //END of containsOnlyDigits()

    
    
    
    public static boolean containsOnlyLettersSpacesOrDashes(String userInput) {
        // This method will check if string userInput contains only letters,
        // spaces or dashes.

        boolean onlyLettersSpacesOrDashes = true;
        // Here we are simply initializing the boolean variable

        // In this for loop, we will loop through each character of the string
        for (int i = 0; i < userInput.length(); i++) {
            // If the character is a letter, the onlyLetterSpacesOrDashes bool
            // will be set to true
            if (Character.isLetter(userInput.charAt(i))) {
                onlyLettersSpacesOrDashes = true;
            }

            // If that if doesn't pass, we'll check to see if the user input
            // is a space
            else if (Character.isWhitespace(userInput.charAt(i))) {
                onlyLettersSpacesOrDashes = true;
            }

            // and if THAT doesn't pass, let's check to see if the character
            // is a dash
            else if (userInput.charAt(i) == '-') {
                onlyLettersSpacesOrDashes = true;

            }

            // If NONE of those else ifs passed, userInput does NOT contain a 
            // letter, space, or dash.
            else {
                return false;
            }

        }
        // We exit the loop, and return onlyLettersSpacesOrDashes.
        return onlyLettersSpacesOrDashes;

    } // END of containsOnlyLettersSpacesOrDashes()
    
    
    

    public int readAndVerifyID() {
        // Much like readAndVerifyChoice(), this method is ALSO making sure
        // the user puts in a legal choice, except not for a menu. This method
        // ensure the user enters a legal ID 

        // First we need to actually get the user input
        String userID = IDText.getText();

        // If the user's input is longer than 7 characters, OR if it's 0
        // characters long, it'll tell the user that they made an invalid 
        // choice, and then let them enter their input again
        if (userID.length() != 7 || Integer.parseInt(userID) == 0) {
            IDError.setText("Get good kid. ID number must be 7 digits long.");
            return 0;
        }
        // Now we need to make sure the length of the user's input is equal
        // to seven- since that's the allowed length for an entered ID
        else if (userID.length() == 7) {
            // NOW we need to make sure the input is a digit
            if (containsOnlyDigits(userID)) {
                // If this passed, that means the input is a digit, which 
                // means the input can now be parsed into an int
                int userID2 = Integer.parseInt(userID);
                return userID2;
            }
            // If the if doesn't execute, that means that the user entered an
            // ID that was NOT a digit.
            else {
                IDError.setText("Tame Impala rocks, but you don't. That ID is NOT valid.");
                return 0;
            }

        }
        // If the user gets to this point, it means their input wasn't
        // equal to the length of seven
        else {
            IDError.setText("Help me. They have my family captured. Also your ID isn't valid, try again.");
            return 0;
        }

    } // END of readAndVerifyID()
    
    
    

    public String readAndVerifyName() {
        // This method will read and make sure the user's name input is 'legal',
        // meaning that it adhears to the rules. The rules of a name input claim
        // that an inputted name must have a length of 2 and should contain 
        // ONLY letters, spaces, or dashes

        String userFirstName = firstNameText.getText();
        userFirstName = userFirstName.replace(" ", "");

        // If the user's input is not loner than 2 characters, OR if it's 0
        // characters long, it'll tell the user that they made an invalid 
        // choice, and then let them enter their input again
        if (userFirstName.length() < 2) {
            firstNameError.setText("Too small. Try again or perish.");
            return ("try again");
        }
        // Now we need to make sure the length of the user's input is more
        // than two characters but less than 2-- since that's thats the 
        // minimum and maximum allowed characters
        else if (userFirstName.length() >= 2 && userFirstName.length() <= 20) {
            // NOW we need to make sure the input is a letter, space, or
            // dash
            if (containsOnlyLettersSpacesOrDashes(userFirstName)) {
                // If this passed, that means the input is either a letter,
                // space, or dash
                return userFirstName;

            }
            // If the if doesn't execute, that means that the user entered an
            // ID that was NOT longer than 2 characters.
            else {
                firstNameError.setText("First name needs to contain only letters, spaces, or dashes. You suck.");
                return ("try again");
            }

        }

        // If the user gets to this point, it means their input wasn't
        // longer than two characters or less than 20
        else {
            firstNameError.setText("Try again stupid. First name needs to contain only letters, spaces, or dashes.");
            return ("try again");
        }

    } // END of readAndVerifyName()   
    
    

    public String readAndVerifyLastName() {

        // NOW we are ready for the last name
        // We will do exactly what we did in the first name method, but for
        // The last name. We need to verify the last name and make sure it's
        // 'legal'. 
        String userLastName = lastNameText.getText();
        userLastName = userLastName.replace(" ", "");

        // If the user's input is not loner than 2 characters, OR if it's 0
        // characters long, it'll tell the user that they made an invalid 
        // choice, and then let them enter their input again
        if (userLastName.length() < 2) {
            lastNameError.setText("Wrong length... Try again or sacrifice your firstborn.");
            return ("Try again");
        }
        // Now we need to make sure the length of the user's input is more
        // than two characters but less than 2-- since that's thats the 
        // minimum and maximum allowed characters
        else if (userLastName.length() >= 2 && userLastName.length() <= 20) {
            // NOW we need to make sure the input is a letter, space, or
            // dash
            if (containsOnlyLettersSpacesOrDashes(userLastName)) {
                // If this passed, that means the input is either a letter,
                // space, or dash

                return userLastName;

            }
            // If the if doesn't execute, that means that the user entered an
            // ID that was NOT longer than 2 characters.
            else {
                lastNameError.setText("This sucks. I'm tired of telling you about these errors. Go to your room.");
                return ("Try again");
            }

        }
        // If the user gets to this point, it means their input wasn't
        // longer than two characters or less than 20
        else {
            lastNameError.setText("Just give up.");
            return ("Try again");
        }

    } // END of readAndVerifyLastName()

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Keep this here just in case
    } // end of initialize()

    
    
    // initalize name here
    String name;

    public void firstNameSubmit(ActionEvent event) {
        // Method to read the text after the user selects the submit button
        // for the first name
        try {
            // we try to read and print the name
            name = readAndVerifyName();
            
        } catch (Exception e) {
            // and we catch exception errors
            firstNameError.setText("You suck. Try again.");
        }
        // increment the counter
        counter++;

    } // end of firstNameSubmit()
    
    

    
    // initalize lastName here
    String lastName;

    public void lastNameSubmit(ActionEvent event) {
        // this method will read the text after the user selects the submit
        // button for the last name
        try {
            // we try to read and verify the last name
            lastName = readAndVerifyLastName();
        } // and if it doesn't work, we catch the error
        catch (Exception e) {
            lastNameError.setText("I don't know what you did, but it wasn't valid.");
        }
        
        // increment the counter
        counter++;
        
    }   //End of lastNameSubmit
    
    

    // initalize ID here
    int ID;

    public void IDSubmit(ActionEvent event) {
        // method to read the text after the user selects the submit button for
        // the ID
        try {
            // we try to verify the entered ID...
            ID = readAndVerifyID();
        } // and we catch whatever error occurs
        catch (Exception e) {
            IDError.setText("Michael! Don't leave me here! Also, your ID is invalid.");
        }

        // increment the counter
        counter++;
        
        
    }   //end of IDSubmit
    
    

    
    // Initalize Char here
    int Char;

    public void characterSubmit(ActionEvent event) {
        // this method will read the text after the user selects the submit
        // button for the character submission

        try {
            // we try to verify the character from choices 1-16...
            Char = readAndVerifyCharacter(16);
        } // and we actch any errors
        catch (Exception e) {
            characterError.setText("If you don't get it right, Eve won't get to rewatch Avatar.");
        }

        // increment the counter
        counter++;
        
        
    }   //End of characterSubmit()
    
    
    // initalize bike here
    int bike;

    public void bikeSubmit(ActionEvent event) {
        // this method will read the text after the user selects the submit 
        // button for the bike submission

        try {
            // we try to verify the bike choice from 1-9...
            bike = readAndVerifyBike(9);
        } // and we catch any errors
        catch (Exception e) {
            bikeError.setText("Try again or I'll cry.");
        }
        
        // increment the counter
        counter++;     
        
    } // end of bikeSubmit()
    
 
    
    
    
    public void quit(MouseEvent event){
        // method for the user to quit out of the window
        
        Button button = (Button) event.getSource();
        String buttonText = button.getText();
        // IF the user hits the button with the text 'All Done!'
        if (buttonText.equals("All Done!")){
            // add all of the new character information to our competitors 
            // arrayList initalized in main
            
            // we only want to add the fields to the competitors arrayList
            // IF the user filled out all five forms
            if (counter >= 5){
                MarioKartFX.competitors.add(name + " " + lastName + " " + ID + " " + characters[Char-1] + " " + bikes[bike-1] + " \n");  
            }       
            Stage stage = (Stage) button.getScene().getWindow();
            // and we close the stage to take the user back to the main menu
            stage.close();
        }
    } // end of quit()

} // end of class
