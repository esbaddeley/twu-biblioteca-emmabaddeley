package com.twu.biblioteca;

/**
 * Created by emmabaddeley on 03/10/2016.
 */
public class NoMovieException extends Exception {

    public String showCheckOutErrorMessage() {
        return "That movie is not available";
    }
}
