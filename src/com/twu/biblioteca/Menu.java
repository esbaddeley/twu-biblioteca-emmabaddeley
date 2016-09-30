package com.twu.biblioteca;

import com.sun.javafx.tools.packager.bundlers.RelativeFileSet;
import com.twu.biblioteca.MenuOptions.MenuOption;

import java.util.Arrays;
import java.util.List;

/**
 * Created by emmabaddeley on 29/09/2016.
 */
public class Menu {

    private static final String MENU_CHOICE_PROMPT = "Please select a Menu Choice" ;
    BookShelf bookShelf;
    List<? extends MenuOption> options;


    public Menu(List<MenuOption> options) {
      this.options = options;
    }

    public void showOptions(Console console) {
        console.printLine(MENU_CHOICE_PROMPT);
        for (MenuOption menuOption : options ) {
            console.printLine(menuOption.getName());
        }

    }

//    public String matchOption(Integer option) {
//      return options.get(option - 1);
//    };

    public void executeOption(String choice, Console console) {
        try {
        MenuOption option = options.get(Integer.parseInt(choice) - 1);
        option.run();
        } catch (NullPointerException e) {
            console.printLine("Invalid Menu Option, please try again");
        }
    }



}
