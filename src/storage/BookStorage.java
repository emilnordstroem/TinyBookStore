package storage;

import domain.models.book.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookStorage {
    private final static ArrayList<Book> bookArrayList = new ArrayList<>();

    public static void addBook(Book book){
        if(!bookArrayList.contains(book)){
            bookArrayList.add(book);
        }
    }

    public static ArrayList<Book> getBookArrayList(){
        return new ArrayList<>(bookArrayList);
    }

    public static void removeBook(Book book){
        bookArrayList.remove(book);
    }

    public static void addBookToDatabase(Book book){
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://LENOVO-THINKPAD\\SQLExpress;databaseName=TinyBookStore;user=sa;password=131202;"
            );
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO Book VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );
            try{
                statement.setString(1, book.getIsbn());
                statement.setString(2, book.getDescription().getType().toString()); // type
                statement.setString(3, book.getDescription().getTitle()); // title
                statement.setString(4, book.getDescription().getPublicationsYear().toString()); // publication
                statement.setString(5, book.getDescription().getPages()); // pages
                statement.setDouble(6, book.getMeasurement().getHeight()); // height
                statement.setDouble(7, book.getMeasurement().getWidth()); // width
                statement.setDouble(8, book.getMeasurement().getWeight()); // weight
                statement.setInt(9, book.isRecommended()); // is recommended
                statement.setDouble(10, book.getprice()); // price
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
/*
CREATE TABLE Book (
	isbn CHAR(13) PRIMARY KEY,
	book_type VARCHAR(9) CHECK (book_type IN ('HARDCOVER', 'PAPERBACK', 'EBOOK')),
	book_title VARCHAR(50) NOT NULL,
	book_publication_year CHAR(4) NOT NULL,
	book_pages VARCHAR(5) NOT NULL,
	book_height DECIMAL(5,2) CHECK (book_height >= 0) DEFAULT 0,
    book_width DECIMAL(5,2) CHECK (book_width >= 0) DEFAULT 0,
    book_weight INT CHECK (book_weight >= 0) DEFAULT 0,
	is_recommended BIT NOT NULL CHECK (is_recommended IN (0, 1)) DEFAULT 0,
	price DECIMAL(6,2) NOT NULL CHECK (price >= 0)
)
 */