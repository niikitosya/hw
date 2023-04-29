package com.jpc16tuesday.springliblaryproject.dbexample.model.dao;

import com.jpc16tuesday.springliblaryproject.dbexample.model.Book;
import com.jpc16tuesday.springliblaryproject.dbexample.model.DB.DbConnection;

import java.sql.*;
import java.util.concurrent.ExecutionException;

public class BookDaoJDBC {
    public Book findBookById(Integer bookId) {
        try (Connection connection = DbConnection.INSTANCE.newConnection()) {
            System.out.println("Ура, мы подключились к базе данных!");
            String select = "select * from books where id = ?";
            PreparedStatement statement = connection.prepareStatement(select);
            statement.setInt(1, bookId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(bookId);
                book.setAuthor(resultSet.getString("author"));
                book.setTitle(resultSet.getString("title"));
                book.setDateAdded(resultSet.getDate("date_added"));
                System.out.println(book);
                return book;
            }
        } catch (SQLException ex) {
            System.err.println("error" + ex.getMessage());
        }
        return null;
    }
}
