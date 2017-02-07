package com.twu.biblioteca.Unit;

import com.twu.biblioteca.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.mockito.Mockito.*;

/**
 * Created by emmabaddeley on 20/09/2016.
 */
@RunWith(MockitoJUnitRunner.class)

public class BibliotecaTest {

    private String bookString =  "Book Title || Author || Year Published\nAnimal Farm || George Orwell || 1945\nHarry Potter and the Philosophers Stone || J.K Rowling || 1997\nThe Prince || Niccolo Machiavelli || 1532\nWatership Down || Richard Adams || 1972\nPride and Prejudice || Jane Austen || 1813";

    @Mock Console console;
    @Mock Menu menu;
    @Mock BufferedReader reader;

    BookShelf bookShelf = mock(BookShelf.class);
    Biblioteca biblioteca;


    @Before
    public void initialize(){
        biblioteca = new Biblioteca(console, menu, reader);
    }

    @Test
    public void getUserInput() throws IOException {
        when(reader.readLine()).thenReturn("9");
        biblioteca.run();
        verify(reader).readLine();
    }










}