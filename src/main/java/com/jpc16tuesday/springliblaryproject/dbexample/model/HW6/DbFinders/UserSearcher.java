package com.jpc16tuesday.springliblaryproject.dbexample.model.HW6.DbFinders;

import com.jpc16tuesday.springliblaryproject.dbexample.model.HW6.User;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
//Для всех классов один метод
@Component
public class UserSearcher {
    User takeUser(ResultSet resultSet)  {
        try {

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));

                user.setSecondName(resultSet.getString("secondName"));
                user.setFirstName(resultSet.getString("firstName"));

                user.setDateOfBirth(resultSet.getDate("dateOfBirth"));
                user.setMail(resultSet.getString("mail"));
                user.setPhone(resultSet.getString("phone"));
                String[] books =  resultSet.getString("books").replaceAll("\'", "").split(", ");

                List<Integer> list = new ArrayList<>();

                for (String e: books){

                    list.add(Integer.parseInt(e));

                }
                user.setBooks(list);

                return user;
            }
        }
        catch (SQLException ex){
            System.out.println("error: " + ex.toString());
        }
        return null;
    }
}
