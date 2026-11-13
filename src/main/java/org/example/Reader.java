package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Reader extends People {
    private static int idCounter = 0;
    private int myId;
    private Map<Integer, Book> r_books = new HashMap<>();

    public Reader(String fio, String birthday) {
        super(fio, birthday);
        idCounter++;
        this.myId = idCounter;
    }

    public int getMyId() {
        return myId;
    }

    public Map<Integer, Book> getRBooks() {
        return r_books;
    }

    public void add_book() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ваш личный ID: " + this.myId);
        System.out.print("Введите id книги, которую хотите взять: ");
        int bookId = scanner.nextInt();

        if (Book.books.containsKey(bookId)) {
            Book selectedBook = Book.books.get(bookId);
            this.r_books.put(bookId, selectedBook);
            System.out.println("Книга успешно добавлена к вашему читательскому листу!");
        } else {
            System.out.println("Ошибка: Книга с ID " + bookId + " не найдена в библиотеке.");
        }
    }

    public Map<Integer, Book> getBooks() {
        return r_books;
    }

    public void del_book() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ваш личный ID: " + this.myId);
        System.out.print("Введите id книги, которую хотите отдать: ");
        int bookId = scanner.nextInt();

        if (this.r_books.containsKey(bookId)) {
            this.r_books.remove(bookId);
            System.out.println("Книга успешно удалена из вашего читательского списка!");
        } else {
            System.out.println("Ошибка: Книга с ID " + bookId + " отсутствует в вашем списке.");
        }
    }
}