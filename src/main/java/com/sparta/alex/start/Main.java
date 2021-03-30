package com.sparta.alex.start;

import com.sparta.alex.sort.BubbleSort;
import com.sparta.alex.sort.MergeSort;
import com.sparta.alex.util.Logging;
import com.sparta.alex.util.Printer;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Printer printer = new Printer();

        // Bubble Sort
        printer.print(Arrays.toString(new BubbleSort().sortArray(new int[]{2, 4, 5, 12, 2, 323, 56, 3, 2, 1, 5, 66, 7, 43, 2, 1, 45, 6})));
        printer.print(Arrays.toString(new BubbleSort().sortArray(new int[]{1, 2, 3, 4, 5})));
        printer.print((Arrays.toString(new BubbleSort().sortArray(new int[]{}))));

        // Merge Sort
        MergeSort mergeSort = new MergeSort();

        int[] testArray = {5, 1, 6, 2, 3, 4};

        mergeSort.sortArray(testArray, testArray.length);
        System.out.println(Arrays.toString(testArray));

        // Logging test
        Logging.runExceptions();

    }
}
