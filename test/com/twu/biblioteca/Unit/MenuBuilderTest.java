package com.twu.biblioteca.Unit;

import com.twu.biblioteca.BookShelf;
import com.twu.biblioteca.Console;
import com.twu.biblioteca.MenuOptions.MenuBuilder;
import com.twu.biblioteca.MenuOptions.MenuOption;
import com.twu.biblioteca.MovieShelf;
import com.twu.biblioteca.User.UserSessionManager;
import org.junit.Test;
import org.mockito.Mock;

import java.io.BufferedReader;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by emmabaddeley on 30/09/2016.
 */
public class MenuBuilderTest {

    @Mock
    BookShelf bookShelf;
    MovieShelf movieShelf;
    Console console;
    BufferedReader reader;
    @Mock UserSessionManager userSessionManager;


    @Test
    public void buildsAMenuOfOptions(){
        MenuBuilder menuBuilder = new MenuBuilder(bookShelf, movieShelf, console, reader, userSessionManager,  "1 - List Books", "2 - Checkout a Book","3 - Return a Book", "4 - List Movies", "5 - Checkout a Movie","6 - Return a Movie", "7 - Log In", "8 - Quit the Program");
        List<? extends MenuOption>  menuOptions = menuBuilder.build();
        assertEquals("1 - List Books", (menuOptions.get(0)).getName());
        assertEquals("2 - Checkout a Book", (menuOptions.get(1)).getName());
        assertEquals("3 - Return a Book", (menuOptions.get(2)).getName());
        assertEquals("4 - List Movies", (menuOptions.get(3)).getName());
        assertEquals("5 - Checkout a Movie", (menuOptions.get(4)).getName());
        assertEquals("6 - Return a Movie", (menuOptions.get(5)).getName());
        assertEquals("7 - Log In", (menuOptions.get(6)).getName());
        assertEquals("8 - Quit the Program", (menuOptions.get(7)).getName());
    }




}
