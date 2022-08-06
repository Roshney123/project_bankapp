package com.bank.CommonUser;

/**
 * Model for Account
 */

public class Account {
            public int id;
            public int ac_id;
            public String username;
            public String account_type;
            public double balance;

            public Account() {
            }

    /**
     * @param id ID
     * @param ac_id account number
     * @param username username to represent user_id
     * @param account_type Type of account
     * @param balance balance in account
     */
            public Account(int id, int ac_id,String username, String account_type,double balance) {
                this.id= id;
                this.ac_id=ac_id;
                this.username= username;
                this.account_type =account_type;
                this.balance=balance;
            }


            public int getId() {
                return id;
            }

            public int getAc_id() {
            return ac_id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setAc_id(int ac_id) {
                this.ac_id = ac_id;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }


    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}


