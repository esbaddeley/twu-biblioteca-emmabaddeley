package com.twu.biblioteca.User;


import com.twu.biblioteca.Exceptions.NoUserException;

import java.util.List;

/**
 * Created by emmabaddeley on 03/10/2016.
 */
public class UserSessionManager {

    private final List<User> users;
    private User currentUser;

    public UserSessionManager(List<User> users){
        this.users = users;
    };

    public void logIn(String number, String password) throws NoUserException {
        currentUser = findUser(number, password);
        if (currentUser == null) {
            throw new NoUserException();
        }
    }

    private User findUser(String number, String password) {
        User foundUser = null;
        for (User user : users){
            if (user.credentialsMatch(number, password)) {
               foundUser = user; 
            }
        }
        return foundUser;
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
