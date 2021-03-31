package com.sparta.alex.sorters;

import com.sparta.alex.exceptions.ArrayTooSmallException;
import com.sparta.alex.exceptions.EmptyArrayException;

public interface Sorter {
    int[] sortArray(int[] arrayToSort) throws EmptyArrayException, ArrayTooSmallException;
}
