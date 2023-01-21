package com.acme.bet.controller;

import com.acme.bet.dto.BetRequest;
import com.acme.bet.dto.BetResponse;
import com.acme.bet.service.IBetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
public class ApiController {

    @Autowired
    private IBetService betService;

    @PostMapping(value = "/bet")
    public ResponseEntity<BetResponse> openArticleToPublic(@RequestBody @Valid BetRequest betRequest) {
        BetResponse response = betService.bet(betRequest);
        if (response != null) {
            return ResponseEntity.ok(response);
        } else {
            log.error("Failed calculate betResponse");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
