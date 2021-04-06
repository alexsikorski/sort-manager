package com.sparta.alex;

import com.sparta.alex.exceptions.ArrayTooSmallException;
import com.sparta.alex.exceptions.EmptyArrayException;
import com.sparta.alex.factory.SorterFactory;
import com.sparta.alex.factory.SorterTypes;
import com.sparta.alex.sorters.Sorter;
import com.sparta.alex.util.Printer;
import com.sparta.alex.util.TestTimer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static com.sparta.alex.util.ArraySampleGenerator.uniqueIntegerArray;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PerformanceTests {

    private static final int SMALL = 1000;
    private static final int MEDIUM = 5000;
    private static final int LARGE = 15000;
    private static int[] uniqueSmallSample = null;
    private static int[] uniqueMediumSample = null;
    private static int[] uniqueLargeSample = null;
    private static String resultMergeS = "";
    private static String resultMergeM = "";
    private static String resultMergeL = "";
    private static String resultBubbleS = "";
    private static String resultBubbleM = "";
    private static String resultBubbleL = "";
    private static String resultBinaryS = "";
    private static String resultBinaryM = "";
    private static String resultBinaryL = "";
    private Sorter bubbleSorter = null;
    private Sorter mergeSorter = null;
    private Sorter binaryTreeSorter = null;
    private int[] smallSample = null;
    private int[] mediumSample = null;
    private int[] largeSample = null;

    @BeforeAll
    static void init() {
        uniqueSmallSample = uniqueIntegerArray(SMALL);
        uniqueMediumSample = uniqueIntegerArray(MEDIUM);
        uniqueLargeSample = uniqueIntegerArray(LARGE);
    }

    @AfterAll
    static void printResults() {
        Printer printer = new Printer();
        printer.print("-- Performance testing for all sorters --\n" + resultBubbleS);
        printer.print(resultBubbleM);
        printer.print(resultBubbleL);
        printer.print("\n" + resultMergeS);
        printer.print(resultMergeM);
        printer.print(resultMergeL);
        printer.print("\n" + resultBinaryS);
        printer.print(resultBinaryM);
        printer.print(resultBinaryL + "\n");
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
        TestTimer timer = new TestTimer();
        timer.start();
        assertEquals(SMALL, bubbleSorter.sortArray(smallSample).length);
        float timeTaken = timer.end();
        resultBubbleS = "BubbleSorter SMALL(" + SMALL + "): " + timeTaken + "ms.";

    }

    @Test
    void bubbleSortMediumSample() throws ArrayTooSmallException, EmptyArrayException {
        TestTimer timer = new TestTimer();
        timer.start();
        assertEquals(MEDIUM, bubbleSorter.sortArray(mediumSample).length);
        float timeTaken = timer.end();
        resultBubbleM = "BubbleSorter MEDIUM(" + MEDIUM + "): " + timeTaken + "ms.";
    }

    @Test
    void bubbleSortLargeSample() throws ArrayTooSmallException, EmptyArrayException {
        TestTimer timer = new TestTimer();
        timer.start();
        assertEquals(LARGE, bubbleSorter.sortArray(largeSample).length);
        float timeTaken = timer.end();
        resultBubbleL = "BubbleSorter LARGE(" + LARGE + "): " + timeTaken + "ms.";
    }

    // Merge Sorter Tests
    @Test
    void mergeSortSmallSample() throws ArrayTooSmallException, EmptyArrayException {
        TestTimer timer = new TestTimer();
        timer.start();
        assertEquals(SMALL, mergeSorter.sortArray(smallSample).length);
        float timeTaken = timer.end();
        resultMergeS = "MergeSorter SMALL(" + SMALL + "): " + timeTaken + "ms.";
    }

    @Test
    void mergeSortMediumSample() throws ArrayTooSmallException, EmptyArrayException {
        TestTimer timer = new TestTimer();
        timer.start();
        assertEquals(MEDIUM, mergeSorter.sortArray(mediumSample).length);
        float timeTaken = timer.end();
        resultMergeM = "MergeSorter MEDIUM(" + MEDIUM + "): " + timeTaken + "ms.";
    }

    @Test
    void mergeSortLargeSample() throws ArrayTooSmallException, EmptyArrayException {
        TestTimer timer = new TestTimer();
        timer.start();
        assertEquals(LARGE, mergeSorter.sortArray(largeSample).length);
        float timeTaken = timer.end();
        resultMergeL = "MergeSorter LARGE(" + LARGE + "): " + timeTaken + "ms.";
    }

    // Binary Tree Sort Tests
    @Test
    void binaryTreeSortSmallSample() throws ArrayTooSmallException, EmptyArrayException {
        TestTimer timer = new TestTimer();
        timer.start();
        assertEquals(SMALL, binaryTreeSorter.sortArray(uniqueSmallSample).length);
        float timeTaken = timer.end();
        resultBinaryS = "BinarySorter SMALL(" + SMALL + "): " + timeTaken + "ms.";
    }

    @Test
    void binaryTreeSortMediumSample() throws ArrayTooSmallException, EmptyArrayException {
        TestTimer timer = new TestTimer();
        timer.start();
        assertEquals(MEDIUM, binaryTreeSorter.sortArray(uniqueMediumSample).length);
        float timeTaken = timer.end();
        resultBinaryM = "BinarySorter MEDIUM(" + MEDIUM + "): " + timeTaken + "ms.";
    }

    @Test
    void binaryTreeLargeSample() throws ArrayTooSmallException, EmptyArrayException {
        TestTimer timer = new TestTimer();
        timer.start();
        assertEquals(LARGE, binaryTreeSorter.sortArray(uniqueLargeSample).length);
        float timeTaken = timer.end();
        resultBinaryL = "BinarySorter LARGE(" + LARGE + "): " + timeTaken + "ms.";
    }
}
