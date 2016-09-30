package com.twu.biblioteca.Feature;

import com.twu.biblioteca.BibliotecaApp;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

/**
 * Created by emmabaddeley on 29/09/2016.
 */
public class keepPromptingMenuOptions {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Test
    public void promptWithAnotherMenuChoice() {
        systemInMock.provideLines("1", "4");
        BibliotecaApp.main();
        String output = systemOutRule.getLog();
        String[] strings = output.split("\n");
        assertEquals(true, strings[12].contains("Please select a Menu Choice"));
    }

    @Test
    public void programQuitsWhenSelected() {
        systemInMock.provideLines("4");
        BibliotecaApp.main();
        String output = systemOutRule.getLog();
        assertEquals(true, output.contains("Quitting the Program"));
    }

}
