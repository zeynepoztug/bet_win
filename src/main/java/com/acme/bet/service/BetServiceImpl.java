package com.acme.bet.service;

import com.acme.bet.dto.BetRequest;
import com.acme.bet.dto.BetResponse;
import org.springframework.stereotype.Service;

@Service
public class BetServiceImpl implements IBetService {
    @Override
    public BetResponse bet(BetRequest betRequest) {
        BetResponse response = new BetResponse();
        response.setWin(3);
        return response;
    }
}
