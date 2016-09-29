package com.twu.biblioteca.Feature;

import com.twu.biblioteca.BibliotecaApp;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.assertEquals;

/**
 * Created by emmabaddeley on 29/09/2016.
 */
public class showMenu {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void printsAMenu() {
        BibliotecaApp.main();
        String output = systemOutRule.getLog();
        String[] strings = output.split("\n");
        assertEquals("Please select a Menu Choice", strings[2]);
        assertEquals("List Books", strings[3]);
    }


}
