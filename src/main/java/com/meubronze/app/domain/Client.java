package com.meubronze.app.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
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
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotEmpty(message = "name must have at least one character")
    private String name;

    @NotEmpty(message = "phoneNumber must have at least one character")
    private String phoneNumber;

    @NotNull(message = "since can't be null")
    private LocalDateTime since;

    @NotNull(message = "bronzes can't be null")
    @Min(value = 0, message = "The number of bronzes must be positive")
    private Integer bronzes;

    @Column(nullable = true)
    private String observations;

    @Lob
    @Column(nullable = true)
    private byte[] image;
}   
