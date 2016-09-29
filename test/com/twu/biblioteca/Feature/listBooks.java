package com.twu.biblioteca.Feature;

import com.twu.biblioteca.BibliotecaApp;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

/**
 * Created by emmabaddeley on 29/09/2016.
 */
public class listBooks {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Test
    public void ListBooks() {
        BibliotecaApp.main();
        systemInMock.provideLines("List Books");
        String output = systemOutRule.getLog();
        String[] strings = output.split("\n");
        assertEquals(true, Arrays.asList(strings).contains("Book Title || Author || Year Published\nThe Prince || Niccolo Machiavelli || 1532\nPride and Prejudice || Jane Austen || 1813\nAnimal Farm || George Orwell || 1945\nWatership Down || Richard Adams || 1972\nHarry Potter and the Philosophers Stone || J.K Rowling || 1997\n"));
    }





}
