package com.twu.biblioteca.MenuOptions;

import com.twu.biblioteca.Console;
import com.twu.biblioteca.MovieShelf;

import java.io.BufferedReader;

/**
 * Created by emmabaddeley on 03/10/2016.
 */
public class ReturnMovieOption extends MenuOptionMaster implements MenuOption {

    private final MovieShelf movieShelf;
    private BufferedReader reader;

    public ReturnMovieOption(String name, Console console, MovieShelf movieShelf, BufferedReader reader){
        super(name, console);
        this.movieShelf = movieShelf;
        this.reader = reader;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException();
    }
}
