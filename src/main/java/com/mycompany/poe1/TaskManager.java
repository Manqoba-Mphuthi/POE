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
    // Method to find and display the task with the longest duration
    public void displayLongestTask() {
        if (taskDurations.isEmpty()) {
            // If no tasks exist, inform the user
            JOptionPane.showMessageDialog(null, "No tasks available to evaluate.");
            return;
        }

        // Initialize variables to track the longest task
        int longestDuration = 0;
        int longestTaskIndex = 0;

        // Loop through task durations to find the longest one
        for (int i = 0; i < taskDurations.size(); i++) {
            if (taskDurations.get(i) > longestDuration) {
                longestDuration = taskDurations.get(i);
                longestTaskIndex = i;
            }
        }

        // Display the task with the longest duration
        String result = "Task with the Longest Duration:\n" +
                        "Developer: " + developerNames.get(longestTaskIndex) + "\n" +
                        "Task Name: " + taskNames.get(longestTaskIndex) + "\n" +
                        "Duration: " + longestDuration + " hours";
        JOptionPane.showMessageDialog(null, result);
    }

        // Method to search for a task by its name
    public void searchTaskByName() {
        // Ask the user for the task name to search
        String taskNameToSearch = JOptionPane.showInputDialog("Enter the Task Name to search:");

        // Loop through the taskNames array to find a match
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equalsIgnoreCase(taskNameToSearch)) {
                // Display task details if a match is found
                String result = "Task Found:\n" +
                                "Task Name: " + taskNames.get(i) + "\n" +
                                "Developer: " + developerNames.get(i) + "\n" +
                                "Status: " + taskStatuses.get(i);
                JOptionPane.showMessageDialog(null, result);
                return; // Exit after finding the first match
            }
        }

        // Inform the user if no match is found
        JOptionPane.showMessageDialog(null, "Task not found.");
    }
        // Method to search for all tasks assigned to a specific developer
    public void searchTasksByDeveloper() {
        // Prompt the user to enter a developer name
        String developerToSearch = JOptionPane.showInputDialog("Enter the Developer's Name to search:");

        // Create a StringBuilder to compile results
        StringBuilder result = new StringBuilder("Tasks assigned to " + developerToSearch + ":\n");

        boolean tasksFound = false; // Flag to track if any tasks are found

        // Loop through developerNames array to find matches
        for (int i = 0; i < developerNames.size(); i++) {
            if (developerNames.get(i).equalsIgnoreCase(developerToSearch)) {
                // Append task details to the result
                result.append("Task Name: ").append(taskNames.get(i))
                      .append(", Status: ").append(taskStatuses.get(i)).append("\n");
                tasksFound = true;
            }
        }

        // Display results if tasks are found or inform the user otherwise
        if (tasksFound) {
            JOptionPane.showMessageDialog(null, result.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No tasks found for developer " + developerToSearch);
        }
    }
    // Method to delete a task using its name
    public void deleteTaskByName() {
        // Ask the user for the task name to delete
        String taskNameToDelete = JOptionPane.showInputDialog("Enter the Task Name to delete:");

        // Loop through the taskNames array to find a match
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equalsIgnoreCase(taskNameToDelete)) {
                // Remove task details from all arrays
                developerNames.remove(i);
                taskNames.remove(i);
                taskIDs.remove(i);
                taskDurations.remove(i);
                taskStatuses.remove(i);

                // Confirm task deletion
                JOptionPane.showMessageDialog(null, "Task '" + taskNameToDelete + "' deleted successfully.");
                return; // Exit after deleting the task
            }
        }

        // Inform the user if no match is found
        JOptionPane.showMessageDialog(null, "Task not found.");
    }
    // Method to display a report of all tasks
    public void displayTaskReport() {
        if (taskNames.isEmpty()) {
            // If no tasks exist, inform the user
            JOptionPane.showMessageDialog(null, "No tasks available.");
            return;
        }

        // Create a StringBuilder to compile the report
        StringBuilder report = new StringBuilder("Task Report:\n");

        // Loop through all tasks and append their details to the report
        for (int i = 0; i < taskNames.size(); i++) {
            report.append("Task ID: ").append(taskIDs.get(i))
                  .append("\nTask Name: ").append(taskNames.get(i))
                  .append("\nDeveloper: ").append(developerNames.get(i))
                  .append("\nDuration: ").append(taskDurations.get(i)).append(" hours")
                  .append("\nStatus: ").append(taskStatuses.get(i))
                  .append("\n--------------------------\n");
        }

        // Display the full report to the user
        JOptionPane.showMessageDialog(null, report.toString());
    }
}

    
    



