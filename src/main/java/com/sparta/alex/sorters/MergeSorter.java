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
            sort(array, 0, array.length - 1);
            return array;
        }
    }

    private void sort(int[] array, int left, int right) {
        if (left < right) {
            // get middle point (adding left as stated to help with big numbers)
            int m = left + (right - left) / 2;

            // sort recursive for left array then right
            sort(array, left, m);
            sort(array, m + 1, right);

            // merge the sorted arrays
            merge(array, left, m, right);
        }
    }

    private void merge(int[] array, int left, int midPoint, int right) {
        // obtain sizes of both arrays
        int size1 = midPoint - left + 1;
        int size2 = right - midPoint;

        // temporary arrays
        int[] leftArray = new int[size1];
        int[] rightArray = new int[size2];

        // copy arrays
        for (int i = 0; i < size1; ++i)
            leftArray[i] = array[left + i];
        for (int j = 0; j < size2; ++j)
            rightArray[j] = array[midPoint + 1 + j];


        // then to merge, start index of left/right arrays
        int i = 0, j = 0;

        // initial index of merged array
        int k = left;
        while (i < size1 && j < size2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // copy any from L array if exists
        while (i < size1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // copy any from R array if exists
        while (j < size2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}