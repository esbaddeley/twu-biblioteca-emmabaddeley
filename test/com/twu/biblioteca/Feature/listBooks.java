package com.twu.biblioteca.Feature;

import com.twu.biblioteca.BibliotecaApp;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.assertEquals;

/**
 * Created by emmabaddeley on 29/09/2016.
 */
public class listBooks {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void ListBooks() {
        BibliotecaApp.main();
        assertEquals("Welcome to the Biblioteca App\nThe Prince\nPride and Prejudice\nAnimal Farm\nWatership Down\nHarry Potter and the Philosophers Stone\n", systemOutRule.getLog());
    }





}
