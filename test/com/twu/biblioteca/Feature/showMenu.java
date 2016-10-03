package com.twu.biblioteca.Feature;

import com.twu.biblioteca.BibliotecaApp;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

/**
 * Created by emmabaddeley on 29/09/2016.
 */
public class showMenu {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Test
    public void printsAMenu() {
        systemInMock.provideLines("7");
        BibliotecaApp.main();
        String output = systemOutRule.getLog();
        String[] strings = output.split("\n");
        assertEquals("Please select a Menu Choice", strings[2]);
        assertEquals("1 - List Books", strings[3]);
    }


}
