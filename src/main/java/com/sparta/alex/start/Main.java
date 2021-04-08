package com.sparta.alex.start;

import com.sparta.alex.exceptions.ArrayTooSmallException;
import com.sparta.alex.exceptions.EmptyArrayException;
import com.sparta.alex.factory.SorterFactory;
import com.sparta.alex.factory.SorterTypes;
import com.sparta.alex.sorters.Sorter;
import com.sparta.alex.util.Printer;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws EmptyArrayException, ArrayTooSmallException {

        Printer printer = new Printer();
        SorterFactory sorterFactory = new SorterFactory();
        Sorter bubbleSorter = sorterFactory.getSorter(SorterTypes.BUBBLE_SORTER);
        Sorter mergeSorter = sorterFactory.getSorter(SorterTypes.MERGE_SORTER);
        Sorter binaryTreeSorter = sorterFactory.getSorter(SorterTypes.BINARY_TREE_SORTER);

        int[] testArray = new int[]{2, 5, 1, 4, 3};

        printer.print("Unsorted Array: " + Arrays.toString(testArray) + "\n");
        printer.print("Bubble sort: " + Arrays.toString(bubbleSorter.sortArray(testArray)));
        printer.print("Merge sort: " + Arrays.toString(mergeSorter.sortArray(testArray)));
        printer.print("Binary Tree sort: " + Arrays.toString(binaryTreeSorter.sortArray(testArray)));
    }
}
