package org.example.structural.composite.client;

import org.example.structural.composite.composite.Box;
import org.example.structural.composite.leaf.Product;

public class Main {
    public static void main(String[] args) {
        // Products
        Product phone = new Product("Phone", 500);
        Product charger = new Product("Charger", 50);
        Product earbuds = new Product("Earbuds", 80);
        Product usbCable = new Product("USB Cable", 20);
        Product mouse = new Product("Mouse", 30);
        Product keyboard = new Product("Keyboard", 40);

        // Small Box 1 (Leaf Box)
        Box smallBox1 = new Box("Small Box 1");
        smallBox1.addItem(charger);
        smallBox1.addItem(earbuds);

        // Small Box 2 will now contain two smaller boxes
        Box smallBox2 = new Box("Small Box 2");

        // Nested Small box 1 inside Small Box 2 (1 product)
        Box nestedSmallBox1 = new Box("Nested Small Box 1");
        nestedSmallBox1.addItem(usbCable);

        // Nested Small box 2 inside Small Box 2 (2 products)
        Box nestedSmallBox2 = new Box("Nested Small Box 2");
        nestedSmallBox2.addItem(mouse);
        nestedSmallBox2.addItem(keyboard);

        // Add nested boxes to Small Box 2
        smallBox2.addItem(nestedSmallBox1);
        smallBox2.addItem(nestedSmallBox2);

        // Big Box containing everything
        Box bigBox = new Box("Big Box");
        bigBox.addItem(phone);
        bigBox.addItem(smallBox1);
        bigBox.addItem(smallBox2);

        System.out.println("Order Contents:");
        bigBox.print("");
        System.out.println("\nTotal Price: $" + bigBox.getPrice());
    }
}
