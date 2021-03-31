package com.sparta.alex.algorithms;

import com.sparta.alex.interfaces.MergeSortInterface;

public class MergeSort implements MergeSortInterface {

    public static void merge(int[] array, int[] leftArray, int[] rightArray, int leftPos, int rightPos) {

        int i = 0, j = 0, k = 0;

        while (i < leftPos && j < rightPos) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }
        while (i < leftPos) {
            array[k++] = leftArray[i++];
        }
        while (j < rightPos) {
            array[k++] = rightArray[j++];
        }
    }

    @Override
    public int[] sortArray(int[] arrayToSort) {
        splitThenMergeArray(arrayToSort, arrayToSort.length);
        return arrayToSort;
    }

    public void splitThenMergeArray(int[] originalArray, int arrayLength) {
        // Return recursive method when array gets broken down to single numbers
        if (arrayLength < 2) {
            return;
        }
        int midPoint = arrayLength / 2;
        int[] leftArray = new int[midPoint];
        int[] rightArray = new int[arrayLength - midPoint];

        // Copying arrays in left/right array
        for (int i = 0; i < midPoint; i++) {
            leftArray[i] = originalArray[i];
        }
        for (int i = midPoint; i < arrayLength; i++) {
            rightArray[i - midPoint] = originalArray[i];
        }
        splitThenMergeArray(leftArray, midPoint);
        splitThenMergeArray(rightArray, arrayLength - midPoint);

        merge(originalArray, leftArray, rightArray, midPoint, arrayLength - midPoint);
    }
}