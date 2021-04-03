package com.sparta.alex;

import com.sparta.alex.exceptions.ArrayTooSmallException;
import com.sparta.alex.exceptions.EmptyArrayException;
import com.sparta.alex.factory.SorterFactory;
import com.sparta.alex.factory.SorterTypes;
import com.sparta.alex.sorters.Sorter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
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

    private static int[] uniqueSmallSample = null;
    private static int[] uniqueMediumSample = null;
    private static int[] uniqueLargeSample = null;

    private static final int SMALL = 1000;
    private static final int MEDIUM = 5000;
    private static final int LARGE = 15000;

    @BeforeAll
    static void init(){
        uniqueSmallSample = uniqueIntegerArray("small");
        uniqueMediumSample = uniqueIntegerArray("medium");
        uniqueLargeSample = uniqueIntegerArray("large");
    }

    @BeforeEach
    void setup() {
        SorterFactory sorterFactory = new SorterFactory();
        bubbleSorter = sorterFactory.getSorter(SorterTypes.BUBBLE_SORTER);
        mergeSorter = sorterFactory.getSorter(SorterTypes.MERGE_SORTER);
        binaryTreeSorter = sorterFactory.getSorter(SorterTypes.BINARY_TREE_SORTER);

        smallSample = IntStream.generate(() -> new Random().nextInt(SMALL)).limit(SMALL).toArray();
        mediumSample = IntStream.generate(() -> new Random().nextInt(MEDIUM)).limit(MEDIUM).toArray();
        largeSample = IntStream.generate(() -> new Random().nextInt(LARGE)).limit(LARGE).toArray();
    }

    // Bubble Sorter Tests
    @Test
    void bubbleSortSmallSample() throws ArrayTooSmallException, EmptyArrayException {
        long start = System.nanoTime();
        assertEquals(SMALL, bubbleSorter.sortArray(smallSample).length);
        long end = System.nanoTime();
        float timeTaken = (end - start) / 1000000000f;
        System.out.println(bubbleSorter.getClass().getName() + " || SMALL SAMPLE || time taken: " + timeTaken + "s.");
    }

    @Test
    void bubbleSortMediumSample() throws ArrayTooSmallException, EmptyArrayException {
        long start = System.nanoTime();
        assertEquals(MEDIUM, bubbleSorter.sortArray(mediumSample).length);
        long end = System.nanoTime();
        float timeTaken = (end - start) / 1000000000f;
        System.out.println(bubbleSorter.getClass().getName() + " || MEDIUM SAMPLE || time taken: " + timeTaken + "s.");
    }

    @Test
    void bubbleSortLargeSample() throws ArrayTooSmallException, EmptyArrayException {
        long start = System.nanoTime();
        assertEquals(LARGE, bubbleSorter.sortArray(largeSample).length);
        long end = System.nanoTime();
        float timeTaken = (end - start) / 1000000000f;
        System.out.println(bubbleSorter.getClass().getName() + " || LARGE SAMPLE || time taken: " + timeTaken + "s.");
    }

    // Merge Sorter Tests
    @Test
    void mergeSortSmallSample() throws ArrayTooSmallException, EmptyArrayException {
        long start = System.nanoTime();
        assertEquals(SMALL, mergeSorter.sortArray(smallSample).length);
        long end = System.nanoTime();
        float timeTaken = (end - start) / 1000000000f;
        System.out.println(mergeSorter.getClass().getName() + " || SMALL SAMPLE || time taken: " + timeTaken + "s.");
    }

    @Test
    void mergeSortMediumSample() throws ArrayTooSmallException, EmptyArrayException {
        long start = System.nanoTime();
        assertEquals(MEDIUM, mergeSorter.sortArray(mediumSample).length);
        long end = System.nanoTime();
        float timeTaken = (end - start) / 1000000000f;
        System.out.println(mergeSorter.getClass().getName() + " || MEDIUM SAMPLE || time taken: " + timeTaken + "s.");
    }

    @Test
    void mergeSortLargeSample() throws ArrayTooSmallException, EmptyArrayException {
        long start = System.nanoTime();
        assertEquals(LARGE, mergeSorter.sortArray(largeSample).length);
        long end = System.nanoTime();
        float timeTaken = (end - start) / 1000000000f;
        System.out.println(mergeSorter.getClass().getName() + " || LARGE SAMPLE || time taken: " + timeTaken + "s.");
    }

    // Binary Tree Sort Tests
    @Test
    void binaryTreeSortSmallSample() throws ArrayTooSmallException, EmptyArrayException {
        long start = System.nanoTime();
        assertEquals(SMALL, binaryTreeSorter.sortArray(uniqueSmallSample).length);
        long end = System.nanoTime();
        float timeTaken = (end - start) / 1000000000f;
        System.out.println(binaryTreeSorter.getClass().getName() + " || SMALL SAMPLE || time taken: " + timeTaken + "s.");
    }

    @Test
    void binaryTreeSortMediumSample() throws ArrayTooSmallException, EmptyArrayException {
        long start = System.nanoTime();
        assertEquals(MEDIUM, binaryTreeSorter.sortArray(uniqueMediumSample).length);
        long end = System.nanoTime();
        float timeTaken = (end - start) / 1000000000f;
        System.out.println(binaryTreeSorter.getClass().getName() + " || MEDIUM SAMPLE || time taken: " + timeTaken + "s.");
    }

    @Test
    void binaryTreeLargeSample() throws ArrayTooSmallException, EmptyArrayException {
        long start = System.nanoTime();
        assertEquals(LARGE, binaryTreeSorter.sortArray(uniqueLargeSample).length);
        long end = System.nanoTime();
        float timeTaken = (end - start) / 1000000000f;
        System.out.println(binaryTreeSorter.getClass().getName() + " || LARGE SAMPLE || time taken: " + timeTaken + "s.");
    }

    private static int[] uniqueIntegerArray(String sampleSize){
        // array to be used with binary tree must have unique integers
        HashSet<Integer> set = new HashSet<>();
        switch (sampleSize){
            case "small":
                do {
                    set.add(new Random().nextInt(SMALL));
                }
                while (set.size() < SMALL);
                break;
            case "medium":
                do {
                    set.add(new Random().nextInt(MEDIUM));
                }
                while (set.size() < MEDIUM);
                break;
            case "large":
                do {
                    set.add(new Random().nextInt(LARGE));
                }
                while (set.size() < LARGE);
                break;
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

}
