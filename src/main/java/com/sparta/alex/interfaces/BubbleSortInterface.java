package com.sparta.alex.interfaces;

import com.sparta.alex.exceptions.EmptyArrayException;

public interface BubbleSortInterface {
    int[] sortArray(int[] arrayToSort) throws EmptyArrayException;
}
