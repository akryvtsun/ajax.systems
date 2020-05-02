package com.ajax.task1;

import org.junit.Test;

import static org.junit.Assert.*;

public final class TaskBankAccountTest {

    @Test
    public void successfulPut() {
        BankAccountContract bankAccount = new TaskBankAccount(1000);

        OperationResult result = bankAccount.put(1500);

        assertEquals(result.isSuccessful(), true);
        assertEquals(result.operationAmount(), 1500);
        assertEquals(result.balanceAfterOperation(), 2500);
    }

    @Test
    public void successfulWithdraw() {
        BankAccountContract bankAccount = new TaskBankAccount(1500);

        OperationResult result = bankAccount.withdraw(500);

        assertEquals(result.isSuccessful(), true);
        assertEquals(result.operationAmount(), 500);
        assertEquals(result.balanceAfterOperation(), 1000);
    }

    @Test
    public void failedWithdraw() {
        BankAccountContract bankAccount = new TaskBankAccount(500);

        OperationResult result = bankAccount.withdraw(1000);

        assertEquals(result.isSuccessful(), false);
        assertEquals(result.operationAmount(), 1000);
        assertEquals(result.balanceAfterOperation(), 500);
    }

    @Test
    public void successfulBalance() {
        BankAccountContract bankAccount = new TaskBankAccount(1500);

        OperationResult result = bankAccount.balance();

        assertEquals(result.isSuccessful(), true);
        assertEquals(result.operationAmount(), 0);
        assertEquals(result.balanceAfterOperation(), 1500);
    }
}