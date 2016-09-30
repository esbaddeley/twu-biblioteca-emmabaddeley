package com.twu.biblioteca.Unit;

import com.twu.biblioteca.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.mockito.Mockito.*;

/**
 * Created by emmabaddeley on 20/09/2016.
 */
@RunWith(MockitoJUnitRunner.class)

public class BibliotecaTest {

    private List<String> books = Arrays.asList("The Prince || Niccolo Machiavelli || 1532" , "Pride and Prejudice || Jane Austen || 1813", "Animal Farm || George Orwell || 1945", "Watership Down || Richard Adams || 1972", "Harry Potter and the Philosophers Stone || J.K Rowling || 1997");
    private List<String> menuOptions = Arrays.asList("1 - List Books", "2 - Checkout a Book", "3 - Quit the Program");


    @Mock Console console;
    @Mock Menu menu;
    @Mock BufferedReader reader;

    BookShelf bookShelf = mock(BookShelf.class);
    Biblioteca biblioteca;


    @Before
    public void initialize(){
        biblioteca = new Biblioteca(console, bookShelf, menu, reader);
    }


    @Test
    public void getUserInput() throws IOException {
        when(reader.readLine()).thenReturn("3");
        biblioteca.run();
        verify(reader).readLine();
    }

    @Test
    public void showAllMenuOptions() throws IOException {
        when(reader.readLine()).thenReturn("3");
        when(menu.getOptions()).thenReturn(menuOptions);
        biblioteca.run();
        verify(console).printLine("Welcome to the Biblioteca App");
        verify(console).printLine("Please select a Menu Choice");
        verify(console).printLine("1 - List Books");
        verify(console).printLine("2 - Checkout a Book");
        verify(console).printLine("3 - Quit the Program");
    }

    @Test
    public void printTheBookList() throws IOException {
        when(reader.readLine()).thenReturn("1", "3");
        when(menu.getOptions()).thenReturn(menuOptions);
        when(bookShelf.listBooks()).thenReturn(books);
        biblioteca.run();
        verify(console).printLine("Book Title || Author || Year Published\nThe Prince || Niccolo Machiavelli || 1532\nPride and Prejudice || Jane Austen || 1813\nAnimal Farm || George Orwell || 1945\nWatership Down || Richard Adams || 1972\nHarry Potter and the Philosophers Stone || J.K Rowling || 1997");
    }

    @Test
    public void promptForCheckOutChoice() throws IOException {
        when(reader.readLine()).thenReturn("2", "3");
        when(menu.getOptions()).thenReturn(menuOptions);
        biblioteca.run();
        verify(console).printLine("Please enter the title of the book you'd like to checkout");

    }

    @Test
    public void checksOutBook() throws IOException, NoBookException {
        when(reader.readLine()).thenReturn("2", "The Prince", "3");
        when(menu.getOptions()).thenReturn(menuOptions);
        biblioteca.run();
        verify(bookShelf).checkOutBook("The Prince");
    }

    @Test
    public void successfulCheckoutMessage() throws IOException, NoBookException {
        when(reader.readLine()).thenReturn("2", "The Prince", "3");
        when(menu.getOptions()).thenReturn(menuOptions);
        biblioteca.run();
        verify(console).printLine("Thank you! Enjoy the book");
    }

    @Test
    public void unsuccessfulCheckoutMessage() throws IOException, NoBookException{
        when(reader.readLine()).thenReturn("2", "The Frog", "3");
        when(menu.getOptions()).thenReturn(menuOptions);
        doThrow(new NoBookException()).when(bookShelf).checkOutBook("The Frog");
        biblioteca.run();
        verify(console).printLine("That book is not available");
    }








}