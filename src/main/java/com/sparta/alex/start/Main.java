package com.sparta.alex.start;

import com.sparta.alex.exceptions.ArrayTooSmallException;
import com.sparta.alex.exceptions.EmptyArrayException;
import com.sparta.alex.factory.SorterFactory;
import com.sparta.alex.factory.SorterTypes;
import com.sparta.alex.interfaces.Sorter;
import com.sparta.alex.util.Printer;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws EmptyArrayException, ArrayTooSmallException {

        Printer printer = new Printer();
        SorterFactory sortFactory = new SorterFactory();
        Sorter bubbleSort = sortFactory.getSorter(SorterTypes.BUBBLE_SORT);
        Sorter mergeSort = sortFactory.getSorter(SorterTypes.MERGE_SORT);

        int[] testArray = new int[]{2, 5, 1, 4, 3};

        printer.print("Bubble sort: " + Arrays.toString(bubbleSort.sortArray(testArray)));
        printer.print("Merge sort: " + Arrays.toString(mergeSort.sortArray(testArray)));
    }
}
