package org.example.creational.factory.factory_method.product.reader;

public class XMLReader implements Reader {
    @Override
    public void read() {
        System.out.println("Reading XML File.");
    }
}
