package com.twu.biblioteca;

import com.sun.deploy.util.StringUtils;

import java.util.Arrays;

/**
 * Created by emmabaddeley on 03/10/2016.
 */
public class Movie {

    private final String name;
    private String year;
    private String director;
    private String rating;
    private boolean checkedIn = true;

    public Movie(String detailString){
        String[] details = detailString.split(" \\|\\| ");
        this.name = details[0];
        this.year = details[1];
        this.director = details[2];
        this.rating = details[3];
    }

    public String getDetails() {
        return StringUtils.join((Arrays.asList(name, year, director, rating)), " || ");
    }

    public String getName() {
        return name;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public void checkOut() {
        throw new UnsupportedOperationException();
    }
}
