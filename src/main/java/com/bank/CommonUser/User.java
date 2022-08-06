package com.bank.CommonUser;

/**
 * POM Model for user type
 */

public class User {
    public String email;
    public String username;
    public String password;
    public String role="Customer";

    public int id;
    public int ac_id;
    //public String account_type="Chequing";

    public User() {  //no args constructor
    }

    /**
     * @param id identifier
     * @param email user email id
     * @param username username to login
     * @param password password to login
     * @param ac_id account number of user
     */
    public User(int id,String email, String username, String password,int ac_id) {
        this.id=id;
        this.ac_id=ac_id;
        this.email = email;
        this.username = username;
        this.password = password;
        //this.role = role;
        //this.account_type=account_type;
    }
    //getters
    public int getId() {        return id;    }

    public String getEmail() {   return email;    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

   // public String getAccount_type() {     return account_type;}

    //setters

    public void setId(int id) {        this.id = id;    }

    public void setEmail(String email) { //setters
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

   // public void setAccount_type(String account_type) {  this.account_type = account_type;    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
               // ", role='" + role + '\'' +
              // ", account_type='" + account_type + '\'' +


                '}';
    }

}
 /*User u =rs.getInt("id")==0? null:new User(
                        rs.getInt("id"),
                        rs.getString("email"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("ac_id")
                );*/