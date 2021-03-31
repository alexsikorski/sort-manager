package com.sparta.alex.factory;

import com.sparta.alex.algorithms.BubbleSort;
import com.sparta.alex.algorithms.MergeSort;
import com.sparta.alex.interfaces.Sorter;

public class SorterFactory {

    public Sorter getSorter(SorterTypes sortTypes) {
        if (sortTypes.equals(SorterTypes.BUBBLE_SORT)) {
            return new BubbleSort();
        } else if (sortTypes.equals(SorterTypes.MERGE_SORT)) {
            return new MergeSort();
        }
        return null;
    }
}
