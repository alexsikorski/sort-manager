package com.sparta.alex.sorters;

import com.sparta.alex.exceptions.ArrayTooSmallException;
import com.sparta.alex.exceptions.EmptyArrayException;

public class BinaryTreeSort implements Sorter {

    private static final BinaryTreeSort BINARY_TREE_SORTER_INSTANCE = new BinaryTreeSort();

    private BinaryTreeSort() {
    }

    public static Sorter getInstance() {
        return BINARY_TREE_SORTER_INSTANCE;
    }

    @Override
    public int[] sortArray(int[] arrayToSort) throws EmptyArrayException, ArrayTooSmallException {
        return new int[0];
    }
}
