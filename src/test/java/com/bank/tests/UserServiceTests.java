package com.bank.tests;


import com.bank.CommonUser.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class UserServiceTests {

    /* Unit tests for Login - happy path, incorrect credentials, null credentials
    happy path- both username and password are correct
    null credentials- both username and password are null
    incorrect credentials- either or both (username or password) is wrong
     */
    private UserService userService;


    @BeforeEach
    public void intEachTest()  {

        System.out.println("Initializing before test");
        userService = new UserServiceImpl();
    }

    /* Test that the method will throw Illegal State Exception
   if either or both the inputs are NULL
   */
    @Test

    public void shouldThrowIllegalStateException() {
        /*Assertions allow testing the correctness of any assumptions in the program;while executing assertions it is assumed
        to be true , if it fails JVM throws assertion error
        */
        //userService = new UserServiceImpl();
        IllegalStateException ex = Assertions.assertThrows(IllegalStateException.class, () -> {
            //Expecting method to throw Exception, else test fails

            userService.authenticate(null, null);

        });
        Assertions.assertEquals("Username or password cannot be null", ex.getMessage(), "Can't throw null values");

        ex = Assertions.assertThrows(IllegalStateException.class, () -> {

            userService.authenticate("user1", null);
        });
        Assertions.assertEquals("Username or password cannot be null", ex.getMessage(), "Can't throw null password");

        ex = Assertions.assertThrows(IllegalStateException.class, () -> {

            userService.authenticate(null, "user1pass");
        });
        Assertions.assertEquals("Username or password cannot be null", ex.getMessage(), "Can't throw null username");


    }



    @Test
    public void shouldReturnWithCorrectCredentials(){

        String username = "user1";
        String password = "user1pass";

        User user = userService.authenticate(username, password);// both username and password are correct

        Assertions.assertNotNull(user);
        Assertions.assertEquals(password, user.getPassword(), "User password doesn't match");
        Assertions.assertEquals(username, user.getUsername(), "Username doesn't match");
        }


    @Test
    public void shouldThrowUserNotFoundWithIncorrectCredentials() {

        String username1="user1";
        String password1="user1pas$";
        String username2="usr1";
        String password2="user1pass";
        String username3="usr1";
        String password3="user1pas$";


            // correct username, wrong password
            UserNotFoundException uex = Assertions.assertThrows(UserNotFoundException.class, () -> userService.authenticate(username1, password1));

            Assertions.assertEquals("Incorrect Username or Password", uex.getMessage(), "Return user with incorrect password");

            /* wrong username, correct password */
            uex = Assertions.assertThrows(UserNotFoundException.class, () -> userService.authenticate(username2, password2));
            Assertions.assertEquals("Incorrect Username or Password", uex.getMessage(), "Return user with incorrect username");

            /*wrong username, wrong password*/
            uex = Assertions.assertThrows(UserNotFoundException.class, () -> userService.authenticate(username3, password3));
            Assertions.assertEquals("Incorrect Username or Password", uex.getMessage(), "Return user with incorrect username and password");


        }

    }




