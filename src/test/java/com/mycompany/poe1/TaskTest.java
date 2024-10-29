/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poe1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    
    //Test description length validation for success
    @Test
    void testTaskDescriptionLengthValidation_Success() {
        // Test with valid description length (≤ 50 characters)
        Task task = new Task("Login Feature", 1, "Create login to authenticate users", "Robyn", "Harrison", 8);
        assertTrue(task.checkTaskDescription(), "Expected task description to be valid (≤ 50 characters)");
    }
    
    //Test description length for failure
    @Test
    void testTaskDescriptionLengthValidation_Failure() {
        // Test with invalid description length (> 50 characters)
        Task task = new Task("Add Task Feature", 2, "This description is intentionally too long to trigger validation failure.", "Mike", "Smith", 10);
        assertFalse(task.checkTaskDescription(), "Expected task description to be invalid (> 50 characters)");
    }

//Test taskID generation
@Test
void testTaskIDGeneration() {
    // Test Case 1 data: Expected ID "AD:1:BYN"
    Task task1 = new Task("Add Feature", 1, "Create add feature", "Andy", "Bynes", 8);
    // This expected ID should match the logic in createTaskID
    assertEquals("AD:1:NES", task1.getTaskID(), "Task ID should be AD:1:NES");

    // Additional Task IDs to test
    Task task2 = new Task("Create Report", 0, "Create report feature", "Ike", "Arden", 10);
    Task task3 = new Task("Create Dashboard", 1, "Create dashboard feature", "Ricardo", "Tanner", 15);
    Task task4 = new Task("Create Analysis", 2, "Create analysis feature", "Lisa", "Tan", 20);
    Task task5 = new Task("Create Notification", 3, "Create notification feature", "Benny", "And", 12);

    // Ensure expected IDs are correct according to your naming convention in createTaskID()
    assertEquals("CR:0:DEN", task2.getTaskID(), "Task ID should be CR:0:DEN");
    assertEquals("CR:1:NER", task3.getTaskID(), "Task ID should be CR:1:NER"); // Ensure expected value is correct
    assertEquals("CR:2:TAN", task4.getTaskID(), "Task ID should be CR:2:TAN"); // Ensure expected value is correct
    assertEquals("CR:3:AND", task5.getTaskID(), "Task ID should be CR:3:AND");
}


    //Test for correct total hours accumulation
@Test
void testTotalHoursAccumulation() {
    // Test with Task 1 and Task 2, expecting total of 18 hours
    Task task1 = new Task("Login Feature", 0, "Create login to authenticate users", "Robyn", "Harrison", 8);
    Task task2 = new Task("Add Task Feature", 1, "Create add task feature", "Mike", "Smith", 10);
    int totalHours1 = task1.returnTaskHours() + task2.returnTaskHours();
    assertEquals(18, totalHours1, "Expected total hours to be 18 for Task 1 and Task 2");

    // Additional data with 5 tasks, expecting total of 89 hours
    Task task3 = new Task("Feature A", 2, "Description A", "DevA", "LastA", 10);
    Task task4 = new Task("Feature B", 3, "Description B", "DevB", "LastB", 12);
    Task task5 = new Task("Feature C", 4, "Description C", "DevC", "LastC", 55);
    Task task6 = new Task("Feature D", 5, "Description D", "DevD", "LastD", 11);
    Task task7 = new Task("Feature E", 6, "Description E", "DevE", "LastE", 1);
    
    int totalHours2 = task3.returnTaskHours() + task4.returnTaskHours() + task5.returnTaskHours() + task6.returnTaskHours() + task7.returnTaskHours();
    assertEquals(89, totalHours2, "Expected total hours to be 89 for additional tasks");
}

}
