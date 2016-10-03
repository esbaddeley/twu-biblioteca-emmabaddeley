package com.twu.biblioteca.Unit;


import com.twu.biblioteca.Console;
import com.twu.biblioteca.MenuOptions.ListMovieOption;
import com.twu.biblioteca.MovieShelf;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by emmabaddeley on 02/10/2016.
 */
@RunWith(MockitoJUnitRunner.class)

public class ListMoviesOptionTest {

    @Mock
    MovieShelf movieShelf;
    @Mock
    Console console;

    private String movieString = "Name || Year || Director || Rating \nThe Big Lebowski || 1998 || Joel Coen || 10\n Sharknado || 2013 || Thunder Levin || 1\n";


    @Test
    public void printsTheListOfBooks(){
        ListMovieOption listMovieOption = new ListMovieOption("4 - List Movies", console, movieShelf);
        when(movieShelf.listMovies()).thenReturn(movieString);
        listMovieOption.run();
        verify(console).printLine(movieString);
    }
}
