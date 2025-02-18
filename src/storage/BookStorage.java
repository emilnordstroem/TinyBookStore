package storage;

import domain.models.book.Book;
import domain.models.book.BookType;
import domain.models.book.bookEntities.Author;
import domain.models.book.bookEntities.Description;
import domain.models.book.bookEntities.Measurement;
import domain.models.book.bookEntities.Publisher;

import java.sql.*;
import java.time.Year;
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

    public static ArrayList<Book> getAllBooksFromDatabase(){
        ArrayList<Book> booksList = new ArrayList<>();
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://LENOVO-THINKPAD\\SQLExpress;databaseName=TinyBookStore;user=sa;password=131202;"
            );

            String sqlStatement = """
                    SELECT B.isbn, B.book_type, B.book_title, B.book_publication_year, B.book_pages, B.book_height, B.book_width, B.book_weight, B.price,\s
                    A.firstName, A.lastName,
                    BEE.email,
                    P.title
                    FROM Book B
                    JOIN Book_Entities BE\s
                    \tON B.isbn = BE.bookId\s
                    \t\tJOIN Book_Entity BEE\s
                    \t\t\tON BE.entityId = BEE.entityId\s
                    \t\t\t\tLEFT JOIN Author A\s
                    \t\t\t\t\tON BEE.entityId = A.entityId\s
                    \t\t\t\t\t\tLEFT JOIN Publisher P\s
                    \t\t\t\t\t\t\tON BEE.entityId = P.entityId""";

            PreparedStatement retrieveBooksStatement = connection.prepareStatement(
                    sqlStatement,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            );

            ResultSet retrieveBooksResultSet = retrieveBooksStatement.executeQuery();

            while(retrieveBooksResultSet.next()){
                String isbn = retrieveBooksResultSet.getString("isbn");
                Description description = new Description(
                        BookType.valueOf(retrieveBooksResultSet.getString("book_type")),
                        retrieveBooksResultSet.getString("book_title"),
                        Year.of(Integer.parseInt(retrieveBooksResultSet.getString("book_publication_year"))),
                        retrieveBooksResultSet.getString("book_pages")
                );
                Measurement measurement = new Measurement(
                        retrieveBooksResultSet.getDouble("book_height"),
                        retrieveBooksResultSet.getDouble("book_width"),
                        retrieveBooksResultSet.getDouble("book_weight")
                );
                Author author = new Author(
                        retrieveBooksResultSet.getString("email"),
                        retrieveBooksResultSet.getString("firstName"),
                        retrieveBooksResultSet.getString("lastName")
                );
                Publisher publisher = new Publisher(
                        retrieveBooksResultSet.getString("email"),
                        retrieveBooksResultSet.getString("title")
                );
                boolean isRecommended = false;
                double price = retrieveBooksResultSet.getDouble("price");

                booksList.add(new Book(isbn, description, measurement, author, publisher, price));
            }
        } catch (SQLException e) {
            System.out.println("BookStorage.java -> getAllBooksFromDatabase()");
            e.getMessage();
        }
        for(Book book : booksList){
            System.out.println(book.getIsbn());
        }
        return booksList;
    }
}
