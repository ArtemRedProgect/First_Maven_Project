package org.example;

import java.util.ArrayList;
import java.util.List;
/**
 * Автор книг в библиотеке.
 */
public class Author extends People {
    private static int idCounter = 0;
    private final int idAuthor;
    private final String flashBio;
    private final List<Book> books = new ArrayList<>();

    public Author(String fio, String birthday, String flashBio) {
        super(fio, birthday);
        this.flashBio = flashBio;
        idCounter++;
        this.idAuthor = idCounter;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public String getFlashBio() {
        return flashBio;
    }

    public List<Book> getBooks() {
        return books;
    }

    public String getFio() {
        return this.fio;
    }
}