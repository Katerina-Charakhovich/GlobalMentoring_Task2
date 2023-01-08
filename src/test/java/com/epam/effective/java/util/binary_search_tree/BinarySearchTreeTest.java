package com.epam.effective.java.util.binary_search_tree;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BinarySearchTreeTest {
    static BinarySearchTree tree;

    @BeforeClass
    public static void init() {
        tree = new BinarySearchTree();
        tree.setRoot(new Node(2));
        tree.insert(2);
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(1);
    }

    @Test
    public void insert() {
        tree.insert(11);
        Assert.assertNotNull(tree.search(11));
    }

    @Test
    public void delete() {
        tree.delete(5);
        Assert.assertNull(tree.search(5));
    }

    @Test
    public void minValue() {
        Assert.assertEquals(tree.minValue(tree.getRoot()),1);
    }

    @Test
    public void search() {
    }
}