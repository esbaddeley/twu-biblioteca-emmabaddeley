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

    private static final String WELCOME_MESSAGE = "Welcome to the Biblioteca App\n";

    private Console console;
    private Menu menu;
    private BufferedReader reader;

    public Biblioteca(Console console, Menu menu, BufferedReader reader){
        this.console = console;
        this.menu = menu;
        this.reader = reader;
    }

    public void run() {
        printWelcomeMessage();
        String choice = "";
        do {
            choice = "";
            menu.showOptions(console);;
            try {
                choice = GetUserChoice();
                menu.executeOption(choice, console);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (!choice.equals("6"));
    }


    private String GetUserChoice() throws IOException {
        return reader.readLine();
    }

    private void printMessage(String s) {
        console.printLine(s);
    }

    private void printWelcomeMessage(){
        printMessage(WELCOME_MESSAGE);
    }


//    private String formatOptions(List<String> options){
//        return StringUtils.join(options, "\n");
//    }
//
//    private String formatBookList(){
//        return COLUMNHEADERS + formatOptions(bookShelf.listBooks());
//    }

}
