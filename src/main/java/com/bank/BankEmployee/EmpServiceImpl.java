package com.bank.BankEmployee;

import com.bank.CommonUser.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implements Employee Service
 */

    public class EmpServiceImpl implements EmployeeService {
        List<Employee> employees;
        public EmpServiceImpl(){
            employees= new ArrayList<>();
            employees.add(new Employee(11,"user2@gmail.com","user2","user2pass","Employee"));
        }

        /**
         * @param empusername username for employee to login
         * @param emppassword password of employee to login
         * @throws UserNotFoundException if User Not Found
         * @throws  IllegalStateException Runtime Exception
         */
        @Override
        public Employee authenticate(String empusername, String emppassword) throws UserNotFoundException,IllegalStateException {
            if ((empusername == null) || (emppassword == null)) {
                throw new IllegalStateException("Username or password cannot be null");
                // If either value is null throw Illegal State Exception
            }
           Employee employee = employees.stream().filter(u -> u.getEmpUsername().equals(empusername))
                    .findFirst().orElse(null);//if username found ,filter out first one else user=NULL

            if (employee== null || !(employee.getEmpPassword().equals(emppassword))){// either username not found or password is incorrect
                throw new UserNotFoundException("Incorrect Username or Password");
            }

            return employee;
        }

    }



