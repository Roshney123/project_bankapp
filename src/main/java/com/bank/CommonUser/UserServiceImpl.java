package com.bank.CommonUser;


import java.util.ArrayList;
import java.util.List;
import com.bank.CommonUser.*;
import io.javalin.Javalin;
import java.util.Scanner;
import java.net.URI;

/**
 * Class which implements user services
 */
public class UserServiceImpl implements UserService {
    List<User> users;

    public UserServiceImpl() {
        users= new ArrayList<>();
        users.add(new User(1,"user1@gmail.com","user1","user1pass",15));
    }

    @Override
    public User authenticate(String username, String password) throws UserNotFoundException,IllegalStateException {
        if ((username == null) || (password == null)) {
            throw new IllegalStateException("Username or password cannot be null");
            // If either value is null throw Illegal State Exception
        }
        User user = users.stream().filter(u -> u.getUsername().equals(username))
                .findFirst().orElse(null);//if username found ,filter out first one else user=NULL

        if (user== null || !(user.getPassword().equals(password))){// either username not found or password is incorrect
            throw new UserNotFoundException("Incorrect Username or Password");
        }

        return user;
    }
}

