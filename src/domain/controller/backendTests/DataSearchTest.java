package domain.controller.backendTests;

import domain.controller.search.BookSearch;
import domain.controller.useCases.BookController;
import domain.controller.useCases.CustomerController;
import domain.models.address.Address;
import domain.models.address.Apartment;
import domain.models.address.House;
import domain.models.book.Book;
import domain.models.book.BookType;
import domain.models.book.bookEntities.Author;
import domain.models.book.bookEntities.Description;
import domain.models.book.bookEntities.Measurement;
import domain.models.book.bookEntities.Publisher;
import domain.models.customer.Customer;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;

public class DataSearchTest {
    // All data generated by ChatGPT reasoning model -> edited by EmilNordstroem
    public static void main(String[] args) {
        // Addresses
        List<Address> addresses = List.of(
                new Apartment("Main St", "10", "1000", "Aarhus", "Denmark", "3", "12"),
                new House("Oak Ave", "15", "2000", "Copenhagen", "Denmark", "1234"),
                new Apartment("Pine St", "20", "3000", "Odense", "Denmark", "2", "8"),
                new House("Elm Rd", "25", "4000", "Aalborg", "Denmark", "5678"),
                new Apartment("Maple Dr", "30", "5000", "Esbjerg", "Denmark", "1", "5")
        );

        // Authors & Publishers
        Author author1 = BookController.createAuthor("author1@example.com", "John", "Doe");
        Author author2 = BookController.createAuthor("author2@example.com", "Jane", "Smith");
        Author author3 = BookController.createAuthor("author3@example.com", "Alice", "Johnson");
        Author author4 = BookController.createAuthor("author4@example.com", "Bob", "Brown");
        Author author5 = BookController.createAuthor("author5@example.com", "Charlie", "Davis");
        Author author6 = BookController.createAuthor("author6@example.com", "Diana", "Evans");
        Author author7 = BookController.createAuthor("author7@example.com", "Ethan", "Fisher");

        Publisher publisher1 = BookController.createPublisher("publisher1@example.com", "Penguin Books");
        Publisher publisher2 = BookController.createPublisher("publisher2@example.com", "HarperCollins");
        Publisher publisher3 = BookController.createPublisher("publisher3@example.com", "Simon & Schuster");
        Publisher publisher4 = BookController.createPublisher("publisher4@example.com", "Macmillan");
        Publisher publisher5 = BookController.createPublisher("publisher5@example.com", "Hachette");
        Publisher publisher6 = BookController.createPublisher("publisher6@example.com", "Random House");
        Publisher publisher7 = BookController.createPublisher("publisher7@example.com", "Bloomsbury");

        // Books
        List<Book> books = List.of(
                BookController.createBook("ISBN001", new Description(BookType.PAPERBACK, "Book 1 Desc", Year.now(), "500"), new Measurement(10, 20, 2), author1, publisher1, 19.99),
                BookController.createBook("ISBN002", new Description(BookType.HARDCOVER, "Book 2 Desc", Year.now(), "600"), new Measurement(12, 22, 3), author2, publisher2, 24.99),
                BookController.createBook("ISBN003", new Description(BookType.EBOOK, "Book 3 Desc", Year.now(), "300"), new Measurement(11, 21, 2.5), author3, publisher3, 29.99),
                BookController.createBook("ISBN004", new Description(BookType.PAPERBACK, "Book 4 Desc", Year.now(), "450"), new Measurement(13, 23, 3.2), author4, publisher4, 15.99),
                BookController.createBook("ISBN005", new Description(BookType.HARDCOVER, "Book 5 Desc", Year.now(), "700"), new Measurement(9, 19, 1.8), author5, publisher5, 22.99),
                BookController.createBook("ISBN006", new Description(BookType.EBOOK, "Book 6 Desc", Year.now(), "350"), new Measurement(10, 18, 2.2), author1, publisher2, 18.99),
                BookController.createBook("ISBN007", new Description(BookType.PAPERBACK, "Book 7 Desc", Year.now(), "550"), new Measurement(11, 20, 2.6), author2, publisher3, 27.99),
                BookController.createBook("ISBN008", new Description(BookType.HARDCOVER, "Book 8 Desc", Year.now(), "800"), new Measurement(12, 24, 3.4), author3, publisher4, 31.99),
                BookController.createBook("ISBN009", new Description(BookType.EBOOK, "Book 9 Desc", Year.now(), "400"), new Measurement(13, 22, 3.1), author4, publisher5, 26.99),
                BookController.createBook("ISBN010", new Description(BookType.PAPERBACK, "Book 10 Desc", Year.now(), "480"), new Measurement(14, 25, 3.6), author5, publisher1, 35.99),
                BookController.createBook("ISBN021", new Description(BookType.PAPERBACK, "Book 21 Desc", Year.now(), "410"), new Measurement(14, 22, 2.9), author6, publisher6, 22.99),
                BookController.createBook("ISBN022", new Description(BookType.HARDCOVER, "Book 22 Desc", Year.now(), "580"), new Measurement(15, 25, 3.7), author6, publisher7, 27.99),
                BookController.createBook("ISBN023", new Description(BookType.EBOOK, "Book 23 Desc", Year.now(), "310"), new Measurement(11, 19, 2.3), author7, publisher6, 18.99),
                BookController.createBook("ISBN024", new Description(BookType.PAPERBACK, "Book 24 Desc", Year.now(), "500"), new Measurement(12, 21, 2.8), author7, publisher7, 23.99),
                BookController.createBook("ISBN025", new Description(BookType.HARDCOVER, "Book 25 Desc", Year.now(), "670"), new Measurement(14, 24, 3.4), author2, publisher3, 29.99),
                BookController.createBook("ISBN026", new Description(BookType.EBOOK, "Book 26 Desc", Year.now(), "340"), new Measurement(13, 23, 3.2), author3, publisher4, 21.99),
                BookController.createBook("ISBN027", new Description(BookType.PAPERBACK, "Book 27 Desc", Year.now(), "560"), new Measurement(11, 20, 2.9), author4, publisher5, 25.99),
                BookController.createBook("ISBN028", new Description(BookType.HARDCOVER, "Book 28 Desc", Year.now(), "740"), new Measurement(15, 26, 3.9), author5, publisher6, 31.99),
                BookController.createBook("ISBN029", new Description(BookType.EBOOK, "Book 29 Desc", Year.now(), "380"), new Measurement(12, 22, 3.1), author6, publisher7, 26.49),
                BookController.createBook("ISBN030", new Description(BookType.PAPERBACK, "Book 30 Desc", Year.now(), "590"), new Measurement(13, 24, 3.6), author7, publisher1, 28.99)
        );

        // Customers
        List<Customer> customers = List.of(
                CustomerController.createCustomer("Alice", "White", LocalDate.of(1990, 5, 15), "alice@example.com", "1234567890", addresses.get(0), "password1"),
                CustomerController.createCustomer("Bob", "Green", LocalDate.of(1985, 8, 22), "bob@example.com", "0987654321", addresses.get(1), "password2"),
                CustomerController.createCustomer("Charlie", "Black", LocalDate.of(1992, 3, 10), "charlie@example.com", "1122334455", addresses.get(2), "password3"),
                CustomerController.createCustomer("David", "Blue", LocalDate.of(1995, 7, 18), "david@example.com", "2233445566", addresses.get(3), "password4"),
                CustomerController.createCustomer("Eve", "Yellow", LocalDate.of(1988, 12, 5), "eve@example.com", "3344556677", addresses.get(4), "password5"),
                CustomerController.createCustomer("Frank", "Orange", LocalDate.of(1993, 11, 30), "frank@example.com", "4455667788", addresses.get(0), "password6"),
                CustomerController.createCustomer("Grace", "Pink", LocalDate.of(1991, 9, 25), "grace@example.com", "5566778899", addresses.get(1), "password7"),
                CustomerController.createCustomer("Hank", "Purple", LocalDate.of(1997, 6, 14), "hank@example.com", "6677889900", addresses.get(2), "password8"),
                CustomerController.createCustomer("Ivy", "Brown", LocalDate.of(1994, 2, 28), "ivy@example.com", "7788990011", addresses.get(3), "password9"),
                CustomerController.createCustomer("Jack", "Gray", LocalDate.of(1986, 4, 12), "jack@example.com", "8899001122", addresses.get(4), "password10")
        );
        //==============================================================================================
    // Dataset test 1 - passed
        /* Guide to understand performances: first digit [followed by number of digits]
            First performance: 8-9[6]ns -> linear search
            Second performance: 2-4[6]ns -> Parallel search
            Third performance:  1-2[6]ns -> Parallel search (recursion)
         */
        long start = System.nanoTime();
        List<Book> searchResult = new BookSearch().search("Book 6 Desc");
        long end = System.nanoTime();
        System.out.println(end - start);
        for(Book foundBook : searchResult){
            System.out.println(foundBook.toString());
        }
    }
}
