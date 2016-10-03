package com.twu.biblioteca.Exceptions;

/**
 * Created by emmabaddeley on 03/10/2016.
 */
public class NoMovieException extends Exception {

    public String showCheckOutErrorMessage() {
        return "That movie is not available";
    }

    public String showReturnErrorMessage() { return "That is not a valid movie to return";
    }
}
