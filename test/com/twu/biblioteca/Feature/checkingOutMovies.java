package com.twu.biblioteca.Feature;

import com.twu.biblioteca.BibliotecaApp;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

/**
 * Created by emmabaddeley on 02/10/2016.
 */
public class checkingOutMovies {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Test
    public void hasACheckingOutMovieMenuOption(){
        systemInMock.provideLines("6");
        BibliotecaApp.main();
        String output = systemOutRule.getLog();
        assertEquals(true, output.contains("Checkout a Movie"));
    }

    @Test
    public void promptsTheUserForATitle () {
        systemInMock.provideLines("5", "Sharknado", "6");
        BibliotecaApp.main();
        String output = systemOutRule.getLog();
        assertEquals(true, output.contains("Please enter the name of the movie you'd like to checkout"));
    }

    @Test
    public void bookNoLongerAppearsInList() {
        systemInMock.provideLines("5", "Sharknado", "4", "6");
        BibliotecaApp.main();
        String output = systemOutRule.getLog();
        assertEquals(false, output.contains("Sharknado || 2013 || Thunder Levin || 1"));
    }

    @Test
    public void successfulCheckOutMessage() {
        systemInMock.provideLines("5", "Sharknado", "6");
        BibliotecaApp.main();
        String output = systemOutRule.getLog();
        assertEquals(true, output.contains("Thank you! Enjoy the movie"));
    }

    @Test
    public void unsuccessfulCheckoutMessage() {
        systemInMock.provideLines("5", "The Frog", "6");
        BibliotecaApp.main();
        String output = systemOutRule.getLog();
        assertEquals(true, output.contains("That movie is not available"));
    }
}
