package com.jpc16tuesday.springliblaryproject.library.hw_model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Table(name = "directors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SequenceGenerator(name = "default_generator", sequenceName = "directors_sequence", allocationSize = 1)
public class Director extends GenericModel {
    private String directorsFIO;
    private Integer position;
    @ManyToMany
    @JoinTable(name = "directors_films",
            joinColumns = @JoinColumn(name = "directors_id"),
            foreignKey = @ForeignKey(name = "FK_DIRECTORS_FILMS"),
            inverseJoinColumns = @JoinColumn(name = "films_id"),
            inverseForeignKey = @ForeignKey(name = "FK_FILMS_DIRECTORS"))
    List<Film> films;
}