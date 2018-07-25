package com.codecool.hashmap;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Hashmap<String, Integer> hashmap = new Hashmap<String, Integer>();

        hashmap.add("stri", 15);
        hashmap.add("string", 72);
        hashmap.add("elemér", 55);

        System.out.println(hashmap.getValue("elemér"));
        hashmap.remove("stri");
        hashmap.clearAll();
        hashmap.getValue("elemér");
    }
}
