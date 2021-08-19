package com.fanjavaid.algorithms.others;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();

        String[] arr = {"eat", "ae", "tea", "ea", "et"};
        System.out.println(ga.buildDictionary(arr));
        System.out.println();
        ga.solution(arr);
    }

//    public void solution(String[] strs) {
//        List<List<String>> results = new ArrayList<>();
//        for (String str : strs) {
//            results.add(getSmallestValues(buildDictionary(strs, str)));
//        }
//        System.out.println(results);
//    }
//
//    public Map<Character, List<String>> buildDictionary(String[] strs, String value) {
//        Map<Character, List<String>> dicts = new HashMap<>();
//
//        char[] chars = value.toCharArray();
//        for (String str : strs) {
//            for (char c : chars) {
//                if (str.length() == value.length() && str.indexOf(c) != -1) {
//                    if (dicts.get(c) != null) {
//                        dicts.get(c).add(str);
//                    } else {
//                        List<String> values = new ArrayList<>();
//                        values.add(str);
//                        dicts.put(c, values); // e = [eat], a = [eat], t = [eat]
//                    }
//                }
//            }
//        }
//
//        return dicts;
//    }
//
//    public List<String> getSmallestValues(Map<Character, List<String>> maps) {
//        int minSize = -1;
//        List<String> values = null;
//        for (Map.Entry<Character, List<String>> map : maps.entrySet()) {
//            int size = map.getValue().size();
//            if (minSize == -1) {
//                minSize = size;
//                values = map.getValue();
//            } else if (size < minSize){
//                minSize = size;
//                values = map.getValue();
//            }
//        }
//        return values;
//    }

    public Map<Character, List<String>> buildDictionary(String[] strs) {
        Map<Character, List<String>> dicts = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray(); // [e,a,t]
            for (char c : chars) {
                if (dicts.get(c) != null) {
                    dicts.get(c).add(str);
                } else {
                    List<String> values = new ArrayList<>();
                    values.add(str);
                    dicts.put(c, values); // e = [eat], a = [eat], t = [eat]
                }
            }
        }

        return dicts;
    }

    public void solution(String[] strs) {
        String[] sortedStrs = new String[strs.length];
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            sortedStrs[i] = String.valueOf(chars);
        }

        Map<String, List<String>> maps = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            List<String> values = new ArrayList<>();
            if (!maps.containsKey(sortedStrs[i])) {
                values.add(strs[i]);
                maps.put(sortedStrs[i], values);
            } else {
                maps.get(sortedStrs[i]).add(strs[i]);
            }
        }

        List<List<String>> results = new ArrayList<>();
        for (Map.Entry<String, List<String>> map : maps.entrySet()) {
            results.add(map.getValue());
        }

        System.out.println(Arrays.toString(sortedStrs));
        System.out.println(maps);
        System.out.println(results);
    }
}
