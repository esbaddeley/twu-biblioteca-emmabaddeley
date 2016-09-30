package com.twu.biblioteca.MenuOptions;

import com.twu.biblioteca.BookShelf;
import com.twu.biblioteca.Console;

/**
 * Created by emmabaddeley on 30/09/2016.
 */
public class ListOption extends MenuOptionMaster implements MenuOption {

    BookShelf bookShelf;
    private Console output;


    public ListOption(String name, Console console, BookShelf bookShelf){
        super(name, console);
        this.bookShelf = bookShelf;
    }

    @Override
    public void run() {

    }
}
