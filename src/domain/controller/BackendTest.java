package domain.controller;

import domain.models.address.Apartment;
import domain.models.book.Book;
import domain.models.book.BookType;
import domain.models.book.bookEntities.Author;
import domain.models.book.bookEntities.BookEntity;
import domain.models.book.bookEntities.Measurement;
import domain.models.book.bookEntities.Publisher;
import domain.models.customer.Customer;
import domain.models.inventory.Stock;
import domain.models.order.Order;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;

public class BackendTest {
    public static void main(String[] args) {
        // First backend test -> passed
        Apartment address = new Apartment("TestStreet",  "10",
                "1234", "TestCity", "TestCountry",
                "1", "6");

        Customer testCustomer = CustomerController.createCustomer(
                "Chad", "Johnson", LocalDate.of(2002,12,13),
                "test@test.com", "12345678", address,
                "testingPassword");
        //===========================================================
        Author testAuthor = BookController.createAuthor(
                "author@mail.com", "Auther","Rost");
        Publisher testPublisher = new Publisher("publisher@mail.com",
                "Union Publisher", address);
        ArrayList<BookEntity> bookEntities = new ArrayList<>();
        bookEntities.add(testAuthor);
        bookEntities.add(testPublisher);
        Measurement bookMeasurement = new Measurement(20.5, 11,200);
        //===========================================================
        Book testBook = BookController.createBook(
                "1234_12345_123456", "Test Book", BookType.EBOOK,
                Year.now(), "360", bookMeasurement, bookEntities, 249);

        //===========================================================
        CustomerController.createCustomerRating(testCustomer, testBook, 8.5, "Testing is great");

        // Second backend test -> not passed
        testCustomer.getCart().addItem(testBook, 1);
        System.out.println(testCustomer.getCart().calculatePrice());

        Order testOrder = new Order(testCustomer, testCustomer.getCart());
        System.out.println(testOrder.getOrderPrice()); // No stock has been made
        Stock testBookStock = new Stock(100, testBook);
        System.out.println(testOrder.getOrderPrice()); // No stock has been made
    }
}
