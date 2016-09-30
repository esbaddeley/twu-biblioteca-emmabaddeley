package com.twu.biblioteca;

/**
 * Created by emmabaddeley on 30/09/2016.
 */
public class NoBookException extends Exception {

    public String showErrorMessage(){
        return "No Book";
    }

}
