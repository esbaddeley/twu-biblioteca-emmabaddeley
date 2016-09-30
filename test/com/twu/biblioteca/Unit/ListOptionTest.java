package com.twu.biblioteca.Unit;

import com.twu.biblioteca.BookShelf;
import com.twu.biblioteca.Console;
import com.twu.biblioteca.MenuOptions.ListOption;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by emmabaddeley on 30/09/2016.
 */
@RunWith(MockitoJUnitRunner.class)

public class ListOptionTest {

    @Mock BookShelf bookShelf;
    @Mock Console console;

    private String bookString =  "Book Title || Author || Year Published\nAnimal Farm || George Orwell || 1945\nHarry Potter and the Philosophers Stone || J.K Rowling || 1997\nThe Prince || Niccolo Machiavelli || 1532\nWatership Down || Richard Adams || 1972\nPride and Prejudice || Jane Austen || 1813";


    @Test
    public void printsTheListOfBooks(){
        ListOption listOption = new ListOption("1 - List Options", console, bookShelf);
        when(bookShelf.listBooks()).thenReturn(bookString);
        listOption.run();
        verify(console).printLine("Book Title || Author || Year Published\nAnimal Farm || George Orwell || 1945\nHarry Potter and the Philosophers Stone || J.K Rowling || 1997\nThe Prince || Niccolo Machiavelli || 1532\nWatership Down || Richard Adams || 1972\nPride and Prejudice || Jane Austen || 1813");
    }

}
