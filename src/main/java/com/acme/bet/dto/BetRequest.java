package com.acme.bet.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class BetRequest {
    // Player is sending a bet and whole number from 1 to 100 to a server
    @NotNull(message = "bet must be number from 1 to 100")
    @Min(value = 1, message = "bet must be equal or greater than 1")
    @Max(value = 100, message = "bet must be equal or less than 100")
    private Integer number;

    // @todo bet scope
    @DecimalMin(value = "0.01", inclusive = false)
    @Digits(integer = 3, fraction = 2)
    private BigDecimal bet;
}
