package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;

public class BibliotecaApp {

    private Console console;
    private BookShelf bookShelf;
    private static List<String> bookList = Arrays.asList("The Prince", "Pride and Prejudice", "Animal Farm", "Watership Down", "Harry Potter and the Philosophers Stone");

    public static void main() {
        new BibliotecaApp(new Console(), new BookShelf(bookList)).run();
    }

    public BibliotecaApp(Console console, BookShelf bookShelf){
        this.console = console;
        this.bookShelf = bookShelf;
    }

    public void run() {
        console.printLine("Welcome to the Biblioteca App");

        for (String book : bookShelf.listBooks() ) {
            console.printLine(book);
        }

    }
}
