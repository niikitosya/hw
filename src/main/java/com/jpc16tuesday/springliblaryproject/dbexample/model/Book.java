package com.jpc16tuesday.springliblaryproject.dbexample.model;

import lombok.*;

import javax.annotation.processing.Generated;
import java.util.Date;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private Integer id;
    private String title;
    private String author;
    private Date dateAdded;
}
