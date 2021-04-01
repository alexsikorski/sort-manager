package com.sparta.alex;

import com.sparta.alex.exceptions.ArrayTooSmallException;
import com.sparta.alex.exceptions.EmptyArrayException;
import com.sparta.alex.factory.SorterFactory;
import com.sparta.alex.factory.SorterTypes;
import com.sparta.alex.sorters.Sorter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PerformanceTests {

    private Sorter bubbleSorter = null;
    private Sorter mergeSorter = null;
    private Sorter binaryTreeSorter = null;
    private int[] smallSample = null;
    private int[] mediumSample = null;
    private int[] largeSample = null;


    @BeforeEach
    void setup() {
        SorterFactory sorterFactory = new SorterFactory();
        bubbleSorter = sorterFactory.getSorter(SorterTypes.BUBBLE_SORTER);
        mergeSorter = sorterFactory.getSorter(SorterTypes.MERGE_SORTER);
        binaryTreeSorter = sorterFactory.getSorter(SorterTypes.BINARY_TREE_SORTER);
        smallSample = IntStream.generate(() -> new Random().nextInt(100)).limit(1000).toArray();
        mediumSample = IntStream.generate(() -> new Random().nextInt(100)).limit(10000).toArray();
        largeSample = IntStream.generate(() -> new Random().nextInt(100)).limit(100000).toArray();
    }

    @Test
    void bubbleSortSmallSample() throws ArrayTooSmallException, EmptyArrayException {
        long start = System.nanoTime();
        assertEquals(1000, bubbleSorter.sortArray(smallSample).length);
        long end = System.nanoTime();
        float timeTaken = (end - start) / 1000000000f;
        System.out.println(bubbleSorter.getClass().getName() + " || SMALL SAMPLE || time taken: " + timeTaken + "s.");
    }

    @Test
    void bubbleSortMediumSample() throws ArrayTooSmallException, EmptyArrayException {
        long start = System.nanoTime();
        assertEquals(10000, bubbleSorter.sortArray(mediumSample).length);
        long end = System.nanoTime();
        float timeTaken = (end - start) / 1000000000f;
        System.out.println(bubbleSorter.getClass().getName() + " || MEDIUM SAMPLE || time taken: " + timeTaken + "s.");
    }

    @Test
    void bubbleSortLargeSample() throws ArrayTooSmallException, EmptyArrayException {
        long start = System.nanoTime();
        assertEquals(100000, bubbleSorter.sortArray(largeSample).length);
        long end = System.nanoTime();
        float timeTaken = (end - start) / 1000000000f;
        System.out.println(bubbleSorter.getClass().getName() + " || LARGE SAMPLE || time taken: " + timeTaken + "s.");
    }

    @Test
    void mergeSortSmallSample() throws ArrayTooSmallException, EmptyArrayException {
        long start = System.nanoTime();
        assertEquals(1000, mergeSorter.sortArray(smallSample).length);
        long end = System.nanoTime();
        float timeTaken = (end - start) / 1000000000f;
        System.out.println(mergeSorter.getClass().getName() + " || SMALL SAMPLE || time taken: " + timeTaken + "s.");
    }

    @Test
    void mergeSortMediumSample() throws ArrayTooSmallException, EmptyArrayException {
        long start = System.nanoTime();
        assertEquals(10000, mergeSorter.sortArray(mediumSample).length);
        long end = System.nanoTime();
        float timeTaken = (end - start) / 1000000000f;
        System.out.println(mergeSorter.getClass().getName() + " || MEDIUM SAMPLE || time taken: " + timeTaken + "s.");
    }

    @Test
    void mergeSortLargeSample() throws ArrayTooSmallException, EmptyArrayException {
        long start = System.nanoTime();
        assertEquals(100000, mergeSorter.sortArray(largeSample).length);
        long end = System.nanoTime();
        float timeTaken = (end - start) / 1000000000f;
        System.out.println(mergeSorter.getClass().getName() + " || LARGE SAMPLE || time taken: " + timeTaken + "s.");
    }

    @Test
    void binaryTreeSortSmallSample() throws ArrayTooSmallException, EmptyArrayException {
        long start = System.nanoTime();
        assertEquals(1000, binaryTreeSorter.sortArray(smallSample).length);
        long end = System.nanoTime();
        float timeTaken = (end - start) / 1000000000f;
        System.out.println(binaryTreeSorter.getClass().getName() + " || SMALL SAMPLE || time taken: " + timeTaken + "s.");
    }

    @Test
    void binaryTreeSortMediumSample() throws ArrayTooSmallException, EmptyArrayException {
        long start = System.nanoTime();
        assertEquals(10000, binaryTreeSorter.sortArray(mediumSample).length);
        long end = System.nanoTime();
        float timeTaken = (end - start) / 1000000000f;
        System.out.println(binaryTreeSorter.getClass().getName() + " || MEDIUM SAMPLE || time taken: " + timeTaken + "s.");
    }

    @Test
    void binaryTreeLargeSample() throws ArrayTooSmallException, EmptyArrayException {
        long start = System.nanoTime();
        assertEquals(100000, binaryTreeSorter.sortArray(largeSample).length);
        long end = System.nanoTime();
        float timeTaken = (end - start) / 1000000000f;
        System.out.println(binaryTreeSorter.getClass().getName() + " || LARGE SAMPLE || time taken: " + timeTaken + "s.");
    }

}
