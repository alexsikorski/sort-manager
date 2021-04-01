package com.sparta.alex.factory;

import com.sparta.alex.sorters.BubbleSorter;
import com.sparta.alex.sorters.MergeSorter;
import com.sparta.alex.sorters.Sorter;

public class SorterFactory {

    public Sorter getSorter(SorterTypes sortTypes) {
        Sorter sorter = null;
        switch (sortTypes) {
            case BUBBLE_SORT:
                sorter = BubbleSorter.getInstance();
                break;
            case MERGE_SORT:
                sorter = MergeSorter.getInstance();
                break;
            default:
                break;
        }
        return sorter;
    }
}
