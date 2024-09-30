/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poe1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class LoginTest {
    
    public LoginTest() {
    }
    


    /**
     * Test of checkUserName method, of class Login.
     */
    @Test
    public void testCheckUserName() {
        System.out.println("checkUserName");
        String username = "kyl_1";
        Login instance = new Login();
        boolean expResult = true;
        boolean result = instance.checkUserName(username);
        assertEquals(expResult, result);

    }

    /**
     * Test of isValidPassword method, of class Login.
     */
    @Test
    public void testIsValidPassword() {
        System.out.println("isValidPassword");
        String password = "Ch&&sec@ke99!";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.isValidPassword(password);
        assertEquals(expResult, result);

    }

    /**
     * Test of registerUser method, of class Login.
     */
    @Test
    public void testRegisterUserSuccess() {       
        System.out.println("registerUser");
        Login instance = new Login();
        String firstName = "John";
        String lastName = "Doe";
        String username = "kyl_1";
        String password = "Ch&&sec@ke99!";
        String expResult = "Username successfully captured\nPassword successfully captured\nUser registered successfully.";
        String result = instance.registerUser();
        assertEquals(expResult, result);

    }

    /**
     * Test of loginUser method, of class Login.
     */
    @Test
    public void testLoginUser() {
        System.out.println("loginUser");
        String username = "kyle!!!!!!!";
        String password = "Ch&&sec@ke99!";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.loginUser(username, password);
        assertEquals(expResult, result);

    }

    /**
     * Test of returnLoginStatus method, of class Login.
     */
    @Test
    public void testReturnLoginStatus() {
        System.out.println("returnLoginStatus");
        String username = "kyl_1";
        String password = "password";
        Login instance = new Login();
        String expResult = "Username or password incorrect, please try again";
        String result = instance.returnLoginStatus(username, password);
        assertEquals(expResult, result);

    }

    /**
     * Test of run method, of class Login.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        Login instance = new Login();
        instance.run();
        
    }
    
}
