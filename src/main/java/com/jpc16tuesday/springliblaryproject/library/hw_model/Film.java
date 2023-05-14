package com.jpc16tuesday.springliblaryproject.library.hw_model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "films")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SequenceGenerator(name = "default_generator", sequenceName = "films_sequence", allocationSize = 1)
public class Film extends GenericModel {
    @Column(name = "title",nullable = false)
    private String title;
    @Column(name = "premier_year",nullable = false)
    private LocalDate premierYear;
    @Column(name = "country",nullable = false)
    private String country;
    @Column(name = "genre", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Genre genre;
    @ManyToMany(mappedBy = "films")
    List<Director> directors;

}
