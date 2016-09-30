package com.twu.biblioteca;

/**
 * Created by emmabaddeley on 30/09/2016.
 */
public class BookCheckedOutException extends NoBookException {

    public String showErrorMessage(){
        return "Book Checked Out";
    }
}
