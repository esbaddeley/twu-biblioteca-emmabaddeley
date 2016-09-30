package com.twu.biblioteca.MenuOptions;

import com.twu.biblioteca.Console;

/**
 * Created by emmabaddeley on 30/09/2016.
 */
abstract public class MenuOptionMaster implements MenuOption {

    String name;
    private Console output;

    public MenuOptionMaster(String name, Console console){
        this.name = name;
        this.output = console;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    abstract public void run();
}
