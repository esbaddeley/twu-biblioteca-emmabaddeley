package com.twu.biblioteca;

import com.sun.deploy.util.StringUtils;

import java.util.Arrays;
import java.util.List;

public class BibliotecaApp {

    private static final String COLUMNHEADERS = "Book Title || Author || Year Published\n";
    private Console console;
    private BookShelf bookShelf;
    private static List<String> books = Arrays.asList("The Prince || Niccolo Machiavelli || 1532" , "Pride and Prejudice || Jane Austen || 1813", "Animal Farm || George Orwell || 1945", "Watership Down || Richard Adams || 1972", "Harry Potter and the Philosophers Stone || J.K Rowling || 1997");

    public static void main() {
        new BibliotecaApp(new Console(), new BookShelf(books)).run();
    }

    public BibliotecaApp(Console console, BookShelf bookShelf){
        this.console = console;
        this.bookShelf = bookShelf;
    }

    public void run() {
        console.printLine("Welcome to the Biblioteca App\n" + formatBookList());
    }

    private String formatBookList(){
        List<String> joinList = bookShelf.listBooks();
        String bookListString = StringUtils.join(joinList, "\n");
        return COLUMNHEADERS + bookListString;
    }
}
