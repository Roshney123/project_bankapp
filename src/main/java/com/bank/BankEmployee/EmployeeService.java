package com.bank.BankEmployee;


import com.bank.CommonUser.UserNotFoundException;

public interface EmployeeService {

        /**
         * @param empusername username for employee to login
         * @param emppassword password of employee to login
         * @throws UserNotFoundException if User Not Found
         * @throws  IllegalStateException Runtime Exception
         */
        Employee authenticate(String empusername, String emppassword) throws UserNotFoundException,IllegalStateException;//login

        //open account for customer,
        // customer services
        //view credit application/Review
        //Credit approval




}
