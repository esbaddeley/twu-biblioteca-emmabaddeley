package com.twu.biblioteca;

import java.util.List;

/**
 * Created by emmabaddeley on 29/09/2016.
 */
public class BookShelf {

    private List<String> books;

    public BookShelf(List<String> books) {
    this.books = books;
    }

    public List<String> listBooks() {
        return books;
    }

    public void checkOutBook(String s) {
        throw new UnsupportedOperationException();
    }

    public boolean hasBook(String s) {
        throw new UnsupportedOperationException();
    }
}
