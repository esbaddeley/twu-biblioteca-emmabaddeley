package com.twu.biblioteca.User;

/**
 * Created by emmabaddeley on 03/10/2016.
 */
public class User {

    private String libraryNumber;
    private String password;

    public User(String libraryNumber, String password){
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public boolean credentialsMatch(String number, String enteredPassword) {
        return ((number == libraryNumber) && (password == enteredPassword));
    }


}
