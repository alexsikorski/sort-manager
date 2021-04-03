package com.sparta.alex.sorters;

import com.sparta.alex.exceptions.ArrayTooSmallException;
import com.sparta.alex.exceptions.EmptyArrayException;
import com.sparta.alex.start.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MergeSorter implements Sorter {

    public static final Logger logger = LogManager.getLogger(Main.class);

    private static final MergeSorter MERGE_SORTER_INSTANCE = new MergeSorter();

    private MergeSorter() {
    }

    public static Sorter getInstance() {
        return MERGE_SORTER_INSTANCE;
    }

    public static void mergeArray(int[] array, int[] leftArray, int[] rightArray, int leftPos, int rightPos) { // CALLED IN splitThenMerge
        // FIRST as splitThenMergeArray [1] [5] had been called first, return statement takes us to merge with these values
        // originalArray={1, 5, 10, 2}, leftArray=[1], rightArray=[5], leftPos=0/2=0, rightPos=1-0=1
        int i = 0, j = 0, z = 0;

        // FIRST i = 0, while 0 > 0 AND 1 > 0  ...so not true first merge
        while (leftPos > i && rightPos > j) {
            if (rightArray[j] >= leftArray[i]) {
                array[z++] = leftArray[i++];
            } else {
                array[z++] = rightArray[j++];
            }
        }
        // FIRST while 1 > 0 ...so true
        while (leftPos > i) {
            array[z++] = leftArray[i++]; // FIRST array[0] = leftArray[0], so [1, 5]
        }
        // FIRST i = 1, j = 0, z = 1

        // FIRST while 1 > 0 ...so true
        while (rightPos > j) {
            array[z++] = rightArray[j++]; // FIRST array[1] = rightArray[0] so [1, 5]
        }
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
            logger.trace("Using the Merge Sort algorithm...");
            splitThenMergeArray(array, array.length);
            return array;
        }
    }

    public void splitThenMergeArray(int[] originalArray, int arrayLength) { // START
        // recursive method when array gets broken down to single numbers
        // example array {1, 5, 10, 2}
        if (arrayLength < 2) { // array length 4 so no return 1st run
            return;
        }
        int midPoint = arrayLength / 2; // midpoint = 2
        int[] leftArray = new int[midPoint]; // left array instantiated with 2 [0, 0]
        int[] rightArray = new int[arrayLength - midPoint];  // right array instantiated with 4 - 2 = 2, so [0, 0]

        // Copying arrays in left/right array
        for (int i = 0; i < midPoint; i++) { // iterates from index 0 to 1, copies array content so [1, 5]
            leftArray[i] = originalArray[i];
        }
        for (int i = midPoint; i < arrayLength; i++) { // iterates from index 2 to 3, copies array content so [10, 2]
            rightArray[i - midPoint] = originalArray[i];
        }
        splitThenMergeArray(leftArray, midPoint); // splits left array again (recursive), as length is 2 it will split to [1] [5]
        splitThenMergeArray(rightArray, arrayLength - midPoint); // and [10] [2]
        // when having [1] [5] and [10] [2] merge methods gets called as breaks recursion through return
        mergeArray(originalArray, leftArray, rightArray, midPoint, arrayLength - midPoint); // GOTO Merge()
    }
}
