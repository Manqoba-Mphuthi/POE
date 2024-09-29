package com.mycompany.poe1;

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
    private final Scanner scanner;
    
    //Constructor
    public Login() {
        this.scanner = new Scanner(System.in);
    }
    
    //Method that checks if username is formatted properly (contains underscore and no more than 5 characters long)
   
    public boolean checkUserName(String username) {
      return username.contains("_") && username.length() <=5;
    } 
    //Method that checks if password meets complexity requirements ( >=8 characters long, contain capital letter, a number, and a special character)
    
    public boolean isValidPassword(String password) {
        boolean hasUpperCase = password.matches(".[A-Z].");
        boolean hasDigit = password.matches(".[0-9].");
        boolean hasSpecialChar = password.matches(".[^a-zA-Z0-9].");
        boolean hasMinLength = password.length() >=8;
        
        return hasUpperCase && hasDigit && hasSpecialChar && hasMinLength;
    } 
    //Method that registers a user
    
    public String registerUser() {
    
    //Prompt user to enter details
        
     System.out.print("Please enter first name: ");
     String firstName = scanner.nextLine();
     
     System.out.print("Please enter last name: ");
     String lastName = scanner.nextLine();
     
     System.out.print("Please enter username: ");
     String username = scanner.nextLine();
     
     System.out.print("Please enter password: ");
     String password = scanner.nextLine();
    
    //If statements that check if username and password are formatted correctly
    
     if (!checkUserName(username)) {
         return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
     } else {
         System.out.println("Username successfully captured");
     }
     if (isValidPassword(password)) {
         return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital, a number and a special character.";
     } else {
         System.out.println("Password successfully captured");
     }
    
     //Create a new user and store it
    
     registeredUser = new User(username, password, firstName, lastName);
        return "Username successfully captured\nPassword successfully captured\nUser registered successfully.";
    }
    
     //Method to login a user
     
    public boolean loginUser(String username, String password) {
         return registeredUser != null && registeredUser.getUsername().equals(username)
                 && registeredUser.getPassword().equals(password);
     }
     
     //Method to return login status
    
    public String returnLoginStatus(String username, String password) {
        if (loginUser(username, password)) {
            return "Welcome " +
         registeredUser.getFirstName() + " " +
         registeredUser.getLastName() + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again";
        }
    }
    
     //Method to run the login
     
     public void run() {
       boolean isRegistered = false;
       
       while (!isRegistered) {
           System.out.println("Please register: ");
           String registrationStatus = registerUser();
           
           if (registrationStatus.contains("User registered successfully")) {
               
           System.out.println(registrationStatus);
           isRegistered = true;
           } else {
               
           System.out.println(registrationStatus);
           System.out.println("Registration failed. Please try again.");
           }
       } 
          
           System.out.println("Please Login");
              
              System.out.print("Enter username: ");
              String username = scanner.nextLine();
              System.out.print("Enter password: ");
              String password = scanner.nextLine();
              System.out.println(returnLoginStatus(username, password));
        }    
}