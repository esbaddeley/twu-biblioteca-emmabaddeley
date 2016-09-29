package com.twu.biblioteca.Unit;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.BookShelf;
import com.twu.biblioteca.Console;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by emmabaddeley on 20/09/2016.
 */
@RunWith(MockitoJUnitRunner.class)

public class BibliotecaAppTest {

    private List<String> books = Arrays.asList("The Prince", "Pride and Prejudice", "Animal Farm", "Watership Down", "Harry Potter and the Philosophers Stone");

    @Mock Console console;

    BookShelf bookShelf = mock(BookShelf.class);



    @Test
    public void printsAWelcomeMessage() {
        BibliotecaApp app = new BibliotecaApp(console, bookShelf);
        app.run();
        verify(console).printLine("Welcome to the Biblioteca App");
    }

    @Test
    public void listBooks(){
        BibliotecaApp app = new BibliotecaApp(console, bookShelf);
        when(bookShelf.listBooks()).thenReturn(books);
        app.run();
        verify(bookShelf).listBooks();

//        verify(console).printLine("Welcome to the Biblioteca App\nThe Prince\nPride and Prejudice\nAnimal Farm\nWatership Down\nHarry Potter and the Philosophers Stone\n");
    }

}