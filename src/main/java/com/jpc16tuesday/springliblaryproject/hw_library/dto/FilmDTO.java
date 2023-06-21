package com.jpc16tuesday.springliblaryproject.hw_library.dto;

import com.jpc16tuesday.springliblaryproject.hw_library.model.Genre;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
@ToString
@NoArgsConstructor
@Setter
@Getter
public class FilmDTO extends GenericDTO{
    private String title;
    private LocalDate premierYear;
    private String country;
    private Genre genre;
    private List<Long> directorIds;
}
