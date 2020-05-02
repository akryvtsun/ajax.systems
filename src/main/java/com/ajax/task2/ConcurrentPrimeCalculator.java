package com.ajax.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class ConcurrentPrimeCalculator extends PrimeCalculatorContract {

    @Override
    public List<Integer> returnAllPrimeNumbers(int limit) {
        List<Integer> primeNumbers = new CopyOnWriteArrayList<>();

        List<Thread> threads = new ArrayList<>(limit / 2 + 1);
        for (int i = 2; i <= limit; i++) {
            Thread thread = new Thread(new Worker(primeNumbers, i));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return primeNumbers;
    }

    private final class Worker implements Runnable {
        private final List<Integer> list;
        private final int candidate;

        public Worker(List<Integer> list, int candidat) {
            this.list = list;
            this.candidate = candidat;
        }

        @Override
        public void run() {
            if (isPrime(candidate))
                list.add(candidate);
        }
    }
}
