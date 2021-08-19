package com.fanjavaid.algorithms.others.hashtables;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class HashTables {
    List<List<String>>[] keyMaps;

    public HashTables(int initialCapacity) {
        this.keyMaps = new List[initialCapacity];
    }

    private int hash(String key) {
        int total = 0;
        int WEIRD_PRIME = 31;

        for (int i = 0; i < Math.min(key.length(), 100); i++) {
            int value = key.charAt(i) - 96;
            total = (total * WEIRD_PRIME + value) % this.keyMaps.length;
        }
        return total;
    }

    /*
     * 0
     * 1
     * 2
     * 3 -> [[black, #000000], [cyan, #00FFFF], ]
     * */
    public void set(String key, String value) {
        int index = hash(key);
        if (keyMaps[index] == null) {
            this.keyMaps[index] = new ArrayList<>();
        } else {
            // Prevent duplication of key
            for (List<String> chains : this.keyMaps[index]) {
                if (chains.get(0).equals(key)) return;
            }
        }

        List<String> values = new ArrayList<>();
        values.add(key);
        values.add(value);
        this.keyMaps[index].add(values);
    }

    public String get(String key) {
        int index = hash(key);
        List<List<String>> chains = this.keyMaps[index];
        if (chains != null) {
            for (List<String> chain : chains) {
                if (chain.get(0).equals(key)) return chain.get(1);
            }
        }
        return null;
    }

    public List<String> getKeys() {
        List<String> keys = new ArrayList<>();
        for (List<List<String>> chains : this.keyMaps) {
            if (chains != null) {
                for (List<String> values : chains) keys.add(values.get(0));
            }
        }
        return keys;
    }

    public Set<String> getValues() {
        Set<String> values = new HashSet<>();
        for (List<List<String>> chains : this.keyMaps) {
            if (chains != null) {
                for (List<String> chainValues : chains) values.add(chainValues.get(1));
            }
        }
        return values;
    }

    public void print() {
        System.out.println("HASH TABLES");
        System.out.println("--------------------------");
        System.out.println("| IDX\t| VALUES \t");
        System.out.println("--------------------------");
        for (int i = 0; i < this.keyMaps.length; i++) {
            System.out.println("|\t" + i + "\t| " + this.keyMaps[i]);
        }
    }
}

public class SeparateChainingImplementation {
    public static void main(String[] args) {
        HashTables hashTables = new HashTables(4);
        hashTables.set("black", "#000000");
        hashTables.set("red", "#FF0000");
        hashTables.set("pink", "#FFC0CB");
        hashTables.set("cyan", "#00FFFF");
        hashTables.set("cyan", "#00FFFF");

        hashTables.print();

        System.out.println("\nGet from Hash Tables:");
        System.out.println(hashTables.get("red"));
        System.out.println(hashTables.get("black"));
        System.out.println(hashTables.get("cyan"));
        System.out.println(hashTables.get("yellow"));

        System.out.println("\nGet Hash Tables Keys: " + hashTables.getKeys());
        System.out.println("\nGet Hash Tables Values: " + hashTables.getValues());
    }
}
