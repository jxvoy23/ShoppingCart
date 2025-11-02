package com.shoppingcart.shoppingcarthashmap;// File: MyHashMap.java
// Name: Joel Rodriguez
// RAM ID: R02192039
// I certify that this submission is my own individual work, with
// the assistance of Google Gemini (AI tool).
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator;

public class MyHashMap<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public K getKey() { return key; }
        public V getValue() { return value; }
        @Override
        public String toString() { return "{" + key + "=" + value + "}"; }
    }
    private static final int DEFAULT_CAPACITY = 20;
    private LinkedList<Entry<K, V>>[] buckets;
    private int size;
    public MyHashMap() { this(DEFAULT_CAPACITY); }
    public MyHashMap(int capacity) {
        this.buckets = new LinkedList[capacity];
        this.size = 0;
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }
    private int hash(K key) {
        if (key == null) { return 0; }
        return Math.abs(key.hashCode()) % buckets.length;
    }
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
    public V put(K key, V value) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];
        for (Entry<K, V> entry : bucket) {
            if ((key == null && entry.key == null) || (key != null && key.equals(entry.key))) {
                V oldValue = entry.value;
                entry.value = value;
                return oldValue;
            }
        }
        bucket.add(new Entry<>(key, value));
        size++;
        return null;
    }
    public V get(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];
        for (Entry<K, V> entry : bucket) {
            if ((key == null && entry.key == null) || (key != null && key.equals(entry.key))) {
                return entry.value;
            }
        }
        return null;
    }
    public boolean containsKey(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];
        for (Entry<K, V> entry : bucket) {
            if ((key == null && entry.key == null) || (key != null && key.equals(entry.key))) {
                return true;
            }
        }
        return false;
    }
    public V remove(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];
        Iterator<Entry<K, V>> iterator = bucket.iterator();
        while (iterator.hasNext()) {
            Entry<K, V> entry = iterator.next();
            if ((key == null && entry.key == null) || (key != null && key.equals(entry.key))) {
                V value = entry.value;
                iterator.remove();
                size--;
                return value;
            }
        }
        return null;
    }
    public ArrayList<K> keys() {
        ArrayList<K> keyList = new ArrayList<>();
        for (LinkedList<Entry<K, V>> bucket : buckets) {
            for (Entry<K, V> entry : bucket) {
                keyList.add(entry.getKey());
            }
        }
        return keyList;
    }
    public ArrayList<V> values() {
        ArrayList<V> valueList = new ArrayList<>();
        for (LinkedList<Entry<K, V>> bucket : buckets) {
            for (Entry<K, V> entry : bucket) {
                valueList.add(entry.getValue());
            }
        }
        return valueList;
    }
    public ArrayList<Entry<K, V>> entrySet() {
        ArrayList<Entry<K, V>> entryList = new ArrayList<>();
        for (LinkedList<Entry<K, V>> bucket : buckets) {
            entryList.addAll(bucket);
        }
        return entryList;
    }
}