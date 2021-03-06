package com.twu.biblioteca.Feature;

import com.twu.biblioteca.BibliotecaApp;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

/**
 * Created by emmabaddeley on 20/09/2016.
 */


public class printWelcomeMessage {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();



    @Test
    public void printsAWelcomeMessage() {
        systemInMock.provideLines("7");
        BibliotecaApp.main();
        String output = systemOutRule.getLog();
        String[] strings = output.split("\n");
        assertEquals("Welcome to the Biblioteca App", strings[0]);
    }


}
