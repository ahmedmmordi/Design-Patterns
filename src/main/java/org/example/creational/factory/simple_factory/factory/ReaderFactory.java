package org.example.creational.factory.simple_factory.factory;

import org.example.creational.factory.simple_factory.model.CSVReader;
import org.example.creational.factory.simple_factory.model.JSONReader;
import org.example.creational.factory.simple_factory.model.Reader;
import org.example.creational.factory.simple_factory.model.XMLReader;

public class ReaderFactory {
    public static Reader createReader(String fileName) {
        if (fileName.endsWith(".json")) return new JSONReader();
        else if (fileName.endsWith(".csv")) return new CSVReader();
        else if (fileName.endsWith(".xml")) return new XMLReader();
        throw new IllegalArgumentException("Unsupported File Type: " + fileName);
    }
}
