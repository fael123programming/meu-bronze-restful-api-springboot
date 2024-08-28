package com.meubronze.app.domain;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
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
@Config.ValidTimeSum
public class Config {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "The value of defaultHours can't be null")
    private Integer defaultHours;

    @NotNull(message = "The value of defaultMins can't be null")
    private Integer defaultMins;

    @NotNull(message = "The value of defaultSecs can't be null")
    private Integer defaultSecs;

    @NotNull(message = "The number of turnArounds can't be null")
    @Min(value = 1, message = "The number of turnArounds must be greater than zero")
    private Integer turnArounds;

    @NotNull(message = "Price can't be null")
    @DecimalMin(value = "0", message = "Price must be positive")
    private BigDecimal price;

    @Target({ElementType.TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @Constraint(validatedBy = TimeSumValidator.class)
    public @interface ValidTimeSum {
        String message() default "The sum of defaultHours, defaultMins, and defaultSecs must be greater than zero";
        
        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default {};
    }

    public static class TimeSumValidator implements ConstraintValidator<ValidTimeSum, Config> {
        @Override
        public boolean isValid(Config config, ConstraintValidatorContext context) {
            return config.getDefaultHours() + config.getDefaultMins() + config.getDefaultSecs() > 0;
        }
    }
}
