package com.shoppingcart.shoppingcarthashmap;// File: ShoppingCartSystem.java
// Name: Joel Rodriguez
// RAM ID: R02192039
// I certify that this submission is my own individual work, with
// the assistance of Google Gemini (AI tool).

import java.util.ArrayList;

class ShoppingCartSystem {
    private MyHashMap<Customer, ArrayList<Item>> cartStorage;
    public ShoppingCartSystem() {
        this.cartStorage = new MyHashMap<>();
    }
    public void addItem(Customer customer, Item item) {
        if (customer == null || item == null) return;
        if (!cartStorage.containsKey(customer)) {
            cartStorage.put(customer, new ArrayList<Item>());
        }
        cartStorage.get(customer).add(item);
    }
    public boolean removeItem(Customer customer, Item item) {
        if (customer == null || item == null || !cartStorage.containsKey(customer)) {
            return false;
        }
        return cartStorage.get(customer).remove(item);
    }
    public ArrayList<Item> getCart(Customer customer) {
        if (customer == null || !cartStorage.containsKey(customer)) {
            return new ArrayList<Item>();
        }
        return cartStorage.get(customer);
    }
    public double checkout(Customer customer) {
        if (customer == null) return 0.0;
        ArrayList<Item> cart = getCart(customer);
        double total = 0.0;
        for (Item item : cart) {
            total += item.getPrice();
        }
        cartStorage.remove(customer);
        return total;
    }
}