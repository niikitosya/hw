package com.jpc16tuesday.springliblaryproject.dbexample.model.HW6.DbFinders;

import com.jpc16tuesday.springliblaryproject.dbexample.model.HW6.User;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
// Создан интерфейс для изменения параметров поиска без прибегания изменения кода
@Component
public interface SearchUserResource{
    public User findUser(String str) throws SQLException;
    User takeUser(ResultSet set);
}
