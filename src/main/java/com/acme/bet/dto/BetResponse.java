package com.acme.bet.dto;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BetResponse {
    private BigDecimal win;
}
