package com.twu.biblioteca.Unit;

import com.twu.biblioteca.BookShelf;
import com.twu.biblioteca.Console;
import com.twu.biblioteca.MenuOptions.CheckOutOption;
import com.twu.biblioteca.Exceptions.NoBookException;
import com.twu.biblioteca.User.UserSessionManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.BufferedReader;
import java.io.IOException;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by emmabaddeley on 30/09/2016.
 */
@RunWith(MockitoJUnitRunner.class)

public class CheckOutOptionTest {

    @Mock BookShelf bookShelf;
    @Mock Console console;
    @Mock BufferedReader reader;
    @Mock
    UserSessionManager userSessionManager;

    CheckOutOption checkOutOption;

    private String bookString =  "Book Title || Author || Year Published\nAnimal Farm || George Orwell || 1945\nHarry Potter and the Philosophers Stone || J.K Rowling || 1997\nThe Prince || Niccolo Machiavelli || 1532\nWatership Down || Richard Adams || 1972\nPride and Prejudice || Jane Austen || 1813";

    @Before
    public void initialize(){
        checkOutOption = new CheckOutOption("2 - Checkout a Book", console, userSessionManager, bookShelf, reader);
    }

    @Test
    public void promptForCheckOutChoice() throws IOException {
//        when(reader.readLine()).thenReturn("The Prince");
        checkOutOption.run();
        verify(console).printLine("Please enter the title of the book you'd like to checkout");
    }

    @Test
    public void checksOutBook() throws IOException, NoBookException {
        when(reader.readLine()).thenReturn("The Prince");
        checkOutOption.run();
        verify(bookShelf).checkOutBook("The Prince");
    }

    @Test
    public void successfulCheckoutMessage() throws IOException, NoBookException {
        when(reader.readLine()).thenReturn("The Prince");
        checkOutOption.run();
        verify(console).printLine("Thank you! Enjoy the book");
    }

    @Test
    public void unsuccessfulCheckoutMessage() throws IOException, NoBookException{
        when(reader.readLine()).thenReturn("The Frog");
        doThrow(new NoBookException()).when(bookShelf).checkOutBook("The Frog");
        checkOutOption.run();
        verify(console).printLine("That book is not available");
    }
}
