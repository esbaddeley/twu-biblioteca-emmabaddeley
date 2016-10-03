package com.twu.biblioteca.Unit;


import com.twu.biblioteca.MovieShelf;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by emmabaddeley on 02/10/2016.
 */
public class MovieShelfTest {

    private List<String> movies = Arrays.asList("The Big Lebowski || 1998 || Joel Coen || 10", "Sharknado || 2013 || Thunder Levin || 1");
    String movieString = "Name || Year || Director || Rating\nSharknado || 2013 || Thunder Levin || 1\nThe Big Lebowski || 1998 || Joel Coen || 10";

    @Test
    public void returnsAListOfMovies(){
        MovieShelf movieShelf = new MovieShelf(movies);
        assertEquals(movieString, movieShelf.listMovies());
    }
}
