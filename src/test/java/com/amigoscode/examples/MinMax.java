package com.amigoscode.examples;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class MinMax {

/** 08.01 - Finding Minimum Number
 *
 */
    @Test
    public void min() {
        List<Integer> numbers = List.of(1, 2, 3, 100, 23, 93, 99);
        int min = numbers.stream()
                .min((o1,o2) -> o1.compareTo(o2))
                .get();
        System.out.println(min);
    }

/** 08.01 - Finding Maximum Number
 *
 */
    @Test
    public void max() {
        List<Integer> numbers = List.of(1, 2, 3, 100, 23, 93, 99);
        int max = numbers.stream()
                .max((o1, o2) -> o1.compareTo(o2))
                .get();
        System.out.println(max);
    }
}
