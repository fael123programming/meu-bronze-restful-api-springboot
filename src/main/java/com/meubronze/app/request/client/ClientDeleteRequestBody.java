package com.meubronze.app.request.client;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientDeleteRequestBody {
    @NotNull
    @Min(value = 1, message = "id must be greater than zero")
    private Long id;
}
