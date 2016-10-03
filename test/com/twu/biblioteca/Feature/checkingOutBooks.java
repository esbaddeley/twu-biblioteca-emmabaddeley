package com.twu.biblioteca.Feature;

import com.twu.biblioteca.BibliotecaApp;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

/**
 * Created by emmabaddeley on 30/09/2016.
 */
public class checkingOutBooks {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Test
    public void hasACheckingOutBookMenuOption(){
        systemInMock.provideLines("7");
        BibliotecaApp.main();
        String output = systemOutRule.getLog();
        assertEquals(true, output.contains("Checkout a Book"));
    }

    @Test
    public void promptsTheUserForATitle () {
        systemInMock.provideLines("2", "The Prince", "1", "7");
        BibliotecaApp.main();
        String output = systemOutRule.getLog();
        assertEquals(true, output.contains("Please enter the title of the book you'd like to checkout"));
    }

    @Test
    public void bookNoLongerAppearsInList() {
        systemInMock.provideLines("2", "The Prince", "1", "7");
        BibliotecaApp.main();
        String output = systemOutRule.getLog();
        assertEquals(false, output.contains("The Prince || Niccolo Machiavelli || 1532"));
    }

    @Test
    public void successfulCheckOutMessage() {
        systemInMock.provideLines("2", "The Prince", "1", "7");
        BibliotecaApp.main();
        String output = systemOutRule.getLog();
        assertEquals(true, output.contains("Thank you! Enjoy the book"));
    }

    @Test
    public void unsuccessfulCheckoutMessage() {
        systemInMock.provideLines("2", "The Frog", "7");
        BibliotecaApp.main();
        String output = systemOutRule.getLog();
        assertEquals(true, output.contains("That book is not available"));
    }

}
