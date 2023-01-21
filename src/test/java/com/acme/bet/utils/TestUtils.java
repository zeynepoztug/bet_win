package com.acme.bet.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestUtils {
    public static final String CONTROLLER_POST_URL = "/bet";
    public static final String CONTROLLER_REQUEST_BODY = "{\"number\":" + 1 + ", \"bet\":" + 1 + "}";
}
