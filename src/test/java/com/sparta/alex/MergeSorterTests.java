package com.sparta.alex;

import com.sparta.alex.exceptions.ArrayTooSmallException;
import com.sparta.alex.exceptions.EmptyArrayException;
import com.sparta.alex.sorters.MergeSorter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MergeSorterTests {

    private MergeSorter mergeSorter = null;

    @BeforeEach
    void setup() {
        mergeSorter = new MergeSorter();
    }

    @Test
    void sortTest() throws EmptyArrayException, ArrayTooSmallException {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, mergeSorter.sortArray(new int[]{5, 2, 1, 4, 3}));
    }

    @Test
    void nullTest() {
        Exception exception = assertThrows(NullPointerException.class, () -> mergeSorter.sortArray(null));
        assertEquals("Array is null!", exception.getMessage());
    }

    @Test
    void emptyArrayTest() {
        Exception exception = assertThrows(EmptyArrayException.class, () -> mergeSorter.sortArray(new int[]{}));
        assertEquals("Empty array!", exception.getMessage());
    }

    @Test
    void shortArrayTest() {
        Exception exception = assertThrows(ArrayTooSmallException.class, () -> mergeSorter.sortArray(new int[]{1}));
        assertEquals("Array must be larger than one!", exception.getMessage());
    }

}
