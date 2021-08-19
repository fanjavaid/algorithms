package com.fanjavaid.algorithms.others;

import java.util.ArrayList;
import java.util.List;

class PNode {
    String value;
    int priority;

    public PNode(String value, int priority) {
        this.value = value;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "PNode{" +
                "v=" + value +
                ", p=" + priority +
                '}';
    }
}

class PriorityQueue {
    List<PNode> values;

    public PriorityQueue() {
        values = new ArrayList<>();
    }

    public PriorityQueue enqueue(String value, int priority) {
        PNode node = new PNode(value, priority);
        values.add(node);

        int currentIndex = values.size() - 1;
        int parentIndex;

        while (currentIndex > 0 && priority >= values.get(parentIndex = getParentIndex(currentIndex)).priority) {
            swap(values, currentIndex, parentIndex);
            currentIndex = parentIndex;
        }
        return this;
    }

    public PNode dequeue() {
        int end = values.size() - 1;
        swap(values, 0, end);
        PNode removed = values.remove(end);

        int currentIndex = 0;
        while(true) {
            int firstChildIdx = (2 * currentIndex) + 1;
            int secondChildIdx = (2* currentIndex) + 2;

            int largestIndex = -1;

            if (firstChildIdx < values.size() && values.get(firstChildIdx).priority > values.get(currentIndex).priority) {
                largestIndex = firstChildIdx;
            }

            if (secondChildIdx < values.size()) {
                if (largestIndex == -1 && values.get(secondChildIdx).priority > values.get(currentIndex).priority ||
                        largestIndex != -1 && values.get(secondChildIdx).priority > values.get(largestIndex).priority) {
                    largestIndex = secondChildIdx;
                }
            }

            if (largestIndex == -1) break;
            swap(values, currentIndex, largestIndex);
            currentIndex = largestIndex;
        }

        return removed;
    }

    private void swap(List<PNode> values, int i, int j) {
        PNode temp = values.get(i);
        values.set(i, values.get(j));
        values.set(j, temp);
    }

    private int getParentIndex(int currentIndex) {
        return ((int) Math.floor(currentIndex - 1) / 2);
    }
}

public class MinPriorityQueueBinaryHeap {
    public static void main(String[] args) {
        PriorityQueue q = new PriorityQueue();
        q.enqueue("Pilek", 2);
        q.enqueue("Luka Bakar", 5);
        q.enqueue("Asma", 3);
        q.enqueue("Influenza", 2);

        System.out.println(q.values);

        while(q.values.size() > 0) {
            System.out.println("Dequeue = " + q.dequeue());
        }
    }
}
