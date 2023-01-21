package com.acme.bet.service;

import com.acme.bet.dto.BetRequest;
import com.acme.bet.dto.BetResponse;

public interface IBetService {
    BetResponse bet(BetRequest betRequest);
}
