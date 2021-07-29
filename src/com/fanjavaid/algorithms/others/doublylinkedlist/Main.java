package com.fanjavaid.algorithms.others.doublylinkedlist;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.push("H");

        title("Initial list:");
        list.print();

        title("Push N1 & N2:");
        list.push("N1");
        list.push("N2");
        list.print();

        // Pop
        for (int i = 1; i <= 3; i++) {
            title("Pop");
            list.pop();
            list.print();
        }

        // Shift
        title("Initial List:");
        list.push("Head");
        list.push("Node 1");
        list.push("Node 2");
        list.print();
        title("Shift:");
        list.shift();
        list.print();
        System.out.println("head = " + list.getHead().getValue());
        System.out.println("head.prev = " + list.getHead().getPrev());

        // Unshift
        title("Unshift:");
        list.unshift("Big Head");
        list.print();
        System.out.println("head = " + list.getHead().getValue());
        System.out.println("head.prev = " + list.getHead().getPrev());

        // Get
        list.push("Node 3");
        list.push("Node 4");
        list.push("Node 5");
        list.push("Node 6");
        title("Get from head:");
        list.print();
        System.out.println("Get Index 2 = " + list.get(2).getValue());

        title("Get from tail:");
        System.out.println("Get Index 5 = " + list.get(5).getValue());

        title("Get out of bounds:");
        System.out.println("Get Index -100 = " + list.get(-100));
        System.out.println("Get Index 99 = " + list.get(99));

        // Set
        title("Set:");
        list.set(1, "Node one");
        list.set(-10, "Some value"); // this won't work
        list.print();

        // Insert
        title("Insert at start:");
        list.insert(0, "Start");
        list.print();

        title("Insert at the end:");
        list.insert(list.getLength(), "End");
        list.print();

        title("Insert at the out bound:");
        list.insert(-1, "Minus One");
        list.insert(1000, "A thousand");
        list.print();

        title("Insert:");
        list.insert(3, "(Number 3)");
        list.print();

        title("Remove first:");
        list.remove(0);
        list.print();

        title("Remove end:");
        list.remove(list.getLength() - 1);
        list.print();

        title("Remove");
        list.remove(3);
        list.print();

        // Reverse
        title("Reverse:");
        list.reverse();
        list.print();
    }

    public static void title(String title) {
        System.out.println("\n" + title.toUpperCase() + "\n---------");
    }
}
