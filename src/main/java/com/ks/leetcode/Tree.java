package com.ks.leetcode;

import java.util.ArrayList;
import java.util.List;

class Node {

    static List<Integer> output = new ArrayList<Integer>();
    Integer value;
    Node left;
    Node right;

    Node(Integer value) {
        this.value = value;
        left = null;
        right = null;
    }

    public void insert(Node node) {

        if (this.value == node.value) {
            return;
        }
        if (node.value < this.value) {
            if (this.left != null) {
                this.left.insert(node);
            } else {
                this.left = node;
            }
        } else if (node.value > this.value) {
            if (this.right != null) {
                this.right.insert(node);
            } else {
                this.right = node;
            }
        }

    }

    public void inOrder() {

        if (this.left != null) {
            this.left.inOrder();
        }
        output.add(this.value);
        if (this.right != null) {
            this.right.inOrder();
        }
    }
}


public class Tree {

    Node root;

    public Tree(Node root) {
        this.root = root;
    }

    void insert(Node node) {
        root.insert(node);
    }

    void print() {
        Node current = this.root;
        while (true) {
            if (current != null) {
                System.out.println(current.value);
                if (current.left != null) {
                    System.out.println("/");
                    System.out.println(current.left.value);
                }
                if (current.right != null) {
                    System.out.println("\\");
                    System.out.println(current.right.value);
                }

            }
            break;
        }

    }

    public void inOrder() {
        root.inOrder();
    }

    public static void main(String[] args) {
        Tree tree = new Tree(new Node(4));
        tree.insert(new Node(5));
        tree.insert(new Node(2));
        tree.insert(new Node(3));
        tree.insert(new Node(1));
        tree.insert(new Node(10));
        //tree.print();
        tree.inOrder();
        List<Integer> output = Node.output;
        output.forEach(integer -> System.out.println(integer));

    }
}
