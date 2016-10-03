package com.twu.biblioteca.Feature;

import com.twu.biblioteca.BibliotecaApp;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

/**
 * Created by emmabaddeley on 03/10/2016.
 */
public class returningMovies {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Test
    public void hasAReturningMovieMenuOption(){
        systemInMock.provideLines("7");
        BibliotecaApp.main();
        String output = systemOutRule.getLog();
        assertEquals(true, output.contains("Return a Movie"));
    }

    @Test
    public void promptsTheUserForATitle(){
        systemInMock.provideLines("6", "Sharknado", "7");
        BibliotecaApp.main();
        String output = systemOutRule.getLog();
        assertEquals(true, output.contains("Please enter the name of the movie you'd like to return"));
    }

    @Test
    public void returnedMovieAppearsInList() {
        systemInMock.provideLines("5", "Sharknado", "4", "6", "Sharknado", "4", "7");
        BibliotecaApp.main();
        String output = systemOutRule.getLog();
        assertEquals(true, output.contains("Sharknado || 2013 || Thunder Levin || 1"));
    }

    @Test
    public void successfulReturnMessage() {
        systemInMock.provideLines("5", "Sharknado", "4", "6", "Sharknado", "4", "7");
        BibliotecaApp.main();
        String output = systemOutRule.getLog();
        assertEquals(true, output.contains("Thank you for returning the movie"));
    }

    @Test
    public void unsuccessfulReturnMessage() {
        systemInMock.provideLines("5", "Sharknado", "7");
        BibliotecaApp.main();
        String output = systemOutRule.getLog();
        assertEquals(true, output.contains("That is not a valid movie to return"));
    }
}
