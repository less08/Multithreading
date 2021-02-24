package com.mtt;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

class ForkJoinCalculator {
    public Integer sum(List<Integer> values) {
        if (values == null) {
            return 0;
        }

        ForkJoinTask task = new ForkJoinTask(values);
        return new ForkJoinPool().invoke(task);
    }
}
