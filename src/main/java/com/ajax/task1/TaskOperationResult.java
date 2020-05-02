package com.ajax.task1;

public final class TaskOperationResult implements OperationResult {

    private final boolean isSuccessful;
    private final int operationAmount;
    private final int balanceAmount;

    public TaskOperationResult(boolean isSuccessful, int operationAmount, int balanceAmount) {
        this.isSuccessful = isSuccessful;
        this.operationAmount = operationAmount;
        this.balanceAmount = balanceAmount;
    }

    @Override
    public boolean isSuccessful() {
        return isSuccessful;
    }

    @Override
    public int operationAmount() {
        return operationAmount;
    }

    @Override
    public int balanceAfterOperation() {
        return balanceAmount;
    }
}
