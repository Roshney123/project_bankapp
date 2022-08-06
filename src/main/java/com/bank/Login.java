package com.bank;

import com.bank.BankEmployee.Employee;
import com.bank.CommonUser.User;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * To login using username and password , Deny login for incorrect credentials
 */
public class Login {

    public void doLogin(Scanner scanner) {
        User u = new User(1,"user1@gmail.com","user1","user1pass",15);
        Employee e= new Employee(11,"user2@gmail.com","user2","user2pass","Employee");
        int i=0;
        do {
            System.out.println("Please Login");
            System.out.println("Enter Username");
            String usernameInput = scanner.nextLine();

            /*usernameInput,passwordInput didn't initialize as null, check if any problems*/
            System.out.println("Enter password");
            String passwordInput = scanner.nextLine();

            if (u.getUsername().equals(usernameInput) && u.getPassword().equals(passwordInput)) {

                System.out.println("Successfully Logged in,Account found.. What you like to do");
                break;

            } else if (e.getEmpUsername().equals(usernameInput) && e.getEmpPassword().equals(passwordInput)) {
                System.out.println("Successfully Logged in,Account found.. What you like to do");
                break;
            }else{
                System.out.println("Sorry, Incorrect username or password, Try again");
                i++;
            }
        }while (i<3);
        if(i==3) {// setting max login attempts as 3
            System.out.println("But reached Max login attempts today.Sorry!");// can throw Runtime Exception
        }
    }
}
