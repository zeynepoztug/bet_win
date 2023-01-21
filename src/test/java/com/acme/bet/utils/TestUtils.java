package com.acme.bet.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestUtils {
    public static final String CONTROLLER_POST_URL = "/bet";
    public static final String CONTROLLER_REQUEST_BODY = "{\"number\":" + 1 + ", \"bet\":" + 1 + "}";
    public static final String BET_MUST_BE_GREATER_THAN_ONE_MSG = "bet must be equal or greater than 1";
    public static final String BET_MUST_BE_NUMBER_FROM_ONE_HUNDRED_MSG = "bet must be number from 1 to 100";
    public static final String BET_MUST_BE_E_LT_HUNDRED_MSG =  "bet must be equal or less than 100";
}
