package com.twu.biblioteca.Unit;

import com.sun.tools.javac.util.List;
import com.twu.biblioteca.Exceptions.NoUserException;
import com.twu.biblioteca.User.User;
import com.twu.biblioteca.User.UserSessionManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by emmabaddeley on 03/10/2016.
 */
@RunWith(MockitoJUnitRunner.class)

public class UserSessionManagerTest {

    @Mock
    User user;

    ArrayList<User> users = new ArrayList<>();


    @Before
    public void createUsers(){
        users.add(user);
        users.add(user);
    }

    @Test
    public void canLogInAUser() throws NoUserException {
        UserSessionManager userSessionManager = new UserSessionManager(users);
        when(user.credentialsMatch("123-4567", "password")).thenReturn(true);
        userSessionManager.logIn("123-4567", "password");
        assertEquals(userSessionManager.getCurrentUser(), user);
    }

    @Test
    public void successfulLogInMessage() throws NoUserException {
        UserSessionManager userSessionManager = new UserSessionManager(users);
        when(user.credentialsMatch("123-4567", "password")).thenReturn(true);
        when(user.getNumber()).thenReturn("123-4567");
        assertEquals(userSessionManager.logIn("123-4567", "password"), "123-4567");
    }

    @Test
    public void canLogOutAUser() throws NoUserException {
        UserSessionManager userSessionManager = new UserSessionManager(users);
        userSessionManager.logOut();
        assertEquals(userSessionManager.getCurrentUser(), null);
    }


}
