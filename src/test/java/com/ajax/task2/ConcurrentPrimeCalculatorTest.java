package com.ajax.task2;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ConcurrentPrimeCalculatorTest {
    
    @Test
    public void successfulResult() {
        PrimeCalculatorContract calculator = new ConcurrentPrimeCalculator();
        List<Integer> primes = calculator.returnAllPrimeNumbers(25);
        assertThat(primes).contains(2, 3, 5, 7, 11, 13, 17, 19, 23);
    }
}