package com.twu.biblioteca.MenuOptions;

import com.twu.biblioteca.Console;
import com.twu.biblioteca.Exceptions.NoBookException;
import com.twu.biblioteca.Exceptions.NoMovieException;
import com.twu.biblioteca.MovieShelf;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by emmabaddeley on 03/10/2016.
 */
public class ReturnMovieOption extends MenuOptionMaster implements MenuOption {

    private final MovieShelf movieShelf;
    private BufferedReader reader;

    public ReturnMovieOption(String name, Console console, MovieShelf movieShelf, BufferedReader reader){
        super(name, console);
        this.movieShelf = movieShelf;
        this.reader = reader;
    }

    @Override
    public void run() {
        try{
            movieShelf.returnMovie(movieTitlePrompt("Please enter the name of the movie you'd like to return"));
            output.printLine("Thank you for returning the movie");
        } catch (NoMovieException e) {
            output.printLine(e.showReturnErrorMessage());
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    private String movieTitlePrompt(String message) throws IOException {
        output.printLine(message);
        return GetUserChoice();
    }

    private String GetUserChoice() throws IOException {
        return reader.readLine();
    }
}
