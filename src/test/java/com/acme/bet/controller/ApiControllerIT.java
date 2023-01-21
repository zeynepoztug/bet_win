package com.acme.bet.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.mockito.Mock;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.acme.bet.service.IBetService;
import static com.acme.bet.utils.TestUtils.CONTROLLER_REQUEST_BODY;
import static com.acme.bet.utils.TestUtils.CONTROLLER_POST_URL;

@AutoConfigureMockMvc
@SpringBootTest
public class ApiControllerIT {

    @Autowired
    private MockMvc mockMvc;
    @Mock
    IBetService service;

    @Test
    void givenBet_MediaTypeNotSetProperly_then4xxClientError() throws Exception {
        when(service.bet(any())).thenReturn(null);
        mockMvc.perform(post(CONTROLLER_POST_URL)
                        .content(CONTROLLER_REQUEST_BODY)
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().is4xxClientError())
                .andReturn();
    }

    @Test
    void givenBet_MediaTypeSetProperly_thenSuccess() throws Exception {
        when(service.bet(any())).thenReturn(any());
        var mvcResult = mockMvc.perform(post(CONTROLLER_POST_URL)
                        .content(CONTROLLER_REQUEST_BODY)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("win"));
    }

    @Test
    void givenBet_MediaTypeSetProperly_thenBadRequest() throws Exception {
        mockMvc.perform(post(CONTROLLER_POST_URL)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void givenBet_MediaTypeSetProperly_thenBad() throws Exception {
        mockMvc.perform(post(CONTROLLER_POST_URL)
                        .content("{}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn();
    }
}
