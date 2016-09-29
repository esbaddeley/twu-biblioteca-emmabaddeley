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



    @Test
    public void printMenu(){
        when(menu.getOptions()).thenReturn(menuOptions);
        biblioteca.run();
        verify(console).printLine("Welcome to the Biblioteca App\n");
        verify(console).printLine("Please select a Menu Choice");
        verify(console).printLine("List Books");
    }
    

}