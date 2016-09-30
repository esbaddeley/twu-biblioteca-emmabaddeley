package com.twu.biblioteca;

import com.sun.deploy.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by emmabaddeley on 29/09/2016.
 */
public class Biblioteca {

    private static final String COLUMNHEADERS = "Book Title || Author || Year Published\n";
    private Console console;
    private BookShelf bookShelf;
    private Menu menu;
    private BufferedReader reader;

    public Biblioteca(Console console, BookShelf bookShelf, Menu menu, BufferedReader reader){
        this.console = console;
        this.bookShelf = bookShelf;
        this.menu = menu;
        this.reader = reader;
    }

    public void run() {
        printWelcomeMessage();
        menu.showOptions(console);
        String choice = "";
        do {
            choice = "";
            menu.showOptions(console);;
            try {
                choice = GetUserChoice();
                switch (choice) {
                    case "1":
                        printMessage(bookShelf.listBooks());
                        break;
                    case "2":
                        try {
                            bookShelf.checkOutBook(bookTitlePrompt("Please enter the title of the book you'd like to checkout"));
                            printMessage("Thank you! Enjoy the book");
                        } catch (NoBookException e) {
                            printMessage(e.showCheckOutErrorMessage());
                        }
                        break;
                    case "3":
                        try{
                            bookShelf.returnBook(bookTitlePrompt("Please enter the title of the book you'd like to return"));
                            printMessage("Thank you for returning the book");
                        } catch (NoBookException e) {
                            printMessage(e.showReturnErrorMessage());
                        }

                        break;
                    case "4":
                        printMessage("Quitting the Program");
                        break;
                    default:
                        printMessage("Invalid Menu Option, please try again");
                }

            } catch (IOException e) {
                printMessage("Problem with input");
                e.printStackTrace();
            }
        } while (!choice.equals("4"));

    }



    private String bookTitlePrompt(String message) throws IOException {
        printMessage(message);
        return GetUserChoice();
    }

    private String GetUserChoice() throws IOException {
        return reader.readLine();
    }

    private void printMessage(String s) {
        console.printLine(s);
    }

    private void printWelcomeMessage(){
        printMessage("Welcome to the Biblioteca App");
    }


//    private String formatOptions(List<String> options){
//        return StringUtils.join(options, "\n");
//    }
//
//    private String formatBookList(){
//        return COLUMNHEADERS + formatOptions(bookShelf.listBooks());
//    }

}
