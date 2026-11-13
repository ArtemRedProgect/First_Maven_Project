
package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryServiceTest {

    private LibraryService service;
    private Author author;
    private Reader reader;

    @BeforeEach
    void setUp() {
        service = new LibraryService();
        author = new Author("Test Author", "1990", "bbebe");
        reader = new Reader("Test Reader", "2005");
    }

    @Test
    void addBookTest() {
        Book book = service.addBook(
                "Java Basics",
                author,
                2025,
                5
        );

        assertNotNull(book);
        assertEquals("Java Basics", book.getName());
        assertEquals(2025, book.getYear());
        assertEquals(5, book.getCount());
        assertEquals(1, service.countBooks());
    }

    @Test
    void findExistingBookTest() {
        Book book = service.addBook(
                "Clean Code",
                author,
                2008,
                3
        );

        int id = book.getIdBook();

        Book foundBook = service.findBookById(id);

        assertNotNull(foundBook);
        assertEquals("Clean Code", foundBook.getName());
    }

    @Test
    void findNonExistingBookTest() {
        Book book = service.findBookById(-1);

        assertNull(book);
    }

    @Test
    void countBooksTest() {
        service.addBook("Java", author, 2020, 5);
        service.addBook("Python", author, 2021, 3);
        service.addBook("C++", author, 2022, 2);

        assertEquals(3, service.countBooks());
    }

    @Test
    void borrowBookTest() {
        Book book = service.addBook(
                "Java Programming",
                author,
                2024,
                5
        );

        boolean result = service.borrowBook(
                book.getIdBook(),
                reader
        );

        assertTrue(result);
        assertEquals(4, book.getCount());
        assertTrue(reader.getBooks().containsKey(book.getIdBook()));
    }

    @Test
    void borrowNonExistingBookTest() {
        boolean result = service.borrowBook(-1, reader);

        assertFalse(result);
    }

    @Test
    void borrowBookWithoutCopiesTest() {
        Book book = service.addBook(
                "Java Advanced",
                author,
                2025,
                1
        );

        Reader secondReader = new Reader("Second Reader", "2000");

        boolean firstResult = service.borrowBook(
                book.getIdBook(),
                reader
        );

        boolean secondResult = service.borrowBook(
                book.getIdBook(),
                secondReader
        );

        assertTrue(firstResult);
        assertFalse(secondResult);
        assertEquals(0, book.getCount());
    }

    @Test
    void returnBookTest() {
        Book book = service.addBook(
                "Effective Java",
                author,
                2018,
                3
        );

        service.borrowBook(book.getIdBook(), reader);

        boolean result = service.returnBook(
                book.getIdBook(),
                reader
        );

        assertTrue(result);
        assertEquals(3, book.getCount());
        assertFalse(reader.getBooks().containsKey(book.getIdBook()));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    void addBookWithInvalidNameTest(String name) {
        assertThrows(
                IllegalArgumentException.class,
                () -> service.addBook(name, author, 2025, 5)
        );
    }

    @ParameterizedTest
    @CsvSource({
            "0, 5",
            "-1, 5",
            "2025, 0",
            "2025, -3"
    })
    void addBookWithInvalidYearOrCountTest(int year, int count) {
        assertThrows(
                IllegalArgumentException.class,
                () -> service.addBook(
                        "Test Book",
                        author,
                        year,
                        count
                )
        );
    }
}
