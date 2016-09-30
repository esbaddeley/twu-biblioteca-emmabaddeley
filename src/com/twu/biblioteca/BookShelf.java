package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by emmabaddeley on 29/09/2016.
 */
public class BookShelf {

    private Map<String,Book> books = new HashMap<>();

    public BookShelf(List<String> booksToAdd) {
        createBookShelf(booksToAdd);
    }

    public List<String> listBooks() {
        List<String> bookList = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.isCheckedIn()) {
                bookList.add(book.getDetails());
            }
        }
        return bookList;
    }

    public void checkOutBook(String title) throws NoBookException {
        findBook(title).checkOut();
    }

    public void returnBook(String title) throws NoBookException {
            findBook(title).returnBook();
    }

    private void createBookShelf(List<String> booksToAdd){
        for( String bookDetails : booksToAdd) {
            Book newBook = new Book(bookDetails);
            books.put(newBook.getTitle(), newBook);
        }
    }
    private Book findBook(String title) throws NoBookException {
        Book book = books.get(title);
        if (book != null) {
            return book;
        }
        throw new NoBookException();
    };

    private void findAndReturnBook(String title) {
    }


}
