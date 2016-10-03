package com.twu.biblioteca.Unit;

import com.twu.biblioteca.BookShelf;
import com.twu.biblioteca.Console;
import com.twu.biblioteca.MenuOptions.CheckOutMovieOption;
import com.twu.biblioteca.MenuOptions.CheckOutOption;
import com.twu.biblioteca.MovieShelf;
import com.twu.biblioteca.NoBookException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.BufferedReader;
import java.io.IOException;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by emmabaddeley on 03/10/2016.
 */
public class CheckOutMovieOptionTest {

    @Mock
    MovieShelf movieShelf;
    @Mock
    Console console;
    @Mock
    BufferedReader reader;


    private CheckOutMovieOption checkOutMovieOption;

    @Before
    public void initialize(){
        checkOutMovieOption = new CheckOutMovieOption("5 - Checkout a Movie", console, movieShelf, reader);
    }

    @Test
    public void promptForCheckOutChoice() throws IOException {
        checkOutMovieOption.run();
        verify(console).printLine("Please enter the title of the movie you'd like to checkout");
    }

    @Test
    public void checksOutBook() throws IOException, NoBookException {
        when(reader.readLine()).thenReturn("Sharknado");
        checkOutMovieOption.run();
        verify(movieShelf).checkOutMovie("Sharknado");
    }

    @Test
    public void successfulCheckoutMessage() throws IOException, NoBookException {
        when(reader.readLine()).thenReturn("The Prince");
        checkOutMovieOption.run();
        verify(console).printLine("Thank you! Enjoy the movie");
    }
}
