package com.jpc16tuesday.springliblaryproject;

import com.jpc16tuesday.springliblaryproject.dbexample.model.Book;
import com.jpc16tuesday.springliblaryproject.dbexample.model.DB.DbConnection;
import com.jpc16tuesday.springliblaryproject.dbexample.model.HW6.DBEditors.AddUserToUsersTable;
import com.jpc16tuesday.springliblaryproject.dbexample.model.HW6.DBEditors.CreateUserTable;
import com.jpc16tuesday.springliblaryproject.dbexample.model.HW6.DbFinders.FindUserByEmail;
import com.jpc16tuesday.springliblaryproject.dbexample.model.HW6.DbFinders.SearchUserResource;
import com.jpc16tuesday.springliblaryproject.dbexample.model.HW6.User;
import com.jpc16tuesday.springliblaryproject.dbexample.model.HW6.UserDao;
import com.jpc16tuesday.springliblaryproject.dbexample.model.MyDbConfigContext;
import com.jpc16tuesday.springliblaryproject.dbexample.model.dao.BookDaoBean;
import com.jpc16tuesday.springliblaryproject.dbexample.model.dao.BookDaoJDBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.*;
import java.util.List;

import static com.jpc16tuesday.springliblaryproject.dbexample.model.constants.DBConstants.*;

@SpringBootApplication
public class SpringLiblaryProjectApplication implements CommandLineRunner {

      //public SpringLiblaryProjectApplication(BookDaoBean bookDaoBean){
    // this.bookDaoBean = bookDaoBean;
  //}
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
   // private BookDaoBean bookDaoBean;
    public static void main(String[] args) {
        SpringApplication.run(SpringLiblaryProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Swagger path: http://localhost:8080/swagger-ui/index.html");
    }
}
