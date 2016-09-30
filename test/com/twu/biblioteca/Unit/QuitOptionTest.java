package com.twu.biblioteca.Unit;

import com.twu.biblioteca.BookShelf;
import com.twu.biblioteca.Console;
import com.twu.biblioteca.MenuOptions.ListOption;
import com.twu.biblioteca.MenuOptions.QuitOption;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by emmabaddeley on 30/09/2016.
 */
@RunWith(MockitoJUnitRunner.class)

public class QuitOptionTest {

    @Mock
    Console console;
    BookShelf bookShelf;

    @Test
    public void printsAQuitMessage (){
        QuitOption quitOption = new QuitOption("4 - Quit the Program", console);
        quitOption.run();
        verify(console).printLine("Quitting the Program");
    }
}
