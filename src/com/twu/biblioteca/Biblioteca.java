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
        String choice = "";
        do {
            choice = "";
            showMenuOptions();
            try {
                choice = GetUserChoice();
                switch (choice) {
                    case "1":
                        printMessage(formatBookList());
                        break;
                    case "2":
                        try {
                            bookShelf.checkOutBook(bookTitlePrompt());
                            printMessage("Thank you! Enjoy the book");
                        } catch (NoBookException e) {
                            printMessage(e.showErrorMessage());
                        }
                        break;
                    case "3":
                        printMessage("Quitting the Program");
                        break;
                    default:
                        printMessage("Invalid Menu Option, please try again");
                }

            } catch (IOException e) {
                printMessage("Problem with input");
                e.printStackTrace();
            }
        } while (!choice.equals("3"));

    }



    private String bookTitlePrompt() throws IOException {
        printMessage("Please enter the title of the book you'd like to checkout");
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

    private void showMenuOptions(){
        printMessage("Please select a Menu Choice");
//        console.printLine(formatOptions(menu.getOptions()));
        for (String menuOption : menu.getOptions()) {
            printMessage(menuOption);
        }
    }

    private String formatOptions(List<String> options){
        return StringUtils.join(options, "\n");
    }

    private String formatBookList(){
        return COLUMNHEADERS + formatOptions(bookShelf.listBooks());
    }

}
