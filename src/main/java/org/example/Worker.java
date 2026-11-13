package org.example;

import java.util.Scanner;

public class Worker extends People {
    Scanner scan = new Scanner(System.in);
    static int id_counter = 0;
    private String status;
    private int id_worker;

    public Worker(String fio, String birthday, String status) {
        super(fio, birthday);
        this.status = status;
        id_counter++;
        id_worker = id_counter;
    }

    public int getIdWorker() {
        return id_worker;
    }

    public String getStatus() {
        return status;
    }

    public void checking_book() {
        System.out.println("Наличие книг в библиотеке: ");
        System.out.println(Book.books.size());
        System.out.println("Книги: " + Book.books);
    }
}