package com.ks.leetcode;

// Definition for a Node.


import java.util.HashMap;
import java.util.Map;

public class CopyRandomListPointer {

    Map<Node, Node> mapping = new HashMap<>();

    public Node copyRandomList(Node source) {
        Node destination = null;
        if (source != null) {
            destination = copyData(source);
            copyRandomList(source.next);
        }
        return destination;
    }

    private Node copyData(Node source) {

        Node destination = null;
        if (source != null) {

            if (mapping.get(source) == null) {
                destination = new Node(source.val);
                mapping.put(source, destination);
            } else {
                destination = mapping.get(source);
            }

            if (source.next != null) {
                if (mapping.get(source.next) == null) {
                    destination.next = new Node(source.next.val);
                    mapping.put(source.next, destination.next);
                } else {
                    destination.next = mapping.get(source.next);
                }
            }

            if (source.random != null) {
                if (mapping.get(source.random) == null) {
                    destination.random = new Node(source.random.val);
                    mapping.put(source.random, destination.random);
                } else {
                    destination.random = mapping.get(source.random);
                }
            }

        }
        return destination;

    }

    public static void main(String[] args) {

        Node node = new Node(5);
        Node node2 = new Node(10);
        Node node3 = new Node(15);

        node.next = node2;
        node.random = node3;

        node2.next = node3;
        node2.random = null;

        CopyRandomListPointer copy = new CopyRandomListPointer();
        copy.copyRandomList(node);

        System.out.println(node);
    }

    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


}

