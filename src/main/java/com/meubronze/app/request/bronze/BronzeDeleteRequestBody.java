package com.meubronze.app.request.bronze;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BronzeDeleteRequestBody {
    
    @NotEmpty(message = "The bronzeIds list must not be empty")
    private List<Long> bronzeIds;
}
