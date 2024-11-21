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
    private ArrayList<Task> tasks = new ArrayList<>();  // List to store tasks

    // Method to add tasks to the list
    public void addTasks() {
        int numOfTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks would you like to add?"));

        for (int i = 0; i < numOfTasks; i++) {
            String taskName = JOptionPane.showInputDialog("Enter task name:");
            String taskDescription = JOptionPane.showInputDialog("Enter task description (max 50 characters):");

            if (taskDescription.length() > 50) {  // Ensure task description is within limit
                JOptionPane.showMessageDialog(null, "Task description must be less than 50 characters.");
                i--; // Retry current task entry
                continue;
            }

            String developerFirstName = JOptionPane.showInputDialog("Enter developer first name:");
            String developerLastName = JOptionPane.showInputDialog("Enter developer last name:");
            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration (in hours):"));

            String[] statusOptions = {"To Do", "Doing", "Done"};
            int statusChoice = JOptionPane.showOptionDialog(null, "Select task status:", "Task Status",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, statusOptions, statusOptions[0]);

            Task newTask = new Task(taskName, tasks.size(), taskDescription, developerFirstName, developerLastName, taskDuration);
            newTask.setTaskStatus(statusOptions[statusChoice]);  // Set task status

            tasks.add(newTask);  // Add the new task to the list
            JOptionPane.showMessageDialog(null, "Task successfully added!");
        }
    }

    // Method to display all tasks
    public void showAllTasks() {
        if (tasks.isEmpty()) {  // Check if no tasks are available
            JOptionPane.showMessageDialog(null, "No tasks to display.");
            return;
        }

        String allTasks = "All Tasks:\n";

        for (Task task : tasks) {  // Loop through tasks and build the output string
            allTasks += "Task ID: " + task.getTaskID() + "\n" +
                        "Task Name: " + task.getTaskName() + "\n" +
                        "Developer: " + task.getDeveloperFirstName() + " " + task.getDeveloperLastName() + "\n" +
                        "Duration: " + task.getTaskDuration() + " hours\n" +
                        "Status: " + task.getTaskStatus() + "\n" +
                        "--------------------------\n";
        }

        JOptionPane.showMessageDialog(null, allTasks);  // Display all tasks
    }

    // Method to display a report of all tasks
    public void displayTaskReport() {
        if (tasks.isEmpty()) {  // Check if no tasks are available
            JOptionPane.showMessageDialog(null, "No tasks available.");
            return;
        }

        String taskReport = "Task Report:\n";

        for (Task task : tasks) {  // Loop through tasks and build the report string
            taskReport += "Task ID: " + task.getTaskID() + "\n" +
                          "Task Name: " + task.getTaskName() + "\n" +
                          "Developer: " + task.getDeveloperFirstName() + " " + task.getDeveloperLastName() + "\n" +
                          "Duration: " + task.getTaskDuration() + " hours\n" +
                          "Status: " + task.getTaskStatus() + "\n" +
                          "--------------------------\n";
        }

        JOptionPane.showMessageDialog(null, taskReport);  // Display the task report
    }

    // Method to show tasks with status "Done"
    public void showTasksWithStatusDone() {
        String tasksDone = "Tasks with 'Done' status:\n";
        boolean found = false;

        for (Task task : tasks) {
            if (task.getTaskStatus().equals("Done")) {
                tasksDone += "Task Name: " + task.getTaskName() + "\n" +
                             "Developer: " + task.getDeveloperFirstName() + " " + task.getDeveloperLastName() + "\n" +
                             "Duration: " + task.getTaskDuration() + " hours\n" +
                             "--------------------------\n";
                found = true;
            }
        }

        if (found) {
            JOptionPane.showMessageDialog(null, tasksDone);
        } else {
            JOptionPane.showMessageDialog(null, "No tasks with 'Done' status found.");
        }
    }

    // Method to display task with the longest duration
    public void showTaskWithLongestDuration() {
        if (tasks.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tasks available.");
            return;
        }

        Task longestTask = tasks.get(0);

        for (Task task : tasks) {
            if (task.getTaskDuration() > longestTask.getTaskDuration()) {
                longestTask = task;
            }
        }

        JOptionPane.showMessageDialog(null, "Task with the longest duration:\n" +
                "Task Name: " + longestTask.getTaskName() + "\n" +
                "Developer: " + longestTask.getDeveloperFirstName() + " " + longestTask.getDeveloperLastName() + "\n" +
                "Duration: " + longestTask.getTaskDuration() + " hours");
    }

    // Method to search for a task by name
    public void searchTaskByName() {
        String taskNameToSearch = JOptionPane.showInputDialog("Enter task name to search for:");

        boolean found = false;
        for (Task task : tasks) {
            if (task.getTaskName().equalsIgnoreCase(taskNameToSearch)) {
                JOptionPane.showMessageDialog(null, "Task found:\n" +
                        "Task Name: " + task.getTaskName() + "\n" +
                        "Developer: " + task.getDeveloperFirstName() + " " + task.getDeveloperLastName() + "\n" +
                        "Status: " + task.getTaskStatus());
                found = true;
                break;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(null, "Task not found.");
        }
    }

    // Method to search for tasks by developer
    public void searchTasksByDeveloper() {
        String developerName = JOptionPane.showInputDialog("Enter developer name to search for:");

        boolean found = false;
        for (Task task : tasks) {
            if (task.getDeveloperFirstName().equalsIgnoreCase(developerName) ||
                task.getDeveloperLastName().equalsIgnoreCase(developerName)) {
                JOptionPane.showMessageDialog(null, "Task assigned to " + developerName + ":\n" +
                        "Task Name: " + task.getTaskName() + "\n" +
                        "Status: " + task.getTaskStatus());
                found = true;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(null, "No tasks found for the developer.");
        }
    }

    // Method to delete a task by name
    public void deleteTaskByName() {
        String taskNameToDelete = JOptionPane.showInputDialog("Enter task name to delete:");

        boolean found = false;
        for (Task task : tasks) {
            if (task.getTaskName().equalsIgnoreCase(taskNameToDelete)) {
                tasks.remove(task);
                JOptionPane.showMessageDialog(null, "Task deleted successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(null, "Task not found.");
        }

        displayTaskReport();  // Show remaining tasks
    }

        // Method to display the menu options
    public void showMenu() {
        boolean quit = false;

        while (!quit) {  // Loop until user selects "Quit"
            String[] options = {"Add tasks", "Show all tasks", "Show report", "Show tasks with 'Done' status",
                                "Show task with longest duration", "Search task by name", "Search tasks by developer",
                                "Delete task by name", "Quit"};
            int choice = JOptionPane.showOptionDialog(null, "Please select an option: ", "Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    addTasks();  // Add tasks option
                    break;
                case 1:
                    showAllTasks();  // Show all tasks option
                    break;
                case 2:
                    displayTaskReport();  // Show task report option
                    break;
                case 3:
                    showTasksWithStatusDone();  // Show tasks with 'Done' status
                    break;
                case 4:
                    showTaskWithLongestDuration();  // Show task with longest duration
                    break;
                case 5:
                    searchTaskByName();  // Search task by name
                    break;
                case 6:
                    searchTasksByDeveloper();  // Search tasks by developer
                    break;
                case 7:
                    deleteTaskByName();  // Delete task by name
                    break;
                case 8:
                    quit = true;  // Quit the menu
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please select again.");
            }
        }
    }
}



    



