package com.twu.biblioteca.MenuOptions;

import com.twu.biblioteca.BookShelf;
import com.twu.biblioteca.Console;

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


    public MenuBuilder(BookShelf bookShelf, Console console, String... options) {
       this.options = Arrays.asList(options);
        this.bookShelf = bookShelf;
        this.console = console;

    }

    public List<? extends MenuOption> build() {
        List<? extends MenuOption> menuOptions = new ArrayList<>;
        menuOptions.add(new ListOption(options.get(0), console, bookShelf));

        }
    }
}
