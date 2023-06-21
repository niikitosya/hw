package com.jpc16tuesday.springliblaryproject.hw_library.dto;

import com.jpc16tuesday.springliblaryproject.hw_library.model.Film;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@ToString
@NoArgsConstructor
@Setter
@Getter
public class DirectorDTO extends GenericDTO{
    private String directorsFIO;
    private Integer position;
    List<Long> filmsIds;
}