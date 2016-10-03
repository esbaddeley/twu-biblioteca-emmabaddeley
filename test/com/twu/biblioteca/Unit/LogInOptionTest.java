package com.twu.biblioteca.Unit;

import com.twu.biblioteca.Console;
import com.twu.biblioteca.Exceptions.NoUserException;
import com.twu.biblioteca.MenuOptions.LogInOption;
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
public class LogInOptionTest {


    @Mock Console console;

    @Mock UserSessionManager userSessionManager;

    @Mock
    BufferedReader reader;

    @Test
    public void promptsForNumberAndPassword() throws IOException {
        when(reader.readLine()).thenReturn("123-4567", "password");
        LogInOption logInOption = new LogInOption("7 - Log In", console, userSessionManager, reader);
        logInOption.run();
        verify(console).printLine("Please enter your library number");
        verify(console).printLine("Please enter your password");
    }

    @Test
    public void logsInTheUser() throws IOException, NoUserException {
        when(reader.readLine()).thenReturn("123-4567", "password");
        LogInOption logInOption = new LogInOption("7 - Log In", console, userSessionManager, reader);
        logInOption.run();
        verify(userSessionManager).logIn("123-4567", "password");
    }

    @Test
    public void returnsASuccessfulLogInMessage() throws NoUserException, IOException {
        when(reader.readLine()).thenReturn("123-4567", "password");
        when(userSessionManager.logIn("123-4567", "password")).thenReturn("123-4567");
        LogInOption logInOption = new LogInOption("7 - Log In", console, userSessionManager, reader);
        logInOption.run();
        verify(console).printLine("Successfully logged in as 123-4567");

    }

}
