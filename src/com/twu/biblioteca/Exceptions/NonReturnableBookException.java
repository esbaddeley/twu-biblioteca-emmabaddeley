package com.twu.biblioteca.Exceptions;

/**
 * Created by emmabaddeley on 30/09/2016.
 */
public class NonReturnableBookException extends NoBookException {
    public String showErrorMessage(){
        return "That is not a valid book to return";
    }
}
