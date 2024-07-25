package org.example;

import java.util.concurrent.RecursiveTask;

public class FactorialTask extends RecursiveTask<Integer> {
    private int number;

    public FactorialTask(int number) {
        this.number = number;
    }

    @Override
    protected Integer compute() {
        if (number <= 2) {
            return number;
        } else {
            FactorialTask subTask = new FactorialTask(number - 1);
            subTask.fork();
            return number * subTask.join();
        }
    }
}
