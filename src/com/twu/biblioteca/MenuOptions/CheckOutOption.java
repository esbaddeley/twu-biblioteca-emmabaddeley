package com.twu.biblioteca.MenuOptions;

import com.twu.biblioteca.BookShelf;
import com.twu.biblioteca.Console;
import com.twu.biblioteca.Exceptions.NoBookException;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by emmabaddeley on 30/09/2016.
 */
public class CheckOutOption extends MenuOptionMaster implements MenuOption {

    private final BookShelf bookShelf;
    BufferedReader reader;

    public CheckOutOption(String name, Console console, BookShelf bookShelf, BufferedReader reader){
        super(name, console);
        this.bookShelf = bookShelf;
        this.reader = reader;
    }

    @Override
    public void run() {
        try {
            bookShelf.checkOutBook(bookTitlePrompt("Please enter the title of the book you'd like to checkout"));
            output.printLine("Thank you! Enjoy the book");
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (NoBookException e) {
            output.printLine(e.showCheckOutErrorMessage());
        }
    }

    private String bookTitlePrompt(String message) throws IOException {
        output.printLine(message);
        return GetUserChoice();
    }

    private String GetUserChoice() throws IOException {
        return reader.readLine();
    }
}
