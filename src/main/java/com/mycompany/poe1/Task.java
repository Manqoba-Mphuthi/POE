/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe1;
import javax.swing.JOptionPane;
/**
 *
 * @author RC_Student_lab
 */
public class Task {

//Declaration of task-related variables
private String taskName;
private int taskNumber;
private String taskDescription;
private String developerFirstName;
private String developerLastName;
private int taskDuration;
private String taskID;
private String taskStatus;

//Constructor for task variables
public Task(String taskName, int taskNumber, String taskDescription, String developerFirstName, String developerLastName, int taskDuration, String taskID, String taskStatus) {
    this.taskName = taskName;
    this.taskNumber = taskNumber;
    this.taskDescription = taskDescription;
    this.developerFirstName = developerFirstName;
    this.developerLastName = developerLastName;
    this.taskDuration = taskDuration;
    this.taskID = taskID;
    this.taskStatus = taskStatus;
}

//Method to check if the task description length is valid (less than 50 characters)
public boolean checkTaskDescription() {
    return taskDescription.length() <= 50;
}

//Method to generate taskID based on task details (First two letters of task name, task number, last three letters of developer's last name)
public String creatyeTaskID() {
    String taskInitials = 
            taskName.length() >= 2 ?
            taskName.substring(0,2).toUpperCase():
            taskName.toUpperCase();
    String developerEnd = 
            developerLastName.length() >= 3 ?
            developerLastName.substring(developerLastName.length() - 3).toUpperCase() :
            developerLastName.toUpperCase();
                          return taskInitials + ":" + taskNumber + ":" + developerEnd;            
}

//Method to print task details in the required format
public String printTaskDetails() {
    return "Task Status: " + taskStatus + "\n" + 
           "Developer: " + developerFirstName + " " + developerLastName + "\n" +         
           "Task Number: " + taskNumber + "\n" + 
           "Task Name: " + taskName + "\n" +
           "Task Description: " + taskDescription + "\n" +
           "Task ID: " + taskID + "\n" +
           "Task Duration: " + taskDuration + "hours";
}

//Method to return the total hours for the week
public int returnTaskHours() {
    return taskDuration;
}
}
