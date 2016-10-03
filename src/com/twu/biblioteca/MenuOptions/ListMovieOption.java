package com.twu.biblioteca.MenuOptions;

import com.twu.biblioteca.BookShelf;
import com.twu.biblioteca.Console;
import com.twu.biblioteca.MovieShelf;

/**
 * Created by emmabaddeley on 02/10/2016.
 */
public class ListMovieOption extends MenuOptionMaster implements MenuOption {

    private final MovieShelf movieShelf;

    public ListMovieOption(String name, Console console, MovieShelf movieShelf){
        super(name, console);
        this.movieShelf = movieShelf;
    }

    @Override
    public void run() {
        output.printLine(movieShelf.listMovies());;
    }

}
