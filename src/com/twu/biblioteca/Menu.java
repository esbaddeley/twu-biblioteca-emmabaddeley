package com.twu.biblioteca;

import com.sun.javafx.tools.packager.bundlers.RelativeFileSet;

import java.util.Arrays;
import java.util.List;

/**
 * Created by emmabaddeley on 29/09/2016.
 */
public class Menu {

    private static final String MENU_CHOICE_PROMPT = "Please select a Menu Choice" ;
    List<String> options;


    public Menu(String... options) {
        this.options = Arrays.asList(options);

    }

    public void showOptions(Console console) {
        console.printLine(MENU_CHOICE_PROMPT);
        for (String menuOption : options ) {
            console.printLine(menuOption);
        }

    }

    public String matchOption(Integer option) {
      return options.get(option - 1);
    };


}
