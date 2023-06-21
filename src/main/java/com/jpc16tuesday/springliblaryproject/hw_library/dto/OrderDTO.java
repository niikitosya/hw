package com.jpc16tuesday.springliblaryproject.hw_library.dto;

import com.jpc16tuesday.springliblaryproject.hw_library.model.Film;
import com.jpc16tuesday.springliblaryproject.hw_library.model.Users;
import jakarta.persistence.Column;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
@ToString
@NoArgsConstructor
@Setter
@Getter
public class OrderDTO extends GenericDTO{
    private Long userId;

    private Long filmId;

    private LocalDate returnDate;

    private LocalDate rentDate;

    private Boolean purchase;
}
