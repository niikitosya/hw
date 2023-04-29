package com.jpc16tuesday.springliblaryproject.dbexample.model.HW6.DBEditors;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
public class CreateUserTable {
    private final String[] COLUMN_NAMES = {"id", "secondName", "firstname", "dateOfBirth", "mail", "phone", "books"};
    private final String[] COLUMN_TYPES = {"serial primary key", "varchar(30) not null","varchar(30) not null", "timestamp not null", "varchar(30) not null","varchar(30) not null", "varchar(30) not null"};
    private Connection connection;
    CreateUserTable(Connection connection){
        this.connection = connection;
    }
    public void createUserTable() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(getSQLRequest());
        preparedStatement.executeUpdate();
    }
    private String getSQLRequest(){
        String out = "Create table public.Users(";
        for(int i = 0; i < COLUMN_NAMES.length; i++){
            out = out + " " + COLUMN_NAMES[i] + " " + COLUMN_TYPES[i] + (i == COLUMN_NAMES.length -1 ? "" : ",");
        }
        out = out + ");";
        return out;
    }
}
