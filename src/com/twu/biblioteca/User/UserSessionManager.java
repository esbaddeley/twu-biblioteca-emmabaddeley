package com.twu.biblioteca.User;

import java.util.List;

/**
 * Created by emmabaddeley on 03/10/2016.
 */
public class UserSessionManager {

    private final List<User> users;

    public UserSessionManager(List<User> users){
        this.users = users;
    };

    public void logIn(String s, String password) {
        throw new UnsupportedOperationException();
    }

    public User currentUser() {
        throw new UnsupportedOperationException();
    }
}
