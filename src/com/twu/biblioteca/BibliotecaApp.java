package com.twu.biblioteca;

import com.sun.deploy.util.StringUtils;

import java.util.Arrays;
import java.util.List;

public class BibliotecaApp {

    private static final String COLUMNHEADERS = "Book Title || Author || Year Published\n";
    private Console console;
    private BookShelf bookShelf;
    private Menu menu;
    private static List<String> books = Arrays.asList("The Prince || Niccolo Machiavelli || 1532" , "Pride and Prejudice || Jane Austen || 1813", "Animal Farm || George Orwell || 1945", "Watership Down || Richard Adams || 1972", "Harry Potter and the Philosophers Stone || J.K Rowling || 1997");

    public static void main() {
        new BibliotecaApp(new Console(), new BookShelf(books), new Menu("List Books")).run();
    }

    public BibliotecaApp(Console console, BookShelf bookShelf, Menu menu){
        this.console = console;
        this.bookShelf = bookShelf;
        this.menu = menu;
    }

    public void run() {
        printWelcomeMessage();
        showMenuOptions();

    }

    private String displayWelcomeMessage() {
        return "Welcome to the Biblioteca App\n";
    }

    private void printWelcomeMessage(){
        console.printLine("Welcome to the Biblioteca App\n");
    }

    private void showMenuOptions(){
        console.printLine("Please select a Menu Choice");
        console.printLine(formatMenuOptions());
    }

    private String formatBookList(){
        List<String> joinList = bookShelf.listBooks();
        String bookListString = StringUtils.join(joinList, "\n");
        return COLUMNHEADERS + bookListString;
    }

    private String formatMenuOptions(){
        List<String> joinList = menu.getOptions();
        String menuListString = StringUtils.join(joinList, "\n");
        return menuListString;
    }
}
