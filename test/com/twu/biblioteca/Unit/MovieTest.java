package com.twu.biblioteca.Unit;


import com.twu.biblioteca.Book;
import com.twu.biblioteca.Exceptions.NoBookException;
import com.twu.biblioteca.Movie;
import com.twu.biblioteca.Exceptions.NoMovieException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by emmabaddeley on 03/10/2016.
 */
public class MovieTest {

    String detailString = "The Big Lebowski || 1998 || Joel Coen || 10";

    @Test
    public void returnsTheDetailsString(){
        Movie movie = new Movie(detailString);
        assertEquals(detailString, movie.getDetails());
    }

    @Test
    public void movieCanBeCheckedOut() throws NoMovieException {
        Movie movie = new Movie(detailString);
        movie.checkOut();
        assertEquals(false, movie.isCheckedIn());
    }

    @Test
    public void movieCanBeReturned() throws NoMovieException {
        Movie movie = new Movie(detailString);
        movie.checkOut();
        movie.returnMovie();
        assertEquals(true, movie.isCheckedIn());
    }
}
