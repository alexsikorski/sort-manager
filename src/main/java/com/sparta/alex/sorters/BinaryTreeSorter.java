package com.sparta.alex.sorters;

import com.sparta.alex.binarytree.BinaryTree;
import com.sparta.alex.binarytree.Node;
import com.sparta.alex.exceptions.ArrayTooSmallException;
import com.sparta.alex.exceptions.ChildNotFoundException;
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
            // TODO sorter code
            BinaryTreeImpl binaryTree = new BinaryTreeImpl();

            binaryTree.addElements(array);

            System.out.println(binaryTree.getRootElement());

        }

        return new int[0];
    }

    private class BinaryTreeImpl implements BinaryTree {
        private Node rootNode = null;

        @Override
        public int getRootElement() {
            return rootNode.value;
        }

        @Override
        public int getNumberOfElements() {
            return 0;
        }

        @Override
        public Node addElement(Node currentNode, int element) {
            // recursive method
            if (currentNode == null){
                // if current node doesnt exist, make first element root node
                return new Node(element);
            }
            // start with left
            if (currentNode.value > element) {
                // if current node number > number from array
                currentNode.left = addElement(currentNode.left, element);
                // set left (child) node
            }
            else if (currentNode.value < element){
                // if current value < element
                currentNode.right = addElement(currentNode.right, element);
                // set right (child) node
            }
            else {
                // node (number) already exists, no duplicates allowed
                return currentNode;
            }
            return currentNode;
        }

        @Override
        public void addElements(int[] elements) {
            for (int element: elements) {
                rootNode = addElement(rootNode, element);
            }
        }

        @Override
        public boolean findElement(int value) {
            return false;
        }

        @Override
        public int getLeftChild(int element) throws ChildNotFoundException {
            return 0;
        }

        @Override
        public int getRightChild(int element) throws ChildNotFoundException {
            return 0;
        }

        @Override
        public int[] getSortedTreeAsc() {
            return new int[0];
        }

        @Override
        public int[] getSortedTreeDesc() {
            return new int[0];
        }
    }
}
