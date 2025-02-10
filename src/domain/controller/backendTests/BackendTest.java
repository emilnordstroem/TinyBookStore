package domain.controller.backendTests;

import domain.controller.useCases.BookController;
import domain.controller.useCases.CustomerController;
import domain.controller.useCases.InventoryController;
import domain.controller.useCases.OrderController;
import domain.models.address.Apartment;
import domain.models.book.Book;
import domain.models.book.BookType;
import domain.models.book.bookEntities.*;
import domain.models.customer.Customer;
import domain.models.customer.Rating;
import domain.models.order.Order;
import domain.models.order.OrderStatus;

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
        //===========================================================
        Book testBook = BookController.createBook("1234_12345_123456",
                new Description(BookType.EBOOK, "Test Book", Year.now(), "360"),
                new Measurement(20.5, 11,200),
                testAuthor,
                testPublisher,
                249);
        //===========================================================
    // Second backend test -> passed
        InventoryController.createStock(testBook, 100);

        testCustomer.getCart().addItem(testBook, 1);
        System.out.println("Cart price:" + testCustomer.getCart().calculatePrice());

        Order testOrder = OrderController.createOrder(testCustomer);
        System.out.println("Order price" + testOrder.getOrderPrice());

        //===========================================================
    // Third backend text -> passed
        System.out.println(testOrder.getStatus());
        for(int counter = 0; counter < 6; counter++){
            if(counter == 0){
                testOrder.updateOrder(OrderStatus.PACKED);
            } else if (counter == 1) {
                testOrder.updateOrder(OrderStatus.CANCELLED);
            } else if (counter == 2) {
                testOrder.updateOrder(OrderStatus.INTRANSIT);
            } else if (counter == 3) {
                testOrder.updateOrder(OrderStatus.DELIVERED);
            } else if (counter == 4) {
                testOrder.updateOrder(OrderStatus.CANCELLED);
            } else {
                testOrder.updateOrder(OrderStatus.RETURNED);
            }
            System.out.println(counter + " " + testOrder.getStatus());
        }
        //===========================================================
    // Fourth backend text -> passed
        CustomerController.createCustomerRating(testCustomer, testBook, 8.5, "Testing is great");
        Rating rating = testCustomer.getBookRatings().getFirst();
        testCustomer.removeRating(rating);
        if(testCustomer.getBookRatings().isEmpty()){
            System.out.println("No book ratings");
        }
    }
}
