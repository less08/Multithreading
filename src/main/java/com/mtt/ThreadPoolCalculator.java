package com.mtt;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolCalculator {
    public Integer sum(List<Integer> values) {
        if (values == null) {
            return 0;
        }

        int numberOfThreads = Runtime.getRuntime().availableProcessors();
        int groupSize = values.size() / numberOfThreads;
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
        List<Callable<Integer>> callables = new ArrayList<>();
        for (int i = 0; i < values.size(); i += groupSize) {
            List<Integer> group = (values.subList(i, Math.min(i + groupSize, values.size())));
            callables.add(new SumCallable(group));
        }
        try {
            List<Future<Integer>> futures = executor.invokeAll(callables);
            int sum = 0;
            for (Future<Integer> future : futures) {
                sum += future.get();
            }
            executor.shutdown();
            return sum;
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("Exception occurred during the calculation", e);
        }
    }
}
