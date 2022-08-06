package com.bank.tests;

import com.bank.CommonUser.*;
import com.bank.BankEmployee.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmpServiceTests {


        /* Unit tests for Employee Login - happy path, incorrect credentials, null credentials
        happy path- both username and password are correct
        null credentials- both username and password are null
        incorrect credentials- either or both (username or password) is wrong
         */
        public EmployeeService employeeService;


        @BeforeEach
        public void intEachTest() {

            System.out.println("Initializing before test");
            employeeService = new EmpServiceImpl();
        }

        /* Test that the method will throw Illegal State Exception
       if either or both the inputs are NULL
       */
        @Test

        public void shouldThrowIllegalStateException() {
        /*Assertions allow testing the correctness of any assumptions in the program;while executing assertions it is assumed
        to be true , if it fails JVM throws assertion error
        */

            IllegalStateException ex = Assertions.assertThrows(IllegalStateException.class, () -> {
                //Expecting method to throw Exception, else test fails

                employeeService.authenticate(null, null);

            });
            Assertions.assertEquals("Username or password cannot be null", ex.getMessage(), "Can't throw null values");

            ex = Assertions.assertThrows(IllegalStateException.class, () -> {

                employeeService.authenticate("user2", null);
            });
            Assertions.assertEquals("Username or password cannot be null", ex.getMessage(), "Can't throw null password");

            ex = Assertions.assertThrows(IllegalStateException.class, () -> {

                employeeService.authenticate(null, "user2pass");
            });
            Assertions.assertEquals("Username or password cannot be null", ex.getMessage(), "Can't throw null username");


        }



        @Test
        public void shouldReturnWithCorrectCredentials(){

            String username = "user2";
            String password = "user2pass";

           Employee employee= employeeService.authenticate(username, password);// both username and password are correct

            Assertions.assertNotNull(employee);
            Assertions.assertEquals(password, employee.getEmpPassword(), "User password doesn't match");
            Assertions.assertEquals(username, employee.getEmpUsername(), "Username doesn't match");
        }//


        @Test
        public void shouldThrowUserNotFoundWithIncorrectCredentials() {

            String username1="user2";
            String password1="user2pas$";
            String username2="usr2";
            String password2="user2pass";
            String username3="usr2";
            String password3="user2pas$";


            // correct username, wrong password
            UserNotFoundException uex = Assertions.assertThrows(UserNotFoundException.class, () -> employeeService.authenticate(username1, password1));

            Assertions.assertEquals("Incorrect Username or Password", uex.getMessage(), "Return user with incorrect password");

            /* wrong username, correct password */
            uex = Assertions.assertThrows(UserNotFoundException.class, () -> employeeService.authenticate(username2, password2));
            Assertions.assertEquals("Incorrect Username or Password", uex.getMessage(), "Return user with incorrect username");

            /*wrong username, wrong password*/
            uex = Assertions.assertThrows(UserNotFoundException.class, () -> employeeService.authenticate(username3, password3));
            Assertions.assertEquals("Incorrect Username or Password", uex.getMessage(), "Return user with incorrect username and password");


        }

    }






