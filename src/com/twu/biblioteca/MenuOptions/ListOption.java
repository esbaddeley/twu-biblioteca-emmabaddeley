package com.twu.biblioteca.MenuOptions;

import com.twu.biblioteca.BookShelf;
import com.twu.biblioteca.Console;
import com.twu.biblioteca.User.UserSessionManager;

/**
 * Created by emmabaddeley on 30/09/2016.
 */
public class ListOption extends MenuOptionMaster implements MenuOption {

    BookShelf bookShelf;


    public ListOption(String name, Console console, UserSessionManager userSessionManager, BookShelf bookShelf){
        super(name, console, userSessionManager);
        this.bookShelf = bookShelf;
    }

    @Override
    public void run() {
        output.printLine(bookShelf.listBooks());
    }

    @Override
    public boolean display(){
        return true;
    }
}
