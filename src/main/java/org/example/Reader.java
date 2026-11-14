package org.example;

import java.util.HashMap;
import java.util.Map;

/**
 * Читатель библиотеки, хранит список взятых книг.
 */
public class Reader extends People {
    private static int idCounter = 0;
    private final int myId;
    private final Map<Integer, Book> books = new HashMap<>();

    public Reader(String fio, String birthday) {
        super(fio, birthday);
        idCounter++;
        this.myId = idCounter;
    }

    public int getMyId() {
        return myId;
    }

    public Map<Integer, Book> getBooks() {
        return books;
    }
}