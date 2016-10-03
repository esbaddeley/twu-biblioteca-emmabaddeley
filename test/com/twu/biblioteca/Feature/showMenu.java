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
    public void doesntShowCheckoutandReturnOptionsWhenNotLoggedIn() {
        systemInMock.provideLines("9");
        BibliotecaApp.main();
        String output = systemOutRule.getLog();
        assertEquals(false, output.contains("Checkout a Book"));
        assertEquals(false, output.contains("Checkout a Movie"));
        assertEquals(false, output.contains("Return a Book"));
        assertEquals(false, output.contains("Return a Movie"));
        assertEquals(false, output.contains("Log Out"));
    }

    @Test
    public void showsEverythingButLogInWhenLoggedIn(){
        systemInMock.provideLines("7", "123-4567", "password", "9");
        BibliotecaApp.main();
        String output = systemOutRule.getLog();
        assertEquals(false, output.contains("Log In\n8 - Log Out"));
    }


}
