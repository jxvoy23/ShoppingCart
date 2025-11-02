package com.shoppingcart.shoppingcarthashmap;// File: Item.java
// Name: Joel Rodriguez
// RAM ID: R02192039
// I certify that this submission is my own individual work, with
// the assistance of Google Gemini (AI tool).

import java.util.Objects;

class Item {
    private String sku;
    private String name;
    private double price;
    public Item(String sku, String name, double price) {
        this.sku = sku;
        this.name = name;
        this.price = price;
    }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getSku() { return sku; }
    @Override
    public String toString() {
        return String.format("%-15s $%.2f", name, price);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(sku, item.sku);
    }
    @Override
    public int hashCode() {
        return Objects.hash(sku);
    }
}