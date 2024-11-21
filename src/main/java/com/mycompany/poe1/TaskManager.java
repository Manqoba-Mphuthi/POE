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

       // Method to display all tasks with status "Done"
    public void displayTasksDone() {
        // Create a StringBuilder to compile results
        StringBuilder result = new StringBuilder("Tasks with status 'Done':\n");

        // Iterate through the taskStatuses array
        for (int i = 0; i < taskStatuses.size(); i++) {
            // Check if the task status is "Done"
            if (taskStatuses.get(i).equalsIgnoreCase("Done")) {
                // Append task details to the result
                result.append("Developer: ").append(developerNames.get(i))
                      .append(", Task Name: ").append(taskNames.get(i))
                      .append(", Duration: ").append(taskDurations.get(i)).append(" hours\n");
            }
        }

        // Display the result to the user
        JOptionPane.showMessageDialog(null, result.toString());
    }

}
