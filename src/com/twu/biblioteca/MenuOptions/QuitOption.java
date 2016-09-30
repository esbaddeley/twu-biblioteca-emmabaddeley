package com.twu.biblioteca.MenuOptions;

import com.twu.biblioteca.Console;

/**
 * Created by emmabaddeley on 30/09/2016.
 */
public class QuitOption extends MenuOptionMaster implements MenuOption {


    private static final String QUIT_MESSAGE = "Quitting the Program";

    public QuitOption(String name, Console console) {
        super(name, console);
    }

    @Override
    public void run() {
        output.printLine(QUIT_MESSAGE);
    }
}
