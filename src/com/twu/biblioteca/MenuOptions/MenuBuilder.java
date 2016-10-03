package com.twu.biblioteca.MenuOptions;

import com.twu.biblioteca.BookShelf;
import com.twu.biblioteca.Console;
import com.twu.biblioteca.MovieShelf;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by emmabaddeley on 30/09/2016.
 */
public class MenuBuilder {

    private List<String> options;
    private BookShelf bookShelf;
    private Console console;
    private BufferedReader reader;
    private MovieShelf movieShelf;


    public MenuBuilder(BookShelf bookShelf, MovieShelf movieShelf, Console console, BufferedReader reader, String... options ) {
       this.options = Arrays.asList(options);
        this.bookShelf = bookShelf;
        this.movieShelf = movieShelf;
        this.console = console;
        this.reader = reader;
    }

    public List<MenuOption> build() {
        List<MenuOption> menuOptions = new ArrayList<MenuOption>();
        menuOptions.add(new ListOption(options.get(0), console, bookShelf));
        menuOptions.add(new CheckOutOption(options.get(1), console, bookShelf, reader));
        menuOptions.add(new ReturnOption(options.get(2), console, bookShelf, reader));
        menuOptions.add(new ListMovieOption(options.get(3), console, movieShelf));
        menuOptions.add(new QuitOption(options.get(4), console));
        return menuOptions;
    }
}
