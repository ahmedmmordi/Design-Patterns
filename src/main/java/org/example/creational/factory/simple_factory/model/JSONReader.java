package org.example.creational.factory.simple_factory.model;

public class JSONReader implements Reader {
    @Override
    public void read() {
        System.out.println("Reading JSON File.");
    }
}
