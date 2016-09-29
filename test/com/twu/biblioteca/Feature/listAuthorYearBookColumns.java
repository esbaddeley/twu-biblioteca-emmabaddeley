package com.twu.biblioteca.Feature;

import com.twu.biblioteca.BibliotecaApp;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.assertEquals;

/**
 * Created by emmabaddeley on 29/09/2016.
 */
public class listAuthorYearBookColumns {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void ListBooks() {
        BibliotecaApp.main();
        assertEquals("Welcome to the Biblioteca App\nBook Title || Author || Year Published\nThe Prince || Niccolo Machiavelli || 1532\nPride and Prejudice || Jane Austen || 1813\nAnimal Farm || George Orwell || 1945\nWatership Down || Richard Adams || 1972\nHarry Potter and the Philosophers Stone || J.K Rowling || 1997\n", systemOutRule.getLog());
    }
}
