package org.example;

/**
 * Книга, хранящаяся в библиотеке.
 */
public class Book {
    private static int idCounter = 0;
    private final int idBook;
    private final String name;
    private final Author author;
    private final int year;
    private int count;

    public Book(String name, Author author, int year, int count) {
        idCounter++;
        this.idBook = idCounter;
        this.name = name;
        this.author = author;
        this.year = year;
        this.count = count;
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