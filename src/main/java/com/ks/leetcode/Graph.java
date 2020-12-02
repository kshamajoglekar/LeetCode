package com.ks.leetcode;

import java.util.*;

public class Graph {

    HashSet<Node> visited = new HashSet<>();

    public boolean DFS(Node node, int value) {
        if (visited.contains(node)) {
            return false;
        }
        if (node.a == value) return true;

        visited.add(node);

        for (Node child : node.adjecent) {
            boolean found = DFS(child, value);
            if (found) return true;

        }
        return false;
    }


    public boolean BFS(Node node, int value) {

        Queue<Node> visiting = new ArrayDeque<>();

        visiting.add(node);

        while (!visiting.isEmpty()) {
            Node current = visiting.remove();
            if (current.a == value) {
                return true;
            }
            if (visited.contains(current)) {
                continue;
            }
            visited.add(current);

            for (Node child : current.adjecent) {
                visiting.add(child);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node a = new Node(5);
        Node b = new Node(10);
        Node c = new Node(7);
        Node d = new Node(17);

        a.addEdge(b);
        a.addEdge(c);
        b.addEdge(d);

        Graph graph = new Graph();

        //boolean isPresent=graph.DFS(a,44);
        int value = 44;

        boolean isPresent = graph.BFS(a, value);
        System.out.println("isPresent:" + value + " " + isPresent);
        graph.visited.clear();

        value = 10;
        isPresent = graph.BFS(a, value);
        System.out.println("isPresent:" + value + " " + isPresent);
        graph.visited.clear();

        value = 17;
        isPresent = graph.BFS(a, value);
        System.out.println("isPresent:" + value + " " + isPresent);
        graph.visited.clear();

        value = 5;
        isPresent = graph.BFS(a, value);
        System.out.println("isPresent:" + value + " " + isPresent);
        graph.visited.clear();

        value = 7;
        isPresent = graph.BFS(a, value);
        System.out.println("isPresent:" + value + " " + isPresent);
        graph.visited.clear();
        value = 18;
        isPresent = graph.BFS(a, value);
        System.out.println("isPresent:" + value + " " + isPresent);
        graph.visited.clear();
    }


    public static class Node {
        int a;
        List<Node> adjecent = new ArrayList<>();

        Node(int a) {
            this.a = a;
        }

        public void addEdge(Node destination) {
            this.adjecent.add(destination);
        }

    }
}
