package com.sparta.alex;

import com.sparta.alex.binarytree.BinaryTreeImpl;
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
}
