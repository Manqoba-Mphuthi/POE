/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe1;

/**
 *
 * @author RC_Student_lab
 */
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class TaskManager {
    private ArrayList<String> developerNames = new ArrayList<>();
    private ArrayList<String> taskNames = new ArrayList<>();
    private ArrayList<String> taskIDs = new ArrayList<>();
    private ArrayList<Integer> taskDurations = new ArrayList<>();
    private ArrayList<String> taskStatuses = new ArrayList<>();
    private int taskCounter = 0;

    // Add tasks method
    public void addTasks() {
        String developerName = JOptionPane.showInputDialog("Enter Developer Name:");
        String taskName = JOptionPane.showInputDialog("Enter Task Name:");
        String taskID = "TASK_" + taskCounter++;
        int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration (in hours):"));
        String taskStatus = JOptionPane.showInputDialog("Enter Task Status (e.g., 'To Do', 'Doing', 'Done'):");

        developerNames.add(developerName);
        taskNames.add(taskName);
        taskIDs.add(taskID);
        taskDurations.add(taskDuration);
        taskStatuses.add(taskStatus);

        JOptionPane.showMessageDialog(null, "Task added successfully: \nTask ID: " + taskID);
    }

   
}
