package com.twu.biblioteca;

import com.sun.javafx.tools.packager.bundlers.RelativeFileSet;

import java.util.Arrays;
import java.util.List;

/**
 * Created by emmabaddeley on 29/09/2016.
 */
public class Menu {

    List<String> options;


    public Menu(String... options) {
        this.options = Arrays.asList(options);

    }

    public List<String> getOptions() {
        return options;
    }

    public String matchOption(Integer option) {
      return options.get(option - 1);
    };


}
