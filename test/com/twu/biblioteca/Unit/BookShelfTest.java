package com.twu.biblioteca.Unit;

import com.twu.biblioteca.BookShelf;
import com.twu.biblioteca.NoBookException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by emmabaddeley on 29/09/2016.
 */
public class BookShelfTest {

    List<String> books = Arrays.asList("The Prince || Niccolo Machiavelli || 1532" , "Pride and Prejudice || Jane Austen || 1813", "Animal Farm || George Orwell || 1945", "Watership Down || Richard Adams || 1972", "Harry Potter and the Philosophers Stone || J.K Rowling || 1997");


    @Test
    public void returnsAListOfBooks(){
        BookShelf bookShelf = new BookShelf(books);
        assertEquals(bookShelf.listBooks(), books);
    }

    @Test
    public void checksOutABook() throws NoBookException {
        BookShelf bookShelf = new BookShelf(books);
        bookShelf.checkOutBook("The Prince");
        assertEquals(false, (bookShelf.listBooks()).contains("The Prince || Niccolo Machiavelli || 1532"));
    }

    @Test
    public void returnsABook() throws NoBookException {
        BookShelf bookShelf = new BookShelf(books);
        bookShelf.checkOutBook("The Prince");
        bookShelf.returnBook("The Prince");
        assertEquals(true, (bookShelf.listBooks()).contains("The Prince || Niccolo Machiavelli || 1532"));
    }


}
