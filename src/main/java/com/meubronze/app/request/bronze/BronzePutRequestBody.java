package com.meubronze.app.request.bronze;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.meubronze.app.request.client.ClientPutRequestBody;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class BronzePutRequestBody {
    @NotNull
    @Min(value = 1, message = "id must be greater than zero")
    private Long id;

    @NotNull(message = "clientPutRequestBody can't be null")
    private ClientPutRequestBody clientPutRequestBody;

    @NotNull(message = "turnArounds must not be null")
    @Min(value = 1, message = "The number of turnArounds must be greater than zero")
    private int turnArounds;

    @NotNull(message = "totalSecs must not be null")
    @Min(value = 1, message = "totalSecs must be greater than zero")
    private int totalSecs;

    @NotNull(message = "Price can't be null")
    @DecimalMin(value = "0", message = "Price must be positive")
    private BigDecimal price;

    @NotNull(message = "timestamp can't be null")
    private LocalDateTime timestamp;
}
