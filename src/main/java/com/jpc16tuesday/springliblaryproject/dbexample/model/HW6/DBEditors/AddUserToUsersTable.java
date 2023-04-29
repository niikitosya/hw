package com.jpc16tuesday.springliblaryproject.dbexample.model.HW6.DBEditors;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.*;

import static com.jpc16tuesday.springliblaryproject.dbexample.model.constants.DBConstants.*;

@Component
public class AddUserToUsersTable {
    private Connection connection;
    final String SQL_REQUEST = "insert into Users (secondName, firstname, dateOfBirth, mail, phone, books) " +
            "values ( ? , ? , ? , ? , ? , ? );";

    public AddUserToUsersTable(Connection connection){
        this.connection = connection;
    }

    public void addUser(String[] args) throws SQLException {
        String[] date = args[2].split(" ");
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_REQUEST);
                preparedStatement.setString(1, ('\'' + (String)args[0] + '\''));
                preparedStatement.setString(2, ('\'' + (String)args[1] + '\''));
                preparedStatement.setDate(3, (new Date(Integer.parseInt(date[0])- 1900, Integer.parseInt(date[1])- 1, Integer.parseInt(date[2]))));
                preparedStatement.setString(4, ('\'' + (String)args[3] + '\''));
                preparedStatement.setString(5, ('\'' + (String)args[4] + '\''));
                preparedStatement.setString(6, ('\'' + (String)args[5] + '\''));
                preparedStatement.executeUpdate();
    }
    public void checkUsers() throws SQLException{
        PreparedStatement selectQuery = connection.prepareStatement("select * from Users");
        ResultSet res = selectQuery.executeQuery();
        int k = res.getMetaData().getColumnCount();

        //for (int i = 1; i <= k; i++) {
            while (res.next()){
                for (int i = 1; i <= k; i++) {
                    System.out.print(res.getString(i) + "\t");
                }
                System.out.println();
        }
        }

        public void removeUsers() throws SQLException{
            PreparedStatement selectQuery = connection.prepareStatement("Delete from Users;");
            selectQuery.executeUpdate();
        }
    }

