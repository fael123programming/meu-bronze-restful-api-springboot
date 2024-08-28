package com.meubronze.app.request.client;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ClientPostRequestBody {
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
