
package org.example;
import java.util.Map;
import java.util.HashMap;

public class LibraryService {
    private final Map<Integer, Book> books = new HashMap<>();

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

    public Book findBookById(int id) {
        return books.get(id);
    }

    public int countBooks() {
        return books.size();
    }

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
