package com.twu.biblioteca;

import com.sun.deploy.util.StringUtils;
import com.twu.biblioteca.MenuOptions.MenuBuilder;
import com.twu.biblioteca.MenuOptions.MenuOption;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class BibliotecaApp {

    private static List<String> books = Arrays.asList("The Prince || Niccolo Machiavelli || 1532" , "Pride and Prejudice || Jane Austen || 1813", "Animal Farm || George Orwell || 1945", "Watership Down || Richard Adams || 1972", "Harry Potter and the Philosophers Stone || J.K Rowling || 1997");
    private static List<String> movies = Arrays.asList("The Big Lebowski || 1998 || Joel Coen || 10", "Sharknado || 2013 || Thunder Levin || 1");


    public static void main() {
        new Biblioteca(new Console(), new Menu(buildMenu()), new BufferedReader(new InputStreamReader(System.in))).run();
    }

    private static List<MenuOption> buildMenu(){
        BookShelf bookShelf = new BookShelf(books);
        MovieShelf movieShelf = new MovieShelf(movies);
        Console console = new Console();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        MenuBuilder menuBuilder = new MenuBuilder(bookShelf, movieShelf, console, reader, "1 - List Books", "2 - Checkout a Book","3 - Return a Book", "4 - List Movies", "5 - Checkout a Movie", "6 - Return a Movie", "7 - Quit the Program" );
        return menuBuilder.build();
    }





}
