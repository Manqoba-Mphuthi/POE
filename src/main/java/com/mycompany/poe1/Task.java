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
}
