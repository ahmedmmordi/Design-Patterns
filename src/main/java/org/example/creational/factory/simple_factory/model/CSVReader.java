package org.example.creational.factory.simple_factory.model;

public class CSVReader implements Reader {
    @Override
    public void read() {
        System.out.println("Reading CSV File.");
    }
}
