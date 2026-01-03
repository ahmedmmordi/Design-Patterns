package org.example.creational.factory.simple_factory;

import org.example.creational.factory.simple_factory.factory.ReaderFactory;
import org.example.creational.factory.simple_factory.model.Reader;

public class Main {
    public static void main(String[] args) {
        String fileName = "clients.json";

        Reader reader = ReaderFactory.createReader(fileName);
        reader.read();

        fileName = "data.csv";
        reader = ReaderFactory.createReader(fileName);
        reader.read();

        fileName = "config.xml";
        reader = ReaderFactory.createReader(fileName);
        reader.read();

        fileName = "Summary.pdf";
        reader = ReaderFactory.createReader(fileName);
        reader.read();
    }
}
