package storage;

import domain.models.book.bookEntities.Author;
import domain.models.book.bookEntities.BookEntity;
import domain.models.book.bookEntities.Publisher;

import java.sql.*;
import java.util.ArrayList;

public class BookEntityStorage {
    private final static ArrayList<Publisher> publisherArrayList = new ArrayList<>();
    private final static ArrayList<Author> authorArrayList = new ArrayList<>();

    public static void addEntity(BookEntity entity){
        if(entity instanceof Publisher){
            if(!publisherArrayList.contains(entity)){
                publisherArrayList.add((Publisher) entity);
            }
        } else if(entity instanceof Author) {
            if(!authorArrayList.contains(entity)){
                authorArrayList.add((Author) entity);
            }
        }
    }

    public static void addEntityToDatabase(BookEntity entity) {
        String url = "jdbc:sqlserver://LENOVO-THINKPAD\\SQLExpress;databaseName=TinyBookStore;user=sa;password=131202;";

        try (Connection connection = DriverManager.getConnection(url)) {
            String insertBookEntitySQL = "INSERT INTO Book_Entity (entityId, email) VALUES (?, ?)";
            try (PreparedStatement insertBookEntity = connection.prepareStatement(insertBookEntitySQL)) {
                insertBookEntity.setLong(1, entity.getId());
                insertBookEntity.setString(2, entity.getEmail());
                insertBookEntity.executeUpdate();
            }

            if (entity instanceof Author) {
                String insertAuthorSQL = "INSERT INTO Author (entityId, firstName, lastName) VALUES (?, ?, ?)";
                try (PreparedStatement insertAuthor = connection.prepareStatement(insertAuthorSQL)) {
                    insertAuthor.setLong(1, entity.getId());
                    insertAuthor.setString(2, ((Author) entity).getFirstName());
                    insertAuthor.setString(3, ((Author) entity).getLastName());
                    insertAuthor.executeUpdate();
                }
            } else if (entity instanceof Publisher) {
                String insertPublisherSQL = "INSERT INTO Publisher (entityId, title) VALUES (?, ?)";
                try (PreparedStatement insertPublisher = connection.prepareStatement(insertPublisherSQL)) {
                    insertPublisher.setLong(1, entity.getId());
                    insertPublisher.setString(2, ((Publisher) entity).getTitle());
                    insertPublisher.executeUpdate();
                }
            }
        } catch (SQLException e) {
            System.err.println("BookEntityStorage -> addEntityToDatabase(BookEntity entity)");
            System.err.println(e.getMessage());
            e.printStackTrace(); // Log the stack trace for debugging
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void removeEntity(BookEntity entity){
        if(entity instanceof Publisher){
            publisherArrayList.remove(entity);
        } else if(entity instanceof Author) {
            authorArrayList.remove(entity);
        }
    }

    public static ArrayList<Publisher> getAllPublishersFromDatabase(){
        ArrayList<Publisher> publishers = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://LENOVO-THINKPAD\\SQLExpress;databaseName=TinyBookStore;user=sa;password=131202;"
            );

            String sqlStatement = "SELECT P.title, BE.email\n" +
                    "FROM Publisher AS P\n" +
                    "INNER JOIN Book_Entity AS BE\n" +
                    "\tON P.entityId = BE.entityId";

            PreparedStatement retrievePublisherStatement = connection.prepareStatement(
                    sqlStatement,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            );

            ResultSet retrievePublisherResultSet = retrievePublisherStatement.executeQuery();

            while(retrievePublisherResultSet.next()){
                publishers.add(new Publisher(
                        retrievePublisherResultSet.getString("email"),
                        retrievePublisherResultSet.getString("title")
                ));
            }

        } catch (SQLException e){
            System.out.println("BookEntityStorage.java -> getAllPublishersFromDatabase()");
            e.getMessage();
        }
        return publishers;
    }

    public static ArrayList<Author> getAllAuthorsFromDatabase(){
        ArrayList<Author> authors = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://LENOVO-THINKPAD\\SQLExpress;databaseName=TinyBookStore;user=sa;password=131202;"
            );

            String sqlStatement = "SELECT A.firstName, A,lastName, BE.email\n" +
                    "FROM Author AS A\n" +
                    "INNER JOIN Book_Entity AS BE\n" +
                    "\tON A.entityId = BE.entityId";

            PreparedStatement retrieveAuthorStatement = connection.prepareStatement(
                    sqlStatement,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            );

            ResultSet retrieveAuthorResultSet = retrieveAuthorStatement.executeQuery();

            while(retrieveAuthorResultSet.next()){
                authors.add(new Author(
                        retrieveAuthorResultSet.getString("email"),
                        retrieveAuthorResultSet.getString("firstName"),
                        retrieveAuthorResultSet.getString("lastName")
                ));
            }

        } catch (SQLException e){
            System.out.println("BookEntityStorage.java -> getAllAuthorsFromDatabase()");
            e.getMessage();
        }
        return authors;
    }
}
