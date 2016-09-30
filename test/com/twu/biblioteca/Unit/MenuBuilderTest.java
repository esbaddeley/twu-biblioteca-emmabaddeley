package com.twu.biblioteca.Unit;

import com.twu.biblioteca.BookShelf;
import com.twu.biblioteca.Console;
import com.twu.biblioteca.MenuOptions.MenuBuilder;
import com.twu.biblioteca.MenuOptions.MenuOption;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by emmabaddeley on 30/09/2016.
 */
public class MenuBuilderTest {

    @Mock
    BookShelf bookShelf;
    Console console;


    @Test
    public void buildsAMenuOfOptions(){
        MenuBuilder menuBuilder = new MenuBuilder(bookShelf, console,  "1 - List Books", "2 - Checkout a Book","3 - Return a Book", "4 - Quit the Program");
        List<? extends MenuOption>  menuOptions = menuBuilder.build();
        assertEquals("1 - List Books", (menuOptions.get(0)).getName());
    }




}
