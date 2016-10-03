package com.twu.biblioteca.MenuOptions;

import com.twu.biblioteca.*;
import com.twu.biblioteca.Exceptions.NoMovieException;
import com.twu.biblioteca.User.UserSessionManager;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by emmabaddeley on 03/10/2016.
 */
public class CheckOutMovieOption extends MenuOptionMaster implements MenuOption {

    private MovieShelf movieShelf;
    private BufferedReader reader;


    public CheckOutMovieOption(String name, Console console, UserSessionManager userSessionManager, MovieShelf movieShelf, BufferedReader reader){
        super(name, console, userSessionManager);
        this.movieShelf = movieShelf;
        this.reader = reader;
    }

    @Override
    public void run() {
        try {
            movieShelf.checkOutMovie(movieNamePrompt("Please enter the name of the movie you'd like to checkout"));
            output.printLine("Thank you! Enjoy the movie");
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (NoMovieException e) {
            output.printLine(e.showCheckOutErrorMessage());
        }
    }

    private String movieNamePrompt(String message) throws IOException {
        output.printLine(message);
        return GetUserChoice();
    }

    private String GetUserChoice() throws IOException {
        return reader.readLine();
    }
}
