package com.twu.biblioteca.Unit;

import com.twu.biblioteca.BookShelf;
import com.twu.biblioteca.Console;
import com.twu.biblioteca.Menu;
import com.twu.biblioteca.MenuOptions.CheckOutOption;
import com.twu.biblioteca.MenuOptions.MenuOption;
import com.twu.biblioteca.MenuOptions.MenuBuilder;
import com.twu.biblioteca.MenuOptions.MenuOption;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.util.ArrayList;
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
    @Mock CheckOutOption checkoutOption;

    public List<MenuOption> menuOptions = new ArrayList<>();

    @Before
    public void initialize(){
        menuOptions.add(menuOption);
        menuOptions.add(menuOption);
        menuOptions.add(menuOption);
        menuOptions.add(menuOption);
        menuOptions.add(menuOption);
        menuOptions.add(menuOption);
        menuOptions.add(menuOption);
        menuOptions.add(menuOption);
        menuOptions.add(menuOption);
    }


    @Test
    public void showAllMenuOptions() {
        Menu menu = new Menu(menuOptions);
        when(menuOption.getName()).thenReturn("1 - List Books", "2 - Checkout a Book", "3 - Return a Book", "4 - List Movies", "5 - Checkout a Movie", "6 - Return a Movie", "7 - Log In", "8 - Log Out",  "9 - Quit the Program");
        menu.showOptions(console);
        verify(console).printLine("Please select a Menu Choice");
        verify(console).printLine("1 - List Books");
        verify(console).printLine("2 - Checkout a Book");
        verify(console).printLine("3 - Return a Book");
        verify(console).printLine("4 - List Movies");
        verify(console).printLine("5 - Checkout a Movie");
        verify(console).printLine("6 - Return a Movie");
        verify(console).printLine("7 - Log In");
        verify(console).printLine("8 - Log Out");
        verify(console).printLine("9 - Quit the Program");

    }

    @Test
    public void executeMenuOption() {
        Menu menu = new Menu(menuOptions);
        menu.executeOption("1", console);
        verify(menuOption).run();
    }



}

//  "2 - Checkout a Book","3 - Return a Book", "4 - Quit the Program"
