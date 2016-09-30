package com.twu.biblioteca.MenuOptions;

import com.twu.biblioteca.BookShelf;
import com.twu.biblioteca.Console;

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


    public MenuBuilder(BookShelf bookShelf, Console console, BufferedReader reader, String... options ) {
       this.options = Arrays.asList(options);
        this.bookShelf = bookShelf;
        this.console = console;
        this.reader = reader;
    }

    public List<? extends MenuOption> build() {
        List<MenuOption> menuOptions = new ArrayList<MenuOption>();
        menuOptions.add(new ListOption(options.get(0), console, bookShelf));
        menuOptions.add(new CheckOutOption(options.get(1), console, bookShelf, reader));
        menuOptions.add(new ReturnOption(options.get(2), console, bookShelf, reader));
        menuOptions.add(new QuitOption(options.get(3), console));
        return menuOptions;
    }
}
