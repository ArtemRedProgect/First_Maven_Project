package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Author extends People {
    private static int idCounter = 0;
    private int idAuthor;
    private String flashBio;
    private List<Book> books = new ArrayList<>();

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

    public void newBook() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите название новой книги: ");
        String name = scanner.nextLine();

        System.out.print("Введите год издания книги: ");
        int year = scanner.nextInt();

        System.out.print("Введите количество поставляемых книг: ");
        int count = scanner.nextInt();

        this.books.add(new Book(name, this, year, count));

        System.out.println("Книга \"" + name + "\" успешно добавлена автору!");
    }

    public String getFio() {
        return this.fio;
    }
}