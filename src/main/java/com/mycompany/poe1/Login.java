package com.mycompany.poe1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RC_Student_lab
 */
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Login {
    // Stores registered user
    private User registeredUser;

    // Stores tasks
    private TaskManager taskManager;
    private ArrayList<Task> tasks = new ArrayList<>();
    private int taskCounter = 0;

    // Method that checks if username is formatted properly (contains underscore and no more than 5 characters long)
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Method that checks if password meets complexity requirements
    public boolean isValidPassword(String password) {
        boolean hasUpperCase = password.matches(".*[A-Z].*");
        boolean hasDigit = password.matches(".*[0-9].*");
        boolean hasSpecialChar = password.matches(".*[^a-zA-Z0-9].*");
        boolean hasMinLength = password.length() >= 8;

        return hasUpperCase && hasDigit && hasSpecialChar && hasMinLength;
    }

    // Method that registers a user
    public String registerUser() {
        // Prompt user to enter details
        String firstName = JOptionPane.showInputDialog("Please enter first name: ");
        String lastName = JOptionPane.showInputDialog("Please enter last name: ");
        String username = JOptionPane.showInputDialog("Please enter username: ");
        String password = JOptionPane.showInputDialog("Please enter password: ");

        // Check if username is formatted correctly
        if (!checkUserName(username)) {
            return "Username is not correctly formatted. Please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }

        // Check if password is formatted correctly
        if (!isValidPassword(password)) {
            return "Password is not correctly formatted. Please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.";
        }

        // Create a new user and store it
        registeredUser = new User(username, password, firstName, lastName);
        return "User registered successfully.";
    }

    // Method to login a user
    public boolean loginUser(String username, String password) {
        return registeredUser != null && registeredUser.getUsername().equals(username) && registeredUser.getPassword().equals(password);
    }

    // Method to return login status
    public String returnLoginStatus(String username, String password) {
        if (loginUser(username, password)) {
            return "Welcome " + registeredUser.getFirstName() + " " + registeredUser.getLastName() + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }


    // Method to start the registration and login process
   public void run() {
       taskManager = new TaskManager();
    boolean isRegistered = false;

    // Registration loop
    while (!isRegistered) {
        JOptionPane.showMessageDialog(null, "Please register: ");
        String registrationStatus = registerUser();

        // Check if registration is successful
        if (registrationStatus.contains("User registered successfully")) {
            JOptionPane.showMessageDialog(null, registrationStatus);
            isRegistered = true;
        } else {
            JOptionPane.showMessageDialog(null, registrationStatus);
        }
    }

    boolean isLoggedIn = false;
    // Login loop
    while (!isLoggedIn) {
        JOptionPane.showMessageDialog(null, "Please Login");
        String username = JOptionPane.showInputDialog("Enter username:");
        String password = JOptionPane.showInputDialog("Enter password:");

        // Display login status and check if login is successful
        String loginStatus = returnLoginStatus(username, password);
        JOptionPane.showMessageDialog(null, loginStatus);

        if (loginUser(username, password)) {
            isLoggedIn = true;

            // Create an instance of TaskManager and show the menu
            TaskManager taskManager = new TaskManager();
            taskManager.showMenu(); // Show the menu after successful login
        }
    }
}

}
