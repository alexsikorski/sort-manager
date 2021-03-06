package com.sparta.alex;

import com.sparta.alex.binarytree.BinaryTreeImpl;
import com.sparta.alex.util.Printer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.sparta.alex.util.ArraySampleGenerator.uniqueIntegerArray;
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

        binaryTreeSmall.addElements(uniqueIntegerArray(SMALL));
        binaryTreeMedium.addElements(uniqueIntegerArray(MEDIUM));
        binaryTreeLarge.addElements(uniqueIntegerArray(LARGE));
    }

    @AfterAll
    static void printResults() {
        Printer printer = new Printer();
        printer.print("-- BinarySorter with elements already added --\n" + resultAscS);
        printer.print(resultAscM);
        printer.print(resultAscL + "\n");
        printer.print(resultDescS);
        printer.print(resultDescM);
        printer.print(resultDescL + "\n");

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
