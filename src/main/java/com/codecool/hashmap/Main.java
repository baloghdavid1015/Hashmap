package com.codecool.hashmap;


public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> hashmap = new HashMap<String, Integer>();

        hashmap.add("stri", 15);
        hashmap.add("string", 72);
        hashmap.add("elemér", 55);
        hashmap.add("andré", 72);
        hashmap.add("imi", 14);

        System.out.println(hashmap.getValue("elemér"));
        hashmap.remove("stri");
        hashmap.clearAll();
        hashmap.getValue("elemér");
    }
}
