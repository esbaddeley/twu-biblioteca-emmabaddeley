package com.twu.biblioteca.MenuOptions;

import com.twu.biblioteca.Console;
import com.twu.biblioteca.Exceptions.NoUserException;
import com.twu.biblioteca.User.UserSessionManager;

import java.io.BufferedReader;

/**
 * Created by emmabaddeley on 03/10/2016.
 */
public class LogOutOption extends MenuOptionMaster implements MenuOption {

    private final BufferedReader reader;

    public LogOutOption(String name, Console console, UserSessionManager userSessionManager, BufferedReader reader) {
        super(name, console, userSessionManager);
        this.reader = reader;
    }

    @Override
    public void run() {
        try {
            userSessionManager.logOut();
            output.printLine("Successfully logged out");
        } catch (NoUserException u){
            output.printLine(u.showLogOutErrorMessage());
        }
    }

}
