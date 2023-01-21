package com.acme.bet.dto;

import java.math.BigDecimal;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static com.acme.bet.utils.TestUtils.BET_MUST_BE_GREATER_THAN_ONE_MSG;
import static com.acme.bet.utils.TestUtils.BET_MUST_BE_NUMBER_FROM_ONE_HUNDRED_MSG;
import static com.acme.bet.utils.TestUtils.BET_MUST_BE_E_LT_HUNDRED_MSG;

@SpringBootTest
public class DtoValidationTest {

    private Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void violationIsNotEmpty_whenNumberIsLowerThan1() {
        BetRequest request = new BetRequest();
        request.setNumber(0);
        request.setBet(BigDecimal.valueOf(1));

        Set<ConstraintViolation<BetRequest>> violations = validator.validate(request);
        assertEquals(BET_MUST_BE_GREATER_THAN_ONE_MSG, violations.iterator().next().getMessage());
    }

    @Test
    public void violationIsNotEmpty_whenNumberIsNull() {
        BetRequest request = new BetRequest();
        request.setNumber(null);
        request.setBet(BigDecimal.valueOf(1));

        Set<ConstraintViolation<BetRequest>> violations = validator.validate(request);
        assertEquals(BET_MUST_BE_NUMBER_FROM_ONE_HUNDRED_MSG, violations.iterator().next().getMessage());
    }

    @Test
    public void violationIsNotEmpty_whenNumberIsGreaterThan100() {
        BetRequest request = new BetRequest();
        request.setNumber(101);
        request.setBet(BigDecimal.valueOf(1));

        Set<ConstraintViolation<BetRequest>> violations = validator.validate(request);
        assertEquals(BET_MUST_BE_E_LT_HUNDRED_MSG, violations.iterator().next().getMessage());
    }

    @Test
    public void violationIsNotEmpty_whenBetIs0() {
        BetRequest request = new BetRequest();
        request.setNumber(100);
        request.setBet(BigDecimal.valueOf(0));

        Set<ConstraintViolation<BetRequest>> violations = validator.validate(request);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void violationIsNotEmpty_whenBetHasMoreThan3Digits() {
        BetRequest request = new BetRequest();
        request.setNumber(100);
        request.setBet(BigDecimal.valueOf(4444));

        Set<ConstraintViolation<BetRequest>> violations = validator.validate(request);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void violationIsNotEmpty_whenBetRequestIsProperlySet() {
        BetRequest request = new BetRequest();
        request.setNumber(100);
        request.setBet(BigDecimal.valueOf(2));

        Set<ConstraintViolation<BetRequest>> violations = validator.validate(request);
        assertTrue(violations.isEmpty());
    }
}
