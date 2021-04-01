package com.sparta.alex.binarytree;

import com.sparta.alex.exceptions.ChildNotFoundException;

public class BinaryTreeImpl implements BinaryTree {
    Node rootNode = null;
    int elementCount = 0;

    public Node getRootNode() {
        return rootNode;
    }

    public Node addElementRecursive(Node currentNode, int value) {
        if (currentNode == null) {
            // if current node doesnt exist, make first value root node
            return new Node(value);
        }
        // start with left
        if (value < currentNode.value) {
            // if current node number > number from array
            currentNode.left = addElementRecursive(currentNode.left, value);
            // set left (child) node
        } else if (value > currentNode.value) {
            // if current value < value
            currentNode.right = addElementRecursive(currentNode.right, value);
            // set right (child) node
        } else {
            // node (number) already exists, no duplicates allowed
            return currentNode;
        }
        return currentNode;
    }

    private boolean findElementRecursive(Node currentNode, int value) {
        if (currentNode == null) {
            // if the current node does not exist
            return false;
        }
        if (currentNode.value == value) {
            // if current nodes value is value searching for
            return true;
        }
        // ternary operator or if statement (example provided for self teaching reasons)
        return currentNode.value > value ? findElementRecursive(currentNode.left, value) : findElementRecursive(currentNode.right, value);
//        if (currentNode.value > value){
//           return findElementRecursive(currentNode.left, value);
//        }
//        return findElementRecursive(currentNode.right, value);
    }

    private Integer findLeftChildRecursive(Node currentNode, int value) {
        if (currentNode == null) {
            return null;
        }
        if (currentNode.value == value && currentNode.left != null) {
            return currentNode.left.value;
        }
        return currentNode.value > value ? findLeftChildRecursive(currentNode.left, value) : findLeftChildRecursive(currentNode.right, value);
    }

    private Integer findRightChildRecursive(Node currentNode, int value) {
        if (currentNode == null) {
            return null;
        }
        if (currentNode.value == value && currentNode.right != null) {
            return currentNode.right.value;
        }
        return currentNode.value > value ? findRightChildRecursive(currentNode.left, value) : findRightChildRecursive(currentNode.right, value);
    }

    @Override
    public int getRootElement() {
        return rootNode.value;
    }

    @Override
    public int getNumberOfElements() {
        return elementCount;
    }

    @Override
    public void addElement(int element) {
        rootNode = addElementRecursive(rootNode, element);
        elementCount++;
    }

    @Override
    public void addElements(int[] elements) {
        for (int element : elements) {
            // start at root node
            rootNode = addElementRecursive(rootNode, element);
            elementCount++;
        }
    }

    @Override
    public boolean findElement(int value) {
        // start at root node
        return findElementRecursive(rootNode, value);
    }

    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {
        Integer integer = findLeftChildRecursive(rootNode, element);
        if (integer == null) {
            throw new ChildNotFoundException("Child not found!");
        }
        return integer;
    }

    @Override
    public int getRightChild(int element) throws ChildNotFoundException {
        Integer integer = findRightChildRecursive(rootNode, element);
        if (integer == null) {
            throw new ChildNotFoundException("Child not found!");
        }
        return integer;
    }

    @Override
    public int[] getSortedTreeAsc() {
        return new int[0];
    }

    @Override
    public int[] getSortedTreeDesc() {
        return new int[0];
    }


    // inner Node class
    public class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}