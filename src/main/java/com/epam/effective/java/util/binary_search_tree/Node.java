package com.epam.effective.java.util.binary_search_tree;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node {
    private int data;
    private Node left;
    private Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
