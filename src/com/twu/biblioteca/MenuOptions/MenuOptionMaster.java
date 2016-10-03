package com.twu.biblioteca.MenuOptions;

import com.twu.biblioteca.Console;
import com.twu.biblioteca.User.UserSessionManager;

/**
 * Created by emmabaddeley on 30/09/2016.
 */
abstract public class MenuOptionMaster implements MenuOption {

    String name;
    public Console output;
    public UserSessionManager userSessionManager;

    public MenuOptionMaster(String name, Console console, UserSessionManager userSessionManager) {
        this.name = name;
        this.output = console;
        this.userSessionManager = userSessionManager;
    }

    public boolean display(){
        return userSessionManager.loggedIn();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    abstract public void run();
}
