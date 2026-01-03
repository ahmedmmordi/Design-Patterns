package org.example.creational.factory.factory_method.product.reader;

public class JSONReader implements Reader {
    @Override
    public void read() {
        System.out.println("Reading JSON File.");
    }
}
