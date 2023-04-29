package com.jpc16tuesday.springliblaryproject.dbexample.model.HW6;
import com.jpc16tuesday.springliblaryproject.dbexample.model.MyDbConfigContext;
import com.jpc16tuesday.springliblaryproject.dbexample.model.Book;
import com.jpc16tuesday.springliblaryproject.dbexample.model.HW6.User;
import com.jpc16tuesday.springliblaryproject.dbexample.model.dao.BookDaoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Component
public class BookShower {
    private final Connection connection;
    private final BookDaoBean bookDaoBean;
    @Autowired
    public BookShower(Connection connection, BookDaoBean bookDaoBean){
        this.connection = connection;
        this.bookDaoBean = bookDaoBean;
    }
    public List<Book> getBooksByIndex(List<Integer> books) throws SQLException {
        List<Book> out = new ArrayList<>();
        if (books.size() !=0) {
            for (Integer i : books) {
                out.add(bookDaoBean.findBookById(i));
            }
        }
        return out;
    }
}
