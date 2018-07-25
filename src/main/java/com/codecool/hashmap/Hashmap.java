package com.codecool.hashmap;


import sun.awt.image.ImageWatched;

import java.util.LinkedList;

class Hashmap<K,V> {

    class KeyValue{
        public K key;
        public V value;

        KeyValue(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }

    private int size = 16;

    private LinkedList<KeyValue>[] elements = new LinkedList[size];

    public void add(K key, V value){
        int pos = getHash(key);
        LinkedList list = new LinkedList();

        if (elements[pos] != null){
            list = elements[pos];

            for (Object keyvalue: list) {
                KeyValue object = (KeyValue) keyvalue;
                if (object.key.equals(key)){
                    throw new IllegalArgumentException("Key already exists");
                }
            }
        }

        KeyValue object = new KeyValue(key, value);

        list.add(object);
        elements[pos] = list;
    }

    public V getValue(K key){
    int pos = getHash(key);
    if (elements[pos] != null){
        LinkedList list = elements[pos];

        for (Object object:list) {
            KeyValue keyValue = (KeyValue) object;
            if (keyValue.key.equals(key)){
                return keyValue.value;
            }
        }
    }

        throw new IllegalArgumentException("Key not found!");
    }

    public void clearAll(){
        elements = new LinkedList[size];
    }

    public void remove(K key){
        int pos = getHash(key);
        boolean isFound = false;
        if (elements[pos] != null){
            LinkedList list = elements[pos];

            for (Object object:list) {
                KeyValue keyValue = (KeyValue) object;
                if (keyValue.key.equals(key)){
                    elements[pos].remove(keyValue);
                    isFound = true;
                }
            }
        } else {
            throw new IllegalArgumentException("Key not found");
        }

        if (!isFound) throw new IllegalArgumentException("Key not found");
    }

    private int getHash(K key){
        return Math.abs(key.hashCode() % size);
    }



}
