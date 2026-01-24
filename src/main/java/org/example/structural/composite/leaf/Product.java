package org.example.structural.composite.leaf;

import org.example.structural.composite.component.OrderItem;

public class Product implements OrderItem {
    private final String name;
    private final double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void print(String prefix) {
        System.out.println(prefix + "- " + name + " ($" + price + ")");
    }
}
