package com.mtt;

import java.util.List;
import java.util.concurrent.Callable;

public class SumCallable implements Callable<Integer> {
    private List<Integer> integers;

    public SumCallable(List<Integer> integers) {
        this.integers = integers;
    }

    @Override
    public Integer call() throws Exception {
        return integers.stream().reduce(0, Integer::sum);
    }
}
