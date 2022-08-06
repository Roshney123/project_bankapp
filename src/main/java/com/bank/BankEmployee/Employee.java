package com.bank.BankEmployee;

/**
 * POM Model for Employee
 */

public class Employee {
        public int empid;
        public String empemail;
        public String empusername;
        public String emppassword;
        public String emprole;

        public Employee() {  //no args constructor
        }

    /**
     * @param empid represent employee id
     * @param empemail represent employee email id
     * @param empusername represent employee username to login
     * @param emppassword stands for employee password to login
     * @param emprole stands for employee role
     */
        public Employee(int empid,String empemail, String empusername, String emppassword, String emprole) {
            this.empid=empid;
            this.empemail = empemail;
            this.empusername = empusername;
            this.emppassword = emppassword;
            this.emprole = emprole;
        }

        public int getEmpid() {
        return empid;
        }

        public String getEmpEmail() {  //getters
            return empemail;
        }

        public String getEmpUsername() {
            return empusername;
        }

        public String getEmpPassword() {
            return emppassword;
        }

        public String getEmpRole() {
            return emprole;
        }


        public void setEmpid(int empid) {//setters
        this.empid = empid;
         }

        public void setEmail(String empemail) {
            this.empemail = empemail;
        }

        public void setUsername(String empusername) {
            this.empusername = empusername;
        }

        public void setPassword(String emppassword) {
            this.emppassword = emppassword;
        }

        public void setRole(String emprole) {
            this.emprole = emprole;
        }

    @Override
    public String toString() {
        return "Employee{" +
                "empid=" + empid +
                ", empemail='" + empemail + '\'' +
                ", empusername='" + empusername + '\'' +
                ", emppassword='" + emppassword + '\'' +
                ", emprole='" + emprole + '\'' +
                '}';
    }

}
