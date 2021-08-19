package com.fanjavaid.algorithms.others;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class MaxBinaryHeap {
    List<Integer> values;

    public MaxBinaryHeap() {
        this.values = new ArrayList<>();
    }

    public void insert(int value) {
        values.add(value);

        // Define indices
        int currentIndex = values.size() - 1;
        int parentIndex;

        // Bubble Up
        while (currentIndex > 0 && value > values.get(parentIndex = getParentIndex(currentIndex))) {
            swap(values, currentIndex, parentIndex);
            currentIndex = parentIndex;
        }
    }

    public int extractMax() {
        int end = values.size() - 1;

        swap(values, 0, end);
        int removed = values.remove(end);

        int currentIndex = 0;
        while (true) {
            int firstChildIndex = getFistChildIndex(currentIndex);
            int secondChildIndex = getSecondChildIndex(currentIndex);

            // Find largest child
            int swapIndex = -1;
            if (firstChildIndex < values.size() && values.get(firstChildIndex) > values.get(currentIndex)) {
                swapIndex = firstChildIndex;
            }

            if (secondChildIndex < values.size()) {
                if (swapIndex == -1 && values.get(secondChildIndex) > values.get(currentIndex) ||
                        swapIndex != -1 && values.get(secondChildIndex) > values.get(swapIndex)) {
                    swapIndex = secondChildIndex;
                }
            }

            if (swapIndex == -1) break;
            swap(values, currentIndex, swapIndex);
            currentIndex = swapIndex;
        }
        return removed;
    }

    private int getFistChildIndex(int index) {
        return (2 * index) + 1;
    }

    private int getSecondChildIndex(int index) {
        return (2 * index) + 2;
    }

    private int getParentIndex(int index) {
        return (int) Math.floor((index - 1) / 2);
    }

    private void swap(List<Integer> values, int i, int j) {
        int temp = values.get(i);
        values.set(i, values.get(j));
        values.set(j, temp);
    }
}

public class MaxBinaryHeapImplementation {
    public static void main(String[] args) {
        MaxBinaryHeap heap = new MaxBinaryHeap();
        heap.insert(41);
        heap.insert(39);
        heap.insert(33);
        heap.insert(18);
        heap.insert(27);
        heap.insert(12);
        heap.insert(55);

        System.out.println(heap.values);

        int removed = heap.extractMax();
        System.out.println("\nExtract Max Value = " + removed);
        System.out.println(heap.values);

        removed = heap.extractMax();
        System.out.println("\nExtract Max Value = " + removed);
        System.out.println(heap.values);
    }
}
