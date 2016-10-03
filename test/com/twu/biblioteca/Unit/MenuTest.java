package com.twu.biblioteca.Unit;

import com.twu.biblioteca.BookShelf;
import com.twu.biblioteca.Console;
import com.twu.biblioteca.Menu;
import com.twu.biblioteca.MenuOptions.ListOption;
import com.twu.biblioteca.MenuOptions.MenuBuilder;
import com.twu.biblioteca.MenuOptions.MenuOption;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by emmabaddeley on 29/09/2016.
 */
@RunWith(MockitoJUnitRunner.class)

public class MenuTest {

    @Mock Console console;
    @Mock BookShelf bookShelf;
    @Mock MenuOption menuOption;

    public List<MenuOption> menuOptions = Arrays.asList(menuOption, menuOption);



    @Test
    public void showAllMenuOptions() {
        System.out.print(menuOptions);
        Menu menu = new Menu(menuOptions);
        when(menuOption.getName()).thenReturn("1 - List Books");
        menu.showOptions(console);
        verify(console).printLine("Please select a Menu Choice");
        verify(console).printLine("1 - List Books");
        verify(console).printLine("2 - Checkout a Book");
        verify(console).printLine("3 - Return a Book");
        verify(console).printLine("4 - List Movies");
        verify(console).printLine("5 - Checkout a Movie");
        verify(console).printLine("6 - Quit the Program");

    }

    @Test
    public void executeMenuOption() {
        Menu menu = new Menu(menuOptions);
        menu.executeOption("1", console);
    }



}

//  "2 - Checkout a Book","3 - Return a Book", "4 - Quit the Program"
