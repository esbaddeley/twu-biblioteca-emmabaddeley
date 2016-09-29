package com.twu.biblioteca.Unit;

import com.twu.biblioteca.Menu;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by emmabaddeley on 29/09/2016.
 */
public class MenuTest {

    @Test
    public void getListBookOption() throws Exception {
        Menu menu = new Menu("List Books");
        assertEquals(true, menu.getOptions().contains("List Books"));

    }

    @Test
    public void matchOption() throws Exception {
        Menu menu = new Menu("List Books");
        assertEquals(menu.matchOption(1), "List Books");
    }
}
