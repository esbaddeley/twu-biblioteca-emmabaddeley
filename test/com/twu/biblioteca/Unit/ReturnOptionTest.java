package com.twu.biblioteca.Unit;

import com.twu.biblioteca.BookShelf;
import com.twu.biblioteca.Console;
import com.twu.biblioteca.MenuOptions.ReturnOption;
import com.twu.biblioteca.Exceptions.NoBookException;
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
public class ReturnOptionTest {

    @Mock
    BookShelf bookShelf;
    @Mock
    Console console;
    @Mock
    BufferedReader reader;

    ReturnOption returnOption;

    @Before
    public void initialize(){
        returnOption = new ReturnOption("2 - Checkout a Book", console, bookShelf, reader);
    }


    @Test
    public void promptForReturnChoice() throws IOException {
        returnOption.run();
        verify(console).printLine("Please enter the title of the book you'd like to return");
    }

    @Test
    public void successfulReturnMessage() throws IOException, NoBookException {
        when(reader.readLine()).thenReturn("The Prince");
        returnOption.run();
        verify(console).printLine("Thank you for returning the book");
    }

    @Test
    public void unsuccessfulReturnMessage() throws IOException, NoBookException{
        when(reader.readLine()).thenReturn("The Frog");
        doThrow(new NoBookException()).when(bookShelf).returnBook("The Frog");
        returnOption.run();
        verify(console).printLine("That is not a valid book to return");
    }
}
