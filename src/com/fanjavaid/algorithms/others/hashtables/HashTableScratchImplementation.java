package com.fanjavaid.algorithms.others.hashtables;

public class HashTableScratchImplementation {
    public static void main(String[] args) {
        HashTableScratchImplementation hashTable = new HashTableScratchImplementation();
        hashTable.hash("pink", 10); // collision with `blue` key
        hashTable.hash("cyan", 10);
        hashTable.hash("blue", 10);

        System.out.println();
        hashTable.hashImproved("pink", 10); // collision doesn't exist anymore, because WEIRD_PRIME
        hashTable.hashImproved("cyan", 10);
        hashTable.hashImproved("blue", 10);
    }

    public int hash(String key, int arrayLen) {
        int total = 0;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            int value = ch - 96;
            total = (total + value) % arrayLen;
        }

        System.out.println("[LOG] " + total);

        return total;
    }

    // Improvement to make it fast and reduce collisions possibility, but not perfect one
    public int hashImproved(String key, int arrayLen) {
        int total = 0;
        int WEIRD_PRIME = 223;
        for (int i = 0; i < Math.min(key.length(), 100); i++) {
            char ch = key.charAt(i);
            int value = ch - 96;
            total = (total * WEIRD_PRIME + value) % arrayLen;
        }

        System.out.println("[LOG] " + total);

        return total;
    }
}
