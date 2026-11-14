package org.example;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

/**
 * Сервис для управления библиотекой: добавление книг,
 * выдача и возврат книг читателям.
 */
public class LibraryService {
    private final Map<Integer, Book> books = new HashMap<>();

    /**
     * Добавляет новую книгу в библиотеку.
     *
     * @param name   название книги, не должно быть пустым
     * @param author автор книги, не может быть null
     * @param year   год издания, должен быть положительным числом
     * @param count  количество экземпляров, должно быть положительным числом
     * @return созданная и сохранённая книга
     * @throws IllegalArgumentException если имя пустое, автор null, год или количество не положительны
     */
    public Book addBook(String name, Author author, int year, int count) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название книги не может быть пустым");
        }
        if (author == null) {
            throw new IllegalArgumentException("Автор не может быть null");
        }
        if (year <= 0) {
            throw new IllegalArgumentException("Год издания должен быть положительным");
        }
        if (count <= 0) {
            throw new IllegalArgumentException("Количество книг должно быть положительным");
        }
        Book book = new Book(name, author, year, count);
        books.put(book.getIdBook(), book);
        return book;
    }

    /**
     * Ищет книгу по её идентификатору.
     *
     * @param id идентификатор книги
     * @return найденная книга, либо null, если книги с таким id нет
     */
    public Book findBookById(int id) {
        return books.get(id);
    }

    /**
     * Возвращает количество книг, хранящихся в библиотеке.
     *
     * @return количество книг
     */
    public int countBooks() {
        return books.size();
    }

    /**
     * Возвращает все книги, хранящиеся в библиотеке.
     *
     * @return коллекция всех книг
     */
    public Collection<Book> getAllBooks() {
        return books.values();
    }

    /**
     * Выдаёт книгу читателю, если это возможно.
     * Выдача не происходит (возвращается false), если:
     * читатель равен null, книга с таким id не найдена,
     * свободных экземпляров книги нет, либо читатель уже взял эту книгу ранее.
     *
     * @param bookId идентификатор книги
     * @param reader читатель, которому выдаётся книга
     * @return true, если книга успешно выдана, иначе false
     */
    public boolean borrowBook(int bookId, Reader reader) {
        if (reader == null) {
            return false;
        }
        Book book = books.get(bookId);
        if (book == null) {
            return false;
        }

        if (book.getCount() <= 0) {
            return false;
        }

        if (reader.getBooks().containsKey(bookId)) {
            return false;
        }

        reader.getBooks().put(bookId, book);

        book.setCount(book.getCount() - 1);

        return true;
    }

    /**
     * Принимает книгу обратно от читателя.
     * Возврат не происходит (возвращается false), если читатель равен null
     * либо у читателя нет книги с таким id.
     *
     * @param bookId идентификатор книги
     * @param reader читатель, который возвращает книгу
     * @return true, если книга успешно возвращена, иначе false
     */
    public boolean returnBook(int bookId, Reader reader) {
        if (reader == null) {
            return false;
        }
        Book borrowedBook = reader.getBooks().get(bookId);
        if (borrowedBook == null) {
            return false;
        }
        reader.getBooks().remove(bookId);
        borrowedBook.setCount(borrowedBook.getCount() + 1);
        return true;
    }
}