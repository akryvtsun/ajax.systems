package com.ajax.task1;

public final class TaskBankAccount implements BankAccountContract {

    // bank account value in cents. Cannot be negative
    private volatile int account;

    public TaskBankAccount(int account) {
        this.account = account;
    }

    @Override
    public synchronized OperationResult withdraw(int amount) {
        if (account >= amount) {
            account -= amount;
            return new TaskOperationResult(true, amount, account);
        }
        else {
            return new TaskOperationResult(false, amount, account);
        }
    }

    @Override
    public synchronized OperationResult put(int amount) {
        account += amount;
        return new TaskOperationResult(true, amount, account);
    }

    @Override
    public OperationResult balance() {
        return new TaskOperationResult(true, 0, account);
    }
}
