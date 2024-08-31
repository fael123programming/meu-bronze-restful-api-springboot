package com.meubronze.app.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Bronze {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "clientId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Client client;

    @NotNull(message = "turnArounds must not be null")
    @Min(value = 1, message = "The number of turnArounds must be greater than zero")
    private int turnArounds;

    @NotNull(message = "totalSecs must not be null")
    @Min(value = 1, message = "totalSecs must be greater than zero")
    int totalSecs;

    @NotNull(message = "Price can't be null")
    @DecimalMin(value = "0", message = "Price must be positive")
    BigDecimal price;

    @NotNull(message = "timestamp can't be null")
    LocalDateTime timestamp;
}
