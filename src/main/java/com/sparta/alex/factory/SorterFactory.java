package com.sparta.alex.factory;

import com.sparta.alex.sorters.BubbleSorter;
import com.sparta.alex.sorters.MergeSorter;
import com.sparta.alex.sorters.Sorter;

public class SorterFactory {

    public Sorter getSorter(SorterTypes sortTypes) {
        if (sortTypes.equals(SorterTypes.BUBBLE_SORT)) {
            return new BubbleSorter();
        } else if (sortTypes.equals(SorterTypes.MERGE_SORT)) {
            return new MergeSorter();
        }
        return null;
    }
}
