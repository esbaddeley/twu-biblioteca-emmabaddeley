package com.twu.biblioteca.MenuOptions;

import com.twu.biblioteca.Console;
import com.twu.biblioteca.Exceptions.NoUserException;
import com.twu.biblioteca.User.UserSessionManager;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by emmabaddeley on 03/10/2016.
 */
public class LogInOption extends MenuOptionMaster implements MenuOption {

    private static final String LIBRARY_NUMBER_PROMPT = "Please enter your library number";
    private static final String PASSWORD_PROMPT = "Please enter your password";
    private UserSessionManager userSessionManager;
    private BufferedReader reader;

    public LogInOption(String name, Console console, UserSessionManager userSessionManager, BufferedReader reader) {
        super(name, console);
        this.userSessionManager = userSessionManager;
        this.reader = reader;
    }

    @Override
    public void run() {
        try {
            String number = libraryNumberPrompt();
            String password = passwordPrompt();
            userSessionManager.logIn(number, password);
        } catch (IOException i){
            i.printStackTrace();
        } catch (NoUserException u){
            u.showLoginErrorMessage();
        }
    }

    private String passwordPrompt() throws IOException {
        output.printLine(PASSWORD_PROMPT);
        return GetUserChoice();
    }

    private String libraryNumberPrompt() throws IOException {
        output.printLine(LIBRARY_NUMBER_PROMPT);
        return GetUserChoice();

    }

    private String GetUserChoice() throws IOException {
        return reader.readLine();
    }
}
