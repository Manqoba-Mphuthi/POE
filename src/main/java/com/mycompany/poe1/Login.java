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
    
   //This class will deal with user registration, login, and password complexity checks.
    
    //Stores registered user
    private User registeredUser;
  
    
    //Stores tasks
    private ArrayList<Task> tasks = new ArrayList<>();
    private int taskCounter = 0;
    
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
        boolean hasUpperCase = password.matches(".*[A-Z]*.");
        boolean hasDigit = password.matches(".*[0-9]*.");
        boolean hasSpecialChar = password.matches(".*[^a-zA-Z0-9]*.");
        boolean hasMinLength = password.length() >=8;
        
        return hasUpperCase && hasDigit && hasSpecialChar && hasMinLength;
    } 
    //Method that registers a user
    
    public  String registerUser() {
    
    //Prompt user to enter details
     
    String firstName =
    JOptionPane.showInputDialog("Please enter first name: ");
    String lastName =
    JOptionPane.showInputDialog("Please enter last name: ");
    String username =
    JOptionPane.showInputDialog("Please enter username: ");
    String password =
    JOptionPane.showInputDialog("Please enter password: ");
    
    //check if username is formatted correctly
    
     if (!checkUserName(username)) {
         return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
     } else {
         System.out.println("Username successfully captured");
     }
     
     //check if password is formatted correctly
     if (!isValidPassword(password)) {
         return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital, a number and a special character.";
     } else {
         System.out.println("Password successfully captured");
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
    
        //Method to add tasks
        public void addTasks() {
        JOptionPane.showMessageDialog(null,"Welcome to EasyKanban");
        
        //Asking user how many tasks they want to add
        int numOfTasks =
                Integer.parseInt(JOptionPane.showInputDialog("How many tasks would you like to add?"));
        for (int i = 0; i < numOfTasks; i++) {
           
        //collect task details
            
         String taskName =
                 JOptionPane.showInputDialog("Enter task name: ");
         String taskDescription =
                 JOptionPane.showInputDialog("Enter task description (max 50 characters):");
         
         //Validate task description length
         if (taskDescription.length() > 50)
         {
            
           JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
           i--; //Repeat if decription is invalid
           continue;
         }
         
         //Gather additional task details
         String developerFirstName =
                 JOptionPane.showInputDialog("Enter developer first name: ");
         String developerLastName =
                 JOptionPane.showInputDialog("Enter developer last name: ");
         int taskDuration =
                 Integer.parseInt(JOptionPane.showInputDialog("Enter task duration (in hours): "));
           
          //Create and add new task
            
            Task newTask = new Task(taskName, taskCounter++, taskDescription, developerFirstName, developerLastName, taskDuration);

            
            //Set task status
            
             String[]
                     statusOptions = {"To Do", "Doing", "Done"};
             int statusChoice =
                     JOptionPane.showOptionDialog(null, "Select task status: ", "Task Status",
                       
                             JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, statusOptions, statusOptions[0]);
                             
            //Set task status based on user selection
            newTask.setTaskStatus(statusOptions[statusChoice]);
            
            //Add task to task list and confirm to the user
            tasks.add(newTask);
            
            JOptionPane.showMessageDialog(null, "Task successfully captured");
        }
        
        
             //Show total hours across all tasks
                int totalHours = tasks.stream().mapToInt(Task::returnTaskHours).sum();
                
               JOptionPane.showMessageDialog(null, "Total hours of all tasks: " + totalHours);
                
             //Display each task's details using JOptionPane
              for (Task task : tasks)  {
                  javax.swing.JOptionPane.showMessageDialog(null, task.printTaskDetails());
              }
    }       //Method to display the main menu afer successful login
             public void showMenu() {
                  boolean quit = false;
                  
            //Loop until user selects the quit option
            while (!quit) {
                //Display menu options using JOption
                String[] options =
                {"Add tasks", "Show report", "Quit"};
                int choice = 
              JOptionPane.showOptionDialog(null, "Please select an option: ", "Menu",
                      
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                
                //Handle user's menu selection
                switch (choice) {
                    case 0:
                    
                   addTasks(); //Add tasks option
                   break;
                    case 1:
                        
                        JOptionPane.showMessageDialog(null, "Coming Soon");
                        break;
                    case 2:
                        quit = true;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid option. Plaease select again.");
                }
                      
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
            //Login process
           System.out.println("Please Login");
              
              System.out.print("Enter username: ");
              String username = scanner.nextLine();
              System.out.print("Enter password: ");
              String password = scanner.nextLine();
            
             //display Login status
              System.out.println(returnLoginStatus(username, password));
        }    


    }
