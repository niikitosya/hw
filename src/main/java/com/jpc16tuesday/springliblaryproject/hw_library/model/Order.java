package com.jpc16tuesday.springliblaryproject.hw_library.model;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "Orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "default_generator", sequenceName = "orders_sequence", allocationSize = 1)
public class Order extends GenericModel {
    @ManyToOne
    @JoinColumn(name = "users_for_film_ id", nullable = false, foreignKey = @ForeignKey(name = "FK_ORDER_USER"))
    private Users user;
    @ManyToOne
    @JoinColumn(name = "films_id", nullable = false, foreignKey = @ForeignKey(name = "FK_ORDER_ FILM"))
    private Film film;
    @Column(name = "return_date", nullable = false)
    private LocalDate returnDate;
    @Column(name = "rent_period", nullable = false)
    private LocalDate rentDate;
    @Column(name = "purchase", nullable = false)
    private Boolean purchase;
}

