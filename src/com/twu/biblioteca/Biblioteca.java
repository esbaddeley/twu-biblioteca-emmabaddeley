package com.twu.biblioteca;

import com.sun.deploy.util.StringUtils;

import java.util.List;

/**
 * Created by emmabaddeley on 29/09/2016.
 */
public class Biblioteca {

    private static final String COLUMNHEADERS = "Book Title || Author || Year Published\n";
    private Console console;
    private BookShelf bookShelf;
    private Menu menu;

    public Biblioteca(Console console, BookShelf bookShelf, Menu menu){
        this.console = console;
        this.bookShelf = bookShelf;
        this.menu = menu;
    }

    public void run() {
        printWelcomeMessage();
        showMenuOptions();

    }

    private void printWelcomeMessage(){
        console.printLine("Welcome to the Biblioteca App");
    }

    private void showMenuOptions(){
        console.printLine("Please select a Menu Choice");
        console.printLine(formatOptions(menu.getOptions()));
    }

    private String formatOptions(List<String> options){
        return StringUtils.join(options, "\n");
    }

    private String formatBookList(){
        return COLUMNHEADERS + formatOptions(bookShelf.listBooks());
    }
}
