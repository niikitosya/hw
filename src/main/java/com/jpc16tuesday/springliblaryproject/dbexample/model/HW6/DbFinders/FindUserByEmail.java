package com.jpc16tuesday.springliblaryproject.dbexample.model.HW6.DbFinders;

import com.jpc16tuesday.springliblaryproject.dbexample.model.DB.DbConnection;
import com.jpc16tuesday.springliblaryproject.dbexample.model.HW6.User;
import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FindUserByEmail extends UserSearcher implements SearchUserResource{
    private final Connection connection;
    private final String FIND_REQUEST = "Select * from Users where email = ?";
    public FindUserByEmail(Connection connection){
        this.connection = connection;
    }
    public User takeUser(ResultSet set){
            return super.takeUser(set);
    }
    @Override
    public User findUser(String str) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(FIND_REQUEST);
        preparedStatement.setString(1, str);
        User user = takeUser(preparedStatement.executeQuery());
        return user;
    }
}
