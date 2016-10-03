package com.twu.biblioteca.Unit;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Exceptions.NoBookException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by emmabaddeley on 30/09/2016.
 */
public class BookTest {
    String detailString = "The Prince || Niccolo Machiavelli || 1532";

    @Test
    public void bookHasTitle(){
        Book book = new Book(detailString);
        assertEquals("The Prince", book.getTitle());
    }

    @Test
    public void bookCanBeCheckedOut() throws NoBookException {
        Book book = new Book(detailString);
        book.checkOut();
        assertEquals(false, book.isCheckedIn());
    }

    @Test
    public void bookCanBeReturned() throws NoBookException {
        Book book = new Book(detailString);
        book.checkOut();
        book.returnBook();
        assertEquals(true, book.isCheckedIn());
    }

    @Test
    public void returnsTheDetailsString(){
        Book book = new Book(detailString);
        assertEquals(detailString, book.getDetails());
    }

}
