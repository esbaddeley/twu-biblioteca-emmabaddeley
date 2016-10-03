package com.twu.biblioteca;

import com.sun.deploy.util.StringUtils;
import com.twu.biblioteca.Exceptions.NoBookException;

import java.util.Arrays;

/**
 * Created by emmabaddeley on 30/09/2016.
 */
public class Book {

    public String title;
    private String author;
    private String yearPublished;
    private boolean checkedIn;

    public Book(String detailString){
        String[] details = detailString.split(" \\|\\| ");
        this.title = details[0];
        this.author = details[1];
        this.yearPublished = details[2];
        checkedIn = true;
    }

    public String getTitle() {
        return title;
    }

    public void checkOut() throws NoBookException {
        if (!checkedIn) {throw new NoBookException();}
        else { checkedIn = false;}
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public String getDetails() {
         return StringUtils.join((Arrays.asList(title, author, yearPublished)), " || ");
    }

    public void returnBook() throws NoBookException {
        if (checkedIn) {throw new NoBookException();}
        else {checkedIn = true;}

    }
}
