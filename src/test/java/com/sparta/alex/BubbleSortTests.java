package com.sparta.alex;

import com.sparta.alex.exceptions.EmptyArrayException;
import com.sparta.alex.sort.BubbleSort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BubbleSortTests {

    private final BubbleSort bubbleSort = new BubbleSort();

    @Test
    void sortTest() throws EmptyArrayException {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, bubbleSort.sortArray(new int[]{5, 2, 1, 4, 3}));
    }

    @Test
    void nullTest(){
        Exception exception = assertThrows(NullPointerException.class, () -> bubbleSort.sortArray(null));
        assertEquals("Array is null!", exception.getMessage());
    }

    @Test
    void emptyArrayTest(){
        Exception exception = assertThrows(EmptyArrayException.class, () -> bubbleSort.sortArray(new int[]{}));
        assertEquals("Empty array!", exception.getMessage());
    }
}
