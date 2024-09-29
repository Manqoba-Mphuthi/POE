/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RC_Student_lab
 */
import java.util.Scanner;
public class Login {
    
   //This class will deal with user registration, login, and password complexity checks.
    
    //Stores registered user
    
    private User registeredUser;
    private Scanner scanner;
    
    //Constructor
    public Login() {
        this.scanner = new Scanner(System.in);
    }
    
    //Method that checks if username is formatted properly (contains underscore and no more than 5 characters long)
   
    public boolean checkUserName(String username) {
      return username.contains("_") && username.length() <=5;
    } 
    //Method that checks if password meets complexity requirements ( >=8 characters long, contain capital letter, a number, and a special character)
    
    public boolean checkPasswordComplexity(String password) {
               return password.length() >= 8
                  && password.matches(".[A-Z].")
                  && password.matches(".[0-9].")
                  && password.matches(".[^a-zA-Z0-9].");
    }   
    //Method that registers a user
    
    public String registerUser(String username, String password, String firstName, String lastName) {
    
    //Prompt user to enter details
     
     System.out.print("Please enter username: ");
     username = scanner.nextLine();
     
     System.out.print("Please enter password: ");
     password = scanner.nextLine();
     
     System.out.print("Please enter first name: ");
     firstName = scanner.nextLine();
     
     System.out.print("Please enter last name: ");
     lastName = scanner.nextLine();
     
    //If statements that check if username and password are formatted correctly
    
     if (!checkUserName(username)) {
         return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
     }
     if (!checkPasswordComplexity(password)) {
         return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital, a number and a special character.";
     }
    
     //Create a new user and store it
    
     registeredUser = new User(username, password, firstName, lastName);
        return "User registered successfully.";
    }
    
     //Method to login a user
     public boolean loginUser(String username, String password) {
         return registeredUser != null && registeredUser.getUsername().equals(username)
                 && registeredUser.getPassword().equals(password);
     }
    
}

