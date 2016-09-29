package com.twu.biblioteca.Unit;

import com.twu.biblioteca.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by emmabaddeley on 20/09/2016.
 */
@RunWith(MockitoJUnitRunner.class)

public class BibliotecaTest {

    private List<String> books = Arrays.asList("The Prince || Niccolo Machiavelli || 1532" , "Pride and Prejudice || Jane Austen || 1813", "Animal Farm || George Orwell || 1945", "Watership Down || Richard Adams || 1972", "Harry Potter and the Philosophers Stone || J.K Rowling || 1997");
    private List<String> menuOptions = Arrays.asList("List Books");


    @Mock Console console;
    @Mock Menu menu;

    BookShelf bookShelf = mock(BookShelf.class);
    Biblioteca biblioteca;


    @Before
    public void initialize(){
        biblioteca = new Biblioteca(console, bookShelf, menu);
    }


//    @Test
//    public void listBooks(){
//        when(bookShelf.listBooks()).thenReturn(books);
//        app.run();
//        verify(bookShelf).listBooks();
////        verify(console).printLine("Welcome to the Biblioteca App\nThe Prince\nPride and Prejudice\nAnimal Farm\nWatership Down\nHarry Potter and the Philosophers Stone\n");
//    }

//    @Test
//    public void printBookList(){
//        when(bookShelf.listBooks()).thenReturn(books);
//        app.run();
//        verify(console).printLine("Welcome to the Biblioteca App\nBook Title || Author || Year Published\nThe Prince || Niccolo Machiavelli || 1532\nPride and Prejudice || Jane Austen || 1813\nAnimal Farm || George Orwell || 1945\nWatership Down || Richard Adams || 1972\nHarry Potter and the Philosophers Stone || J.K Rowling || 1997");
//    }

    @Test
    public void printMenu(){
        when(menu.getOptions()).thenReturn(menuOptions);
        biblioteca.run();
        verify(console).printLine("Welcome to the Biblioteca App\n");
        verify(console).printLine("Please select a Menu Choice");
        verify(console).printLine("List Books");
    }





}