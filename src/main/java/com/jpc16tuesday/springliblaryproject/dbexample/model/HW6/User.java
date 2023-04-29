package com.jpc16tuesday.springliblaryproject.dbexample.model.HW6;

import lombok.*;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String secondName;
    private String firstName;
    private Date dateOfBirth;
    private String mail;
    private String phone;
    private List<Integer> books;
}
