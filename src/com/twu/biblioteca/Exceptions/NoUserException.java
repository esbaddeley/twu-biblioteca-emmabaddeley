package com.twu.biblioteca.Exceptions;

/**
 * Created by emmabaddeley on 03/10/2016.
 */
public class NoUserException extends Throwable {

    public String showLoginErrorMessage(){
        return "Invalid Login Credentials";
    }

    public String showLogOutErrorMessage() { return "User not logged in"; }
}
