package com.sparta.alex;

import com.sparta.alex.exceptions.ArrayTooSmallException;
import com.sparta.alex.exceptions.EmptyArrayException;
import com.sparta.alex.sorters.BubbleSorter;
import com.sparta.alex.sorters.MergeSorter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Random;
import java.util.stream.IntStream;
import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.*;

public class PerformanceTests {

    private BubbleSorter bubbleSorter = null;
    private MergeSorter mergeSorter = null;
    private int[] smallSample = null;
    private int[] mediumSample = null;
    private int[] largeSample = null;


    @BeforeEach
    void setup() {
        bubbleSorter = new BubbleSorter();
        mergeSorter = new MergeSorter();
        smallSample = IntStream.generate(() -> new Random().nextInt(100)).limit(20).toArray();
        mediumSample = IntStream.generate(() -> new Random().nextInt(100)).limit(100).toArray();
        largeSample = IntStream.generate(() -> new Random().nextInt(100)).limit(10000).toArray();
    }

    @Test
    void bubbleSortSmallSample() throws ArrayTooSmallException, EmptyArrayException {
        long start = System.nanoTime();
        assertEquals(20, bubbleSorter.sortArray(smallSample).length);
        long end = System.nanoTime();
        float timeTaken = (end - start) / 1000000000f;
        System.out.println(bubbleSorter.getClass().getName() + " || SMALL SAMPLE || time taken: " + timeTaken + "s.");
    }
}
