package com.ks.leetcode;


import java.util.Arrays;

public class Heap {
    int size = 0;
    int capacity = 10;
    int[] list = new int[capacity];


    public void insert(int value) {
        fixCapacityIfNeeded();
        list[size] = value;
        bubbleUp();
        size++;
    }


    public void deleteAtTop() {
        list[0] = list[size];
        size--;
        bubbleDown();

    }

    public void bubbleDown() {
        int i = 0;
        while (hasLeft(i)) {
            int smallestChildIndex = getLeftIndex(i);
            if (list[getRightIndex(i)] < smallestChildIndex) {
                smallestChildIndex = getRightIndex(i);
            }
            if (list[i] < list[smallestChildIndex]) {
                break;
            }
            swap(i, smallestChildIndex);
            i = smallestChildIndex;
        }
    }

    public void bubbleUp() {
        int i = size;
        int parentIndex = getParentIndex(i);
        while (hasParent(i) && (list[parentIndex] > list[i])) {
            swap(i, parentIndex);
            i = parentIndex;
            parentIndex = getParentIndex(i);
        }
    }


    public void fixCapacityIfNeeded() {
        if (size == (capacity - 1)) {
            capacity = capacity * 2;
            list = Arrays.copyOf(list, capacity);
        }
    }


    public void swap(int i, int parentI) {
        int temp;
        temp = list[i];
        list[i] = list[parentI];
        list[parentI] = temp;
    }

    private boolean hasParent(int i) {
        return getParentIndex(i) >= 0;
    }

    private boolean hasLeft(int i) {
        return getLeftIndex(i) <= size;
    }

    private boolean hasRight(int i) {
        return getRightIndex(i) <= size;
    }


    private int getLeftIndex(int i) {
        return i * 2 + 1;
    }

    private int getRightIndex(int i) {
        return i * 2 + 2;
    }

    private int getParentIndex(int i) {
        return (i - 1) / 2;
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(10);
        heap.insert(15);
        heap.insert(20);
        heap.insert(17);
        heap.insert(8);

        heap.deleteAtTop();

        Arrays.stream(heap.list).forEach(value -> System.out.println(value));
    }
}


