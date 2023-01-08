package com.epam.effective.java.util.binary_search_tree;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        this.root = null;

    }

    public void insert(int data) {
        root = insertRecursive(root, data);
    }

    private Node insertRecursive(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.getData())
            root.setLeft(insertRecursive(root.getLeft(), data));
        else if (data > root.getData())
            root.setRight(insertRecursive(root.getRight(), data));

        return root;
    }

    public void delete(int data) {
        root = deleteRecursive(root, data);
    }

    Node deleteRecursive(Node root, int data) {
        if (root == null) return root;
        if (root.getLeft() == null && root.getRight()==null) return null;
        if (data < root.getData()) {
            root.setLeft(deleteRecursive(root.getLeft(), data));
        } else {
            if (data > root.getData()) {
                root.setRight(deleteRecursive(root.getRight(), data));
            } else {
                if (root.getLeft() == null)
                    return root.getRight();
                else if (root.getRight() == null)
                    return root.getLeft();
                root.setData(minValue(root.getRight()));
                root.setRight(deleteRecursive(root.getRight(), root.getData()));
            }
        }
        return root;
    }

    int minValue(Node root) {
        int minval = root.getData();
        while (root.getLeft() != null) {
            minval = root.getLeft().getData();
            root = root.getLeft();
        }
        return minval;
    }

    public Node search(int data) {
        Node current = root;
        while (current.getData() != data) {
            if (current != null) {
                if (current.getData() > data) {
                    current = current.getLeft();
                } else {
                    current = current.getRight();
                }
                if (current == null) {
                    return null;
                }
            }
        }
        return current;
    }

    public void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.getLeft());
        System.out.print(node.getData() + " ");
        printInorder(node.getRight());
    }

    public void printPreorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getData() + " ");
        printInorder(node.getLeft());
        printInorder(node.getRight());
    }

    public void printPostorder(Node node) {
        if (node == null) {
            return;
        }
        printPostorder(node.getLeft());
        printPostorder(node.getRight());
        System.out.print(node.getData() + " ");
    }
}

