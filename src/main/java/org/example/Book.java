package org.example;

import java.util.HashMap;
import java.util.Map;

public class Book {
    private static int idCounter = 0;
    private int idBook;
    private String name;
    private Author author;
    private int year;
    private int count;
    public static Map<Integer, Book> books = new HashMap<>();

    public Book(String name, Author author, int year, int count) {
        idCounter++;
        this.idBook = idCounter;
        this.name = name;
        this.author = author;
        this.year = year;
        this.count = count;
        books.put(this.idBook, this);
    }

    public int getIdBook() {
        return idBook;
    }

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ID=" + idBook +
                ", название='" + name + '\'' +
                ", автор=" + (author != null ? author.getFio() : "неизвестен") +
                ", год=" + year +
                ", количество=" + count;
    }
}