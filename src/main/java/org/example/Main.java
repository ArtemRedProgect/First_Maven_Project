
package org.example;

public class Main {

    public static void main(String[] args) {

        LibraryService service = new LibraryService();
        Author author = new Author("J. K. Rowling", "1965", "Harry");

        Book book1 = service.addBook(
                "Harry Potter",
                author,
                1997,
                5
        );

        Book book2 = service.addBook(
                "Fantastic Beasts",
                author,
                2001,
                3
        );

        System.out.println("=== БИБЛИОТЕКА ===");

        System.out.println("Книга: " + book1.getName());
        System.out.println("ID: " + book1.getIdBook());
        System.out.println("Количество: " + book1.getCount());

        System.out.println();

        System.out.println("Книга: " + book2.getName());
        System.out.println("ID: " + book2.getIdBook());
        System.out.println("Количество: " + book2.getCount());

        System.out.println("\nВсего разных книг: " + service.countBooks());
        Reader reader = new Reader("Ivan Ivanov", "2005");

        boolean borrowed = service.borrowBook(book1.getIdBook(), reader);

        System.out.println("\n=== ВЫДАЧА КНИГИ ===");
        System.out.println("Книга выдана: " + borrowed);
        System.out.println("Осталось экземпляров: " + book1.getCount());

        boolean returned = service.returnBook(book1.getIdBook(), reader);

        System.out.println("\n=== ВОЗВРАТ КНИГИ ===");
        System.out.println("Книга возвращена: " + returned);
        System.out.println("Осталось экземпляров: " + book1.getCount());

        Book foundBook = service.findBookById(book1.getIdBook());

        System.out.println("\n=== ПОИСК КНИГИ ===");

        if (foundBook != null) {
            System.out.println("Найдена книга: " + foundBook.getName());
        } else {
            System.out.println("Книга не найдена");
        }

        Book missingBook = service.findBookById(-1);

        System.out.println("\nНесуществующая книга: " + missingBook);
    }
}
