package com.twu.biblioteca.Unit;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Console;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

/**
 * Created by emmabaddeley on 20/09/2016.
 */
@RunWith(MockitoJUnitRunner.class)

public class BibliotecaAppTest {

    @Mock
    Console console;


    @Test
    public void printsAWelcomeMessage() {
        BibliotecaApp app = new BibliotecaApp(console);
        app.run();
        verify(console).printLine("Welcome to the Biblioteca App");
    }

}