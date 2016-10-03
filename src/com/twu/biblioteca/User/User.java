package com.twu.biblioteca.User;

import java.util.Objects;

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
        return ((Objects.equals(number, libraryNumber)) && (Objects.equals(enteredPassword, password)));
    }


    public String getNumber() {
        return libraryNumber;
    }

    public String getPassword(){
        return password;
    }
}
