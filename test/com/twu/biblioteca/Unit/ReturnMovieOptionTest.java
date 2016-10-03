package com.twu.biblioteca.Unit;

import com.twu.biblioteca.Console;
import com.twu.biblioteca.Exceptions.NoBookException;
import com.twu.biblioteca.Exceptions.NoMovieException;
import com.twu.biblioteca.MenuOptions.ReturnMovieOption;
import com.twu.biblioteca.MenuOptions.ReturnOption;
import com.twu.biblioteca.MovieShelf;
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
 * Created by emmabaddeley on 03/10/2016.
 */
@RunWith(MockitoJUnitRunner.class)

public class ReturnMovieOptionTest {
    @Mock
    MovieShelf movieShelf;
    @Mock
    Console console;
    @Mock
    BufferedReader reader;

    ReturnMovieOption returnMovieOption;

    @Before
    public void initialize(){
        returnMovieOption = new ReturnMovieOption("6 - Return a Book", console, movieShelf, reader);
    }


    @Test
    public void promptForReturnChoice() throws IOException {
        returnMovieOption.run();
        verify(console).printLine("Please enter the name of the movie you'd like to return");
    }

    @Test
    public void successfulReturnMessage() throws IOException, NoMovieException {
        when(reader.readLine()).thenReturn("The Prince");
        returnMovieOption.run();
        verify(console).printLine("Thank you for returning the movie");
    }

    @Test
    public void unsuccessfulReturnMessage() throws IOException, NoMovieException{
        when(reader.readLine()).thenReturn("The Frog");
        doThrow(new NoMovieException()).when(movieShelf).returnMovie("The Frog");
        returnMovieOption.run();
        verify(console).printLine("That is not a valid movie to return");
    }

}
