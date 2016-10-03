package com.twu.biblioteca.MenuOptions;

import com.twu.biblioteca.BookShelf;
import com.twu.biblioteca.Console;
import com.twu.biblioteca.MovieShelf;
import com.twu.biblioteca.User.UserSessionManager;

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
    private UserSessionManager userSessionManager;


    public MenuBuilder(BookShelf bookShelf, MovieShelf movieShelf, Console console, BufferedReader reader, UserSessionManager userSessionManager, String... options ) {
       this.options = Arrays.asList(options);
        this.bookShelf = bookShelf;
        this.movieShelf = movieShelf;
        this.console = console;
        this.reader = reader;
        this.userSessionManager = userSessionManager;
    }

    public List<MenuOption> build() {
        List<MenuOption> menuOptions = new ArrayList<MenuOption>();
        menuOptions.add(new ListOption(options.get(0), console, userSessionManager, bookShelf));
        menuOptions.add(new CheckOutOption(options.get(1), console, userSessionManager, bookShelf, reader));
        menuOptions.add(new ReturnOption(options.get(2), console, userSessionManager, bookShelf, reader));
        menuOptions.add(new ListMovieOption(options.get(3), console, userSessionManager, movieShelf));
        menuOptions.add(new CheckOutMovieOption(options.get(4), console, userSessionManager, movieShelf, reader));
        menuOptions.add(new ReturnMovieOption(options.get(5), console, userSessionManager, movieShelf, reader));
        menuOptions.add(new LogInOption(options.get(6), console, userSessionManager, reader));
        menuOptions.add(new LogOutOption(options.get(7), console, userSessionManager, reader));
        menuOptions.add(new QuitOption(options.get(8), console, userSessionManager));
        return menuOptions;
    }
}
