package com.twu.biblioteca.MenuOptions;

import com.twu.biblioteca.Console;
import com.twu.biblioteca.User.UserSessionManager;

/**
 * Created by emmabaddeley on 30/09/2016.
 */
public class QuitOption extends MenuOptionMaster implements MenuOption {


    private static final String QUIT_MESSAGE = "Quitting the Program";

    public QuitOption(String name, Console console, UserSessionManager userSessionManager) {
        super(name, console, userSessionManager);
    }

    @Override
    public void run() {
        output.printLine(QUIT_MESSAGE);
    }

    @Override
    public boolean display(){
        return true;
    }
}
