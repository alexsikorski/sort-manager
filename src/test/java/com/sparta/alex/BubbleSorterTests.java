package com.sparta.alex;

import com.sparta.alex.exceptions.ArrayTooSmallException;
import com.sparta.alex.exceptions.EmptyArrayException;
import com.sparta.alex.sorters.BubbleSorter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BubbleSorterTests {

    private BubbleSorter bubbleSorter = null;

    @BeforeEach
    void setup() {
        bubbleSorter = new BubbleSorter();
    }

    @Test
    void sortTest() throws EmptyArrayException, ArrayTooSmallException {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, bubbleSorter.sortArray(new int[]{5, 2, 1, 4, 3}));
    }

    @Test
    void nullTest() {
        Exception exception = assertThrows(NullPointerException.class, () -> bubbleSorter.sortArray(null));
        assertEquals("Array is null!", exception.getMessage());
    }

    @Test
    void emptyArrayTest() {
        Exception exception = assertThrows(EmptyArrayException.class, () -> bubbleSorter.sortArray(new int[]{}));
        assertEquals("Empty array!", exception.getMessage());
    }
}
