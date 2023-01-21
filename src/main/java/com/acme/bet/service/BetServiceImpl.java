package com.acme.bet.service;

import com.acme.bet.dto.BetRequest;
import com.acme.bet.dto.BetResponse;
import com.acme.bet.game.Game;
import org.springframework.stereotype.Service;

@Service
public class BetServiceImpl implements IBetService {
    @Override
    public BetResponse bet(BetRequest betRequest) {
        BetResponse response = new BetResponse();
        Game game = new Game();
        response.setWin(game.run(betRequest.getBet(), betRequest.getNumber()));
        return response;
    }
}
