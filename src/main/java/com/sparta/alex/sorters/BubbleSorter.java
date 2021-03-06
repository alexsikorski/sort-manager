package com.sparta.alex.sorters;

import com.sparta.alex.exceptions.ArrayTooSmallException;
import com.sparta.alex.exceptions.EmptyArrayException;
import com.sparta.alex.start.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BubbleSorter implements Sorter {

    public static final Logger logger = LogManager.getLogger(Main.class);

    private static final BubbleSorter BUBBLE_SORTER_INSTANCE = new BubbleSorter();

    private BubbleSorter() {
    }

    public static Sorter getInstance() {
        return BUBBLE_SORTER_INSTANCE;
    }

    @Override
    public int[] sortArray(int[] array) throws EmptyArrayException, ArrayTooSmallException {
        if (array == null) {
            logger.error("NullPointerException: Array is null!");
            throw new NullPointerException("Array is null!");
        } else if (array.length == 0) {
            logger.error("EmptyArrayException: Empty array!");
            throw new EmptyArrayException("Empty array!");
        } else if (array.length == 1) {
            logger.error("ArrayTooSmallException: Array must be larger than one!");
            throw new ArrayTooSmallException("Array must be larger than one!");
        } else {
            logger.trace("Using the Bubble Sort algorithm...");
            for (int j = 0; j < array.length - 1; j++) {
                boolean hasSwapped = false;
                for (int i = 0; i < array.length - 1 - j; i++) {
                    int currentInteger = array[i];
                    int integerAhead = array[i + 1];
                    if (currentInteger > integerAhead) {
                        array[i] = integerAhead;
                        array[i + 1] = currentInteger;
                        hasSwapped = true;
                    } else {
                        array[i] = currentInteger;
                    }
                }
                if (!hasSwapped) {
                    return array;

                }
            }
        }
        return array;
    }
}
