package com.jpc16tuesday.springliblaryproject.dbexample.model.HW6;

import com.jpc16tuesday.springliblaryproject.dbexample.model.Book;
import com.jpc16tuesday.springliblaryproject.dbexample.model.HW6.DbFinders.SearchUserResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component
public class UserDao {

    private SearchUserResource searchUserResource;
    private BookShower bookShower;
    @Autowired
    public UserDao(SearchUserResource searchUserResource, BookShower bookShower){
        this.searchUserResource = searchUserResource;
        this.bookShower = bookShower;
    }
    public User findUser(String str) throws SQLException {
        return searchUserResource.findUser(str);
    }

    public List<Book> getBooksInfo(String str)throws SQLException {
        User user = findUser(str); //
        System.out.println("У пользователя " + user.getFirstName().replaceAll("\'", "") + " " + user.getSecondName().replaceAll("\'", "") + " в пользовании следующие книги");
        return bookShower.getBooksByIndex(user.getBooks());
    }
}
