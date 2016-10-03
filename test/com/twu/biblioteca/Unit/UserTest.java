package com.twu.biblioteca.Unit;

import com.twu.biblioteca.User.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by emmabaddeley on 03/10/2016.
 */
public class UserTest {

    @Test
    public void matchesCredentials(){
        User user = new User("123-4567", "password");
        assertEquals(true, user.credentialsMatch("123-4567", "password"));
    }

}
