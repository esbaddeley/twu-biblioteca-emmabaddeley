package com.twu.biblioteca.MenuOptions;

import com.twu.biblioteca.BookShelf;
import com.twu.biblioteca.Console;
import com.twu.biblioteca.NoBookException;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by emmabaddeley on 30/09/2016.
 */
public class ReturnOption extends MenuOptionMaster implements MenuOption  {

    private final BookShelf bookShelf;
    BufferedReader reader;

    public ReturnOption(String name, Console console, BookShelf bookShelf, BufferedReader reader){
        super(name, console);
        this.bookShelf = bookShelf;
        this.reader = reader;
    }

    @Override
    public void run() {
        try{
            bookShelf.returnBook(bookTitlePrompt("Please enter the title of the book you'd like to return"));
            output.printLine("Thank you for returning the book");
        } catch (NoBookException e) {
            output.printLine(e.showReturnErrorMessage());
        } catch (IOException ex){
            ex.printStackTrace();
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
