package com.twu.biblioteca;

public class BibliotecaApp {

    private Console console;

    public static void main() {
        new BibliotecaApp(new Console()).run();
    }

    public BibliotecaApp(Console console){
        this.console = console;
    }

    public void run() {
        console.printLine("Welcome to the Biblioteca App");
    }
}
