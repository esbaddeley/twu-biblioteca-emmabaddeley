package com.twu.biblioteca.Unit;

import com.twu.biblioteca.BookShelf;
import com.twu.biblioteca.Console;
import com.twu.biblioteca.Menu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by emmabaddeley on 29/09/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class MenuTest {

    @Mock
    Console console;
    BookShelf bookShelf;

    @Test
    public void showAllMenuOptions() {
        Menu menu = new Menu(bookShelf, "1 - List Books", "2 - Checkout a Book","3 - Return a Book", "4 - Quit the Program");
        menu.showOptions(console);
        verify(console).printLine("Please select a Menu Choice");
        verify(console).printLine("1 - List Books");
        verify(console).printLine("2 - Checkout a Book");
        verify(console).printLine("3 - Return a Book");
        verify(console).printLine("4 - Quit the Program");

    }

    @Test
    public void executeMenuOption() {
        Menu menu = new Menu(bookShelf, "1 - List Books", "2 - Checkout a Book","3 - Return a Book", "4 - Quit the Program");

    }



}
