package com.ks.leetcode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;

public class ShortestPath {

    int shortestPath(Node source, Node destination) {

        if (source.value == destination.value) return 0;
        HashMap<Node, Integer> distances = new HashMap<>();
        Queue<Node> visiting = new ArrayDeque<>();

        visiting.add(source);
        distances.put(source, 0);

        while (!visiting.isEmpty()) {

            Node current = visiting.remove();

            if (current.value == destination.value) {
                return distances.get(current);
            }

            if (visiting.contains(current)) {
                continue;
            }

            for (Node node : current.neighbours) {
                visiting.add(node);
                distances.put(node, distances.get(current) + 1);
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        ShortestPath SP = new ShortestPath();

        ShortestPath.Node a = new ShortestPath.Node(5);
        ShortestPath.Node b = new ShortestPath.Node(10);
        ShortestPath.Node c = new ShortestPath.Node(7);
        ShortestPath.Node d = new ShortestPath.Node(17);

        a.addNeighbour(b);
        a.addNeighbour(c);
        b.addNeighbour(d);

        System.out.println("Shortest path-->" + SP.shortestPath(b, d));
    }

    static class Node {

        int value;
        HashSet<Node> neighbours;

        Node(int value) {
            this.value = value;
            neighbours = new HashSet<>();
            // neighbours = null;
        }

        /**
         * Assume: equality check performed already
         */
        void addNeighbour(Node neighbour) {
            this.neighbours.add(neighbour);
        }
    }
}
