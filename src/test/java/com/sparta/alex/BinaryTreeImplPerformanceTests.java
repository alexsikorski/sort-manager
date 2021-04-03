package com.sparta.alex;

import com.sparta.alex.binarytree.BinaryTreeImpl;
import com.sparta.alex.util.Printer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreeImplPerformanceTests {

    private static final int SMALL = 1000;
    private static final int MEDIUM = 5000;
    private static final int LARGE = 10000;
    static String resultAscS = "";
    static String resultAscM = "";
    static String resultAscL = "";
    static String resultDescS = "";
    static String resultDescM = "";
    static String resultDescL = "";
    private static BinaryTreeImpl binaryTreeSmall = null;
    private static BinaryTreeImpl binaryTreeMedium = null;
    private static BinaryTreeImpl binaryTreeLarge = null;

    @BeforeAll
    static void setup() {
        binaryTreeSmall = new BinaryTreeImpl();
        binaryTreeMedium = new BinaryTreeImpl();
        binaryTreeLarge = new BinaryTreeImpl();

        binaryTreeSmall.addElements(uniqueIntegerArray("small"));
        binaryTreeMedium.addElements(uniqueIntegerArray("medium"));
        binaryTreeLarge.addElements(uniqueIntegerArray("large"));
    }

    @AfterAll
    static void printResults() {
        Printer printer = new Printer();
        printer.print(resultAscS);
        printer.print(resultAscM);
        printer.print(resultAscL + "\n");
        printer.print(resultDescS);
        printer.print(resultDescM);
        printer.print(resultDescL);

    }

    private static int[] uniqueIntegerArray(String sampleSize) {
        // array to be used with binary tree must have unique integers
        HashSet<Integer> set = new HashSet<>();
        switch (sampleSize) {
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

    // ASC
    @Test
    void getAscSmallTest() {
        long start = System.nanoTime();
        assertEquals(SMALL, binaryTreeSmall.getSortedTreeAsc().length);
        long end = System.nanoTime();
        float timeTaken = (end - start) / 1000000f;
        resultAscS = "ASC SMALL(" + SMALL + "): " + timeTaken + "ms.";
    }

    @Test
    void getAscMediumTest() {
        long start = System.nanoTime();
        assertEquals(MEDIUM, binaryTreeMedium.getSortedTreeAsc().length);
        long end = System.nanoTime();
        float timeTaken = (end - start) / 1000000f;
        resultAscM = "ASC MEDIUM(" + MEDIUM + "): " + timeTaken + "ms.";
    }

    @Test
    void getAscLargeTest() {
        long start = System.nanoTime();
        assertEquals(LARGE, binaryTreeLarge.getSortedTreeAsc().length);
        long end = System.nanoTime();
        float timeTaken = (end - start) / 1000000f;
        resultAscL = "ASC LARGE(" + LARGE + "): " + timeTaken + "ms.";
    }

    // DESC
    @Test
    void getDescSmallTest() {
        long start = System.nanoTime();
        assertEquals(SMALL, binaryTreeSmall.getSortedTreeDesc().length);
        long end = System.nanoTime();
        float timeTaken = (end - start) / 1000000f;
        resultDescS = "DESC SMALL(" + SMALL + "): " + timeTaken + "ms.";
    }

    @Test
    void getDescMediumTest() {
        long start = System.nanoTime();
        assertEquals(MEDIUM, binaryTreeMedium.getSortedTreeDesc().length);
        long end = System.nanoTime();
        float timeTaken = (end - start) / 1000000f;
        resultDescM = "DESC MEDIUM(" + MEDIUM + "): " + timeTaken + "ms.";
    }

    @Test
    void getDescLargeTest() {
        long start = System.nanoTime();
        assertEquals(LARGE, binaryTreeLarge.getSortedTreeDesc().length);
        long end = System.nanoTime();
        float timeTaken = (end - start) / 1000000f;
        resultDescL = "DESC LARGE(" + LARGE + "): " + timeTaken + "ms.";
    }
}
