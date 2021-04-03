package com.sparta.alex;

import com.sparta.alex.binarytree.BinaryTreeImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreeImplPerformanceTests {

    private static BinaryTreeImpl binaryTreeSmall = null;
    private static BinaryTreeImpl binaryTreeMedium = null;
    private static BinaryTreeImpl binaryTreeLarge = null;

    private static final int SMALL = 1000;
    private static final int MEDIUM = 5000;
    private static final int LARGE = 15000;

    @BeforeAll
    static void setup() {
        binaryTreeSmall = new BinaryTreeImpl();
        binaryTreeMedium = new BinaryTreeImpl();
        binaryTreeLarge = new BinaryTreeImpl();

        binaryTreeSmall.addElements(uniqueIntegerArray("small"));
        binaryTreeMedium.addElements(uniqueIntegerArray("medium"));
        binaryTreeLarge.addElements(uniqueIntegerArray("large"));
    }

    @Test
    void getAscSmallTest(){
        long start = System.nanoTime();
        assertEquals(SMALL, binaryTreeSmall.getSortedTreeAsc().length);
        long end = System.nanoTime();
        float timeTaken = (end - start) / 1000000f;
        System.out.println("ASC SMALL(" + SMALL + "): " + timeTaken + "ms.");
    }

    @Test
    void getAscMediumTest(){
        long start = System.nanoTime();
        assertEquals(MEDIUM, binaryTreeMedium.getSortedTreeAsc().length);
        long end = System.nanoTime();
        float timeTaken = (end - start) / 1000000f;
        System.out.println("ASC MEDIUM(" + MEDIUM + "): " + timeTaken + "ms.");
    }

    @Test
    void getAscLargeTest(){
        long start = System.nanoTime();
        assertEquals(LARGE, binaryTreeLarge.getSortedTreeAsc().length);
        long end = System.nanoTime();
        float timeTaken = (end - start) / 1000000f;
        System.out.println("ASC LARGE(" + LARGE + "): " + timeTaken + "ms.");
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
}
