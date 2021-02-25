package com.mtt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTask extends RecursiveTask<Integer> {
    private int threshHold;
    private List<Integer> list;

    public ForkJoinTask(List<Integer> list) {
        this.list = list;
        this.threshHold = list.size();
    }

    private ForkJoinTask(List<Integer> list, int threshHold) {
        this.list = list;
        this.threshHold = threshHold;
    }

    @Override
    public Integer compute() {
        if (list.size() > threshHold) {
            return ForkJoinTask.invokeAll(createSubtasks())
                .stream()
                .mapToInt(ForkJoinTask::join)
                .sum();
        }
        return processing(list);
    }

    private Collection<ForkJoinTask> createSubtasks() {
        List<ForkJoinTask> dividedTasks = new ArrayList<>();
        dividedTasks.add(new ForkJoinTask(list.subList(0, list.size() / 2), threshHold));
        dividedTasks.add(new ForkJoinTask(list.subList(list.size() / 2, list.size()), threshHold));
        return dividedTasks;
    }

    private Integer processing(List<Integer> values) {
        return values.stream().reduce(0, Integer::sum);
    }
}
