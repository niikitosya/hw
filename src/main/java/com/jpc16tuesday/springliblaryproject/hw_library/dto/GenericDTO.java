package com.jpc16tuesday.springliblaryproject.hw_library.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class GenericDTO {
    private Long id;
    private LocalDateTime createdWhen;

    private String createdBy;

    private LocalDateTime deletedWhen;

    private String deletedBy;

    private boolean isDeleted;
}
