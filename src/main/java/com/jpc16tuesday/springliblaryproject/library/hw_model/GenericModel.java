package com.jpc16tuesday.springliblaryproject.library.hw_model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@MappedSuperclass
public class GenericModel {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "default_generator")
    private int id;
    @Column(name = "created_when")
    private LocalDateTime createdWhen;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "deleted_when")
    private LocalDateTime deletedWhen;
    @Column(name = "deleted_by")
    private String deletedBy;
    @Column(name = "is_deleted", columnDefinition = "boolean default false")
    private boolean isDeleted;

}
