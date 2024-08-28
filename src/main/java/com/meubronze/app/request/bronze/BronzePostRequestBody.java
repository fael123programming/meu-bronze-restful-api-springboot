package com.meubronze.app.request.bronze;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.meubronze.app.request.client.ClientPostRequestBody;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class BronzePostRequestBody {
    @NotNull(message = "clientPostRequestBody can't be null")
    private ClientPostRequestBody clientPostRequestBody;

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
