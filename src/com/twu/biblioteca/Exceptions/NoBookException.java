package com.twu.biblioteca.Exceptions;

/**
 * Created by emmabaddeley on 30/09/2016.
 */
public class NoBookException extends Exception {

    public String showCheckOutErrorMessage(){
        return "That book is not available";
    }

    public String showReturnErrorMessage(){
        return "That is not a valid book to return";
    }

}
