package com.sparta.alex.factory;

import com.sparta.alex.sorters.BinaryTreeSorter;
import com.sparta.alex.sorters.BubbleSorter;
import com.sparta.alex.sorters.MergeSorter;
import com.sparta.alex.sorters.Sorter;

public class SorterFactory {

    public Sorter getSorter(SorterTypes sortTypes) {
        Sorter sorter = null;
        switch (sortTypes) {
            case BUBBLE_SORTER:
                sorter = BubbleSorter.getInstance();
                break;
            case MERGE_SORTER:
                sorter = MergeSorter.getInstance();
                break;
            case BINARY_TREE_SORTER:
                sorter = BinaryTreeSorter.getInstance();
                break;
            default:
                break;
        }
        return sorter;
    }
}
