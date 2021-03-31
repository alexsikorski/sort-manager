package com.sparta.alex.start;

import com.sparta.alex.algorithms.BubbleSort;
import com.sparta.alex.algorithms.MergeSort;
import com.sparta.alex.exceptions.EmptyArrayException;
import com.sparta.alex.util.Printer;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws EmptyArrayException {
        Printer printer = new Printer();

        // Bubble Sort
        printer.print(Arrays.toString(new BubbleSort().sortArray(new int[]{2, 4, 5, 12, 2, 323, 56, 3, 2, 1, 5, 66, 7, 43, 2, 1, 45, 6})));
        printer.print(Arrays.toString(new BubbleSort().sortArray(new int[]{1, 2, 3, 4, 5})));
        // Logging test/error test
        try {
            printer.print((Arrays.toString(new BubbleSort().sortArray(new int[]{}))));
        } catch (Exception e) {
            System.out.println(e);
        }
        // Null test
        try {
            printer.print((Arrays.toString(new BubbleSort().sortArray(null))));
        } catch (Exception e) {
            System.out.println(e);
        }

        // Merge Sort
        System.out.println(Arrays.toString(new MergeSort().sortArray(new int[]{1, 5, 10, 2})));
    }
}
