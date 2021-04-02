package com.sparta.alex.sorters;

import com.sparta.alex.binarytree.BinaryTreeImpl;
import com.sparta.alex.exceptions.ArrayTooSmallException;
import com.sparta.alex.exceptions.EmptyArrayException;
import com.sparta.alex.start.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BinaryTreeSorter implements Sorter {

    public static final Logger logger = LogManager.getLogger(Main.class);

    private static final BinaryTreeSorter BINARY_TREE_SORTER_INSTANCE = new BinaryTreeSorter();

    private BinaryTreeSorter() {
    }

    public static Sorter getInstance() {
        return BINARY_TREE_SORTER_INSTANCE;
    }

    @Override
    public int[] sortArray(int[] array) throws EmptyArrayException, ArrayTooSmallException {
        if (array == null) {
            logger.error("NullPointerException: Array is null!");
            throw new NullPointerException("Array is null!");
        } else if (array.length == 0) {
            logger.error("EmptyArrayException: Empty array!");
            throw new EmptyArrayException("Empty array!");
        } else if (array.length == 1) {
            logger.error("ArrayTooSmallException: Array must be larger than one!");
            throw new ArrayTooSmallException("Array must be larger than one!");
        } else {
            BinaryTreeImpl binaryTree = new BinaryTreeImpl();
            binaryTree.addElements(array);
            return binaryTree.getSortedTreeAsc();
        }
    }
}