package org.example.structural.composite.composite;

import org.example.structural.composite.component.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class Box implements OrderItem {
    private final String name;
    private final List<OrderItem> items;

    public Box(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    @Override
    public double getPrice() {
        double totalPrice = 0;
        for(OrderItem item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    @Override
    public void print(String prefix) {
        System.out.println(prefix + "+ " + name);
        for (OrderItem item : items) {
            item.print(prefix + "  ");
        }
    }
}
