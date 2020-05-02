package com.ajax.task2;

import com.ajax.task1.TaskBankAccount;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ConcurrentPrimeCalculatorTest {
    
    @Test
    public void successfulResult() {
        PrimeCalculatorContract calculator = new ConcurrentPrimeCalculator();
        List<Integer> integers = calculator.returnAllPrimeNumbers(13);
    }
}