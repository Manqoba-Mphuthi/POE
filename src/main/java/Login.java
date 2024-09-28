/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RC_Student_lab
 */
public class Login {
   //This class will deal with user registration, login, and password complexity checks.
    
    //Stores registered user
    
    private User registeredUser;
    
    //Method that checks if username is formatted properly (contains underscore and no more than 5 characters long)
   
    public boolean checkUserName(String username) {
      return username.contains("_") && username.length() <=5;
    } 
    //Method that checks if password meets complexity requirements ( >=8 characters long, contain capital letter, a number, and a special character)
    
    public boolean checkPasswordComplexity(String password) {
        //check if password meets complexity requirements
        return password.length() >= 8
                  && password.matches(".[A-Z].")
                  && password.matches(".[0-9].")
                  && password.matches(".[^a-zA-Z0-9].");
    }
}

