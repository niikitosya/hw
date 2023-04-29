package com.jpc16tuesday.springliblaryproject.dbexample.model.dao;

import com.jpc16tuesday.springliblaryproject.dbexample.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class BookDaoBean {

    private final Connection connection;
    private final String BOOK_SELECT_BY_ID_QUERY = "Select * from books where ID = ?";
    @Autowired
    public BookDaoBean(Connection connection){
        this.connection = connection;
    }
    public Book findBookById(Integer bookId) throws SQLException {
        PreparedStatement selectQuery = connection.prepareStatement(BOOK_SELECT_BY_ID_QUERY);
        selectQuery.setInt(1, bookId);
        ResultSet resultSet = selectQuery.executeQuery();
        while(resultSet.next()){
            Book book = new Book();
            book.setId(bookId);
            book.setAuthor(resultSet.getString("author"));
            book.setTitle(resultSet.getString("title"));
            book.setDateAdded(resultSet.getDate("date_added"));
            System.out.println(book);
            return book;
        }
        return null;
    }
    public Book findBookByTitle(String title){
        return null;
    }
}
