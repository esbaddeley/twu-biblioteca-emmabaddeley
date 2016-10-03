package com.twu.biblioteca.Unit;

import com.twu.biblioteca.Console;
import com.twu.biblioteca.Exceptions.NoUserException;
import com.twu.biblioteca.MenuOptions.LogInOption;
import com.twu.biblioteca.MenuOptions.LogOutOption;
import com.twu.biblioteca.User.User;
import com.twu.biblioteca.User.UserSessionManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.BufferedReader;
import java.io.IOException;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by emmabaddeley on 03/10/2016.
 */
@RunWith(MockitoJUnitRunner.class)

public class LogOutOptionTest {

    @Mock Console console;

    @Mock UserSessionManager userSessionManager;

    @Mock BufferedReader reader;

    @Mock User user;


    @Test
    public void logsInTheUser() throws IOException, NoUserException {
        LogOutOption logOutOption = new LogOutOption("8 - Log Out", console, userSessionManager, reader);
        logOutOption.run();
        verify(userSessionManager).logOut();
    }

    @Test
    public void returnsASuccessfulLogOutMessage() throws NoUserException, IOException {
        LogOutOption logOutOption = new LogOutOption("8 - Log Out", console, userSessionManager, reader);
        logOutOption.run();
        verify(console).printLine("Successfully logged out");
    }
}
