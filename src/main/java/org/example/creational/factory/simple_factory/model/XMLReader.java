package org.example.creational.factory.simple_factory.model;

public class XMLReader implements Reader {
    @Override
    public void read() {
        System.out.println("Reading XML File.");
    }
}
