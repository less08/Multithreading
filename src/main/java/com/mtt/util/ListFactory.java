package com.mtt.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListFactory {
    public static List<Integer> createIntegerList() {
        return IntStream.range(0, 1000000)
            .boxed()
            .collect(Collectors.toList());
    }
}
