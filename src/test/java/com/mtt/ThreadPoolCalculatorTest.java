package com.mtt;

import com.mtt.util.ListFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ThreadPoolCalculatorTest {
    private ThreadPoolCalculator calculator;

    @BeforeEach
    public void setUp(){
        calculator = new ThreadPoolCalculator();
    }

    @Test
    public void sum() {
        List<Integer> list = ListFactory.createIntegerList();
        Integer expected = list.stream().reduce(0, Integer::sum);
        Integer actual = calculator.sum(list);
        assertEquals(expected, actual);
    }

    @Test
    public void sumEmpty(){
        List<Integer> list = new ArrayList<>();
        Integer expected = 0;
        Integer actual = calculator.sum(list);
        assertEquals(expected, actual);
    }

    @Test
    public void checkNull(){
        Integer expected = 0;
        Integer actual = calculator.sum(null);
        assertEquals(expected, actual);
    }
}
