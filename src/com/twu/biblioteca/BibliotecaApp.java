package com.twu.biblioteca;

import com.sun.deploy.util.StringUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class BibliotecaApp {

    private static List<String> books = Arrays.asList("The Prince || Niccolo Machiavelli || 1532" , "Pride and Prejudice || Jane Austen || 1813", "Animal Farm || George Orwell || 1945", "Watership Down || Richard Adams || 1972", "Harry Potter and the Philosophers Stone || J.K Rowling || 1997");

    public static void main() {
        new Biblioteca(new Console(), new BookShelf(books), new Menu("1 - List Books", "2 - Checkout a Book","3 - Return a Book", "4 - Quit the Program"), new BufferedReader(new InputStreamReader(System.in))).run();
    }





}
