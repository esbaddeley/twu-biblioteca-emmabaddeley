package com.twu.biblioteca;

import com.sun.deploy.util.StringUtils;
import com.twu.biblioteca.Exceptions.NoMovieException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by emmabaddeley on 02/10/2016.
 */
public class MovieShelf {

    private static final Object COLUMNHEADERS = "Name || Year || Director || Rating\n";
    private Map<String, Movie> movies = new HashMap<>();

    public MovieShelf(List<String> moviesToAdd) {
        createMovieShelf(moviesToAdd);
    }

    public String listMovies() {
        List<String> movieList = new ArrayList<>();
        for (Movie movie : movies.values()) {
            if (movie.isCheckedIn()) {
                movieList.add(movie.getDetails());
            }
        }
        return formatMovieList(movieList);
    }

    private String formatMovieList(List<String> movieList) {
        return COLUMNHEADERS + formatOptions(movieList);
    }

    private String formatOptions(List<String> moviesToFormat) {
        return StringUtils.join(moviesToFormat, "\n");
    }

    private void createMovieShelf(List<String> moviesToAdd) {
        for( String movieDetails : moviesToAdd) {
            Movie newMovie = new Movie(movieDetails);
            movies.put(newMovie.getName(), newMovie);
        }
    }

    public void checkOutMovie(String movieToCheckout) throws NoMovieException {
        findMovie(movieToCheckout).checkOut();
    }

    private Movie findMovie(String movieToCheckout) throws NoMovieException {
        Movie movie = movies.get(movieToCheckout);
        if (movie != null) {
            return movie;
        }
        throw new NoMovieException();
    }

    public void returnMovie(String sharknado) {
        throw new UnsupportedOperationException();
    }
}
