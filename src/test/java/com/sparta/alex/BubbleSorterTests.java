package com.sparta.alex;

import com.sparta.alex.exceptions.ArrayTooSmallException;
import com.sparta.alex.exceptions.EmptyArrayException;
import com.sparta.alex.factory.SorterFactory;
import com.sparta.alex.factory.SorterTypes;
import com.sparta.alex.sorters.Sorter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BubbleSorterTests {

    private Sorter bubbleSorter = null;

    @BeforeEach
    void setup() {
        SorterFactory sorterFactory = new SorterFactory();
        bubbleSorter = sorterFactory.getSorter(SorterTypes.BUBBLE_SORT);
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

    @Test
    void shortArrayTest() {
        Exception exception = assertThrows(ArrayTooSmallException.class, () -> bubbleSorter.sortArray(new int[]{1}));
        assertEquals("Array must be larger than one!", exception.getMessage());
    }
}
