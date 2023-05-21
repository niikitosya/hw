package com.jpc16tuesday.springliblaryproject.hw_library.model;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "role")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "default_generator", sequenceName = "Roles_sequence", allocationSize = 1)
public class Roles extends GenericModel{

    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "description", nullable = false)
    private String description;
}
