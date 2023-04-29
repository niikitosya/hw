package com.jpc16tuesday.springliblaryproject.dbexample.model;

import com.jpc16tuesday.springliblaryproject.dbexample.model.dao.BookDaoBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.jpc16tuesday.springliblaryproject.dbexample.model.constants.DBConstants.*;
@Configuration
@ComponentScan
public class MyDbConfigContext {
    @Bean
    @Scope("singleton")
    public Connection newConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:postgresql://" + DB_HOST +":" + PORT +
                "/" + DB, USER, PASSWORD);
    }
  /*  @Bean
    public BookDaoBean bookDaoBean() throws SQLException{
        return new BookDaoBean(newConnection());
    }*/
}
