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
public class returningBooks {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Test
    public void hasAReturningBookMenuOption(){
        systemInMock.provideLines("7");
        BibliotecaApp.main();
        String output = systemOutRule.getLog();
        assertEquals(true, output.contains("Return a Book"));
    }

    @Test
    public void promptsTheUserForATitle(){
        systemInMock.provideLines("3", "The Prince", "7");
        BibliotecaApp.main();
        String output = systemOutRule.getLog();
        assertEquals(true, output.contains("Please enter the title of the book you'd like to return"));
    }

    @Test
    public void returnedBookAppearsInList() {
        systemInMock.provideLines("2", "The Prince", "1", "3", "The Prince", "1", "7");
        BibliotecaApp.main();
        String output = systemOutRule.getLog();
        assertEquals(true, output.contains("The Prince || Niccolo Machiavelli || 1532"));
    }

    @Test
    public void successfulReturnMessage() {
        systemInMock.provideLines("2", "The Prince", "3", "The Prince", "7");
        BibliotecaApp.main();
        String output = systemOutRule.getLog();
        assertEquals(true, output.contains("Thank you for returning the book"));
    }

    @Test
    public void unsuccessfulReturnMessage() {
        systemInMock.provideLines("3", "The Prince", "7");
        BibliotecaApp.main();
        String output = systemOutRule.getLog();
        assertEquals(true, output.contains("That is not a valid book to return"));
    }


}
