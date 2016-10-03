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
public class userLogOut {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Test
    public void hasAUserLoginOption(){
        systemInMock.provideLines("8");
        BibliotecaApp.main();
        String output = systemOutRule.getLog();
        assertEquals(true, output.contains("Log Out"));
    }

    @Test
    public void hasAMessageOnSuccessfulLogOut(){
        systemInMock.provideLines("7", "123-4567", "password", "8", "9");
        BibliotecaApp.main();
        String output = systemOutRule.getLog();
        assertEquals(true, output.contains("Successfully logged out"));
    }

    @Test
    public void hasAMessageOnUnsuccessfulLogOut(){
        systemInMock.provideLines("8", "9");
        BibliotecaApp.main();
        String output = systemOutRule.getLog();
        assertEquals(true, output.contains("User not logged in"));
    }


}
