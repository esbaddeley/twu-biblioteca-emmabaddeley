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

    public Biblioteca(Console console, BookShelf bookShelf, Menu menu){
        this.console = console;
        this.bookShelf = bookShelf;
        this.menu = menu;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void run() {
        printWelcomeMessage();
        showMenuOptions();
        try {
            String choice = GetUserChoice(reader);
            switch (choice) {
                case "1":
                    printMessage(formatBookList());
                    break;
                default:
                    printMessage("Invalid Menu Option, please try again");

                }

        } catch (IOException e) {
            printMessage("Problem with input");
            e.printStackTrace();
        }

    }


    private String GetUserChoice(BufferedReader reader) throws IOException {
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
        console.printLine(formatOptions(menu.getOptions()));
    }

    private String formatOptions(List<String> options){
        return StringUtils.join(options, "\n");
    }

    private String formatBookList(){
        return COLUMNHEADERS + formatOptions(bookShelf.listBooks());
    }

}
