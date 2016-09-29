package com.twu.biblioteca.Unit;

import com.twu.biblioteca.BookShelf;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by emmabaddeley on 29/09/2016.
 */
public class BookShelfTest {

    List<String> books = Arrays.asList("The Prince", "Pride and Prejudice", "Animal Farm", "Watership Down", "Harry Potter and the Philosophers Stone");


    @Test
    public void returnsAListOfBooks(){
        BookShelf bookShelf = new BookShelf(books);
        assertEquals(bookShelf.listBooks(), books);
    }


}
