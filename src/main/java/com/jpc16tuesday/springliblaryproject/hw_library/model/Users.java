package com.jpc16tuesday.springliblaryproject.hw_library.model;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
    @Table(name = "users_for_film")
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
@SequenceGenerator(name = "default_generator", sequenceName = "Users_sequence", allocationSize = 1)
    public class Users extends GenericModel {

        @Column(name = "login", nullable = false)
        private String login;

        @Column(name = "password", nullable = false)
        private String password;

        @Column(name = "firstName", nullable = false)
        private String firstName;

        @Column(name = "lastName", nullable = false)
        private String lastName;

        @Column(name = "middleName", nullable = false)
        private String middleName;

        @Column(name = "birthDate", nullable = false)
        private LocalDate birthDate;

        @Column(name = "phone", nullable = false)
        private String phone;

        @Column(name = "email", nullable = false)
        private String email;
        @ManyToOne
        @JoinColumn(name = "role_id", nullable = false, foreignKey = @ForeignKey(name = "FK_USER_ROLES"))
        private Roles role;

        private List<Film> rentedFilms;
    }
