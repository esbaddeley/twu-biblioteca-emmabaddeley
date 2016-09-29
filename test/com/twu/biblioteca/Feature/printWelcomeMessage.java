package com.twu.biblioteca.Feature;

import com.twu.biblioteca.BibliotecaApp;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.assertEquals;

/**
 * Created by emmabaddeley on 20/09/2016.
 */


public class printWelcomeMessage {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();



    @Test
    public void printsAWelcomeMessage() {
        BibliotecaApp.main();
        String output = systemOutRule.getLog();
        String[] strings = output.split("\n\n");
        assertEquals("Welcome to the Biblioteca App", strings[0]);
    }


}
