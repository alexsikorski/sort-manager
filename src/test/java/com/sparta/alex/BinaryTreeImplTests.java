package com.sparta.alex;

import com.sparta.alex.binarytree.BinaryTreeImpl;
import com.sparta.alex.exceptions.ChildNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeImplTests {
    private BinaryTreeImpl binaryTree = null;

    @BeforeEach
    void setup(){
        binaryTree = new BinaryTreeImpl();
        binaryTree.addElements(new int[]{5, 2, 1, 4, 3});
    }

    @Test
    void treeContainElementsTest(){
        assertTrue(binaryTree.findElement(5));
        assertTrue(binaryTree.findElement(2));
        assertTrue(binaryTree.findElement(1));
        assertTrue(binaryTree.findElement(4));
        assertTrue(binaryTree.findElement(3));
    }

    @Test
    void getRootElementTest(){
        assertEquals(5, binaryTree.getRootElement());
    }

    @Test
    void getNumberOfElements(){
        assertEquals(5, binaryTree.getElementCount());
    }

    @Test
    void addElementTest(){
        binaryTree.addElement(6);
        assertTrue(binaryTree.findElement(6));
        assertEquals(6, binaryTree.getElementCount());
    }

    @Test
    void addElementsTest(){
        binaryTree.addElements(new int[]{23, 34, 52});
        assertTrue(binaryTree.findElement(23));
        assertTrue(binaryTree.findElement(34));
        assertTrue(binaryTree.findElement(52));
        assertEquals(8, binaryTree.getElementCount());
    }

    @Test
    void findElementTest(){
        assertTrue(binaryTree.findElement(5));
        assertFalse(binaryTree.findElement(117));
        binaryTree.addElement(117);
        assertTrue(binaryTree.findElement(117));
    }

    @Test
    void getLeftChildTest() throws ChildNotFoundException {
        assertEquals(binaryTree.getRootNode().left, binaryTree.getLeftChild(2));
    }

    @Test
    void getRightChildTest() throws ChildNotFoundException {
        assertEquals(binaryTree.getRootNode().right, binaryTree.getRightChild(4));
    }

    @Test
    void getSortedTreeAscTest(){
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, binaryTree.getSortedTreeAsc());
    }

    @Test
    void getSortedTreeDescTest(){
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, binaryTree.getSortedTreeAsc());
    }
}
