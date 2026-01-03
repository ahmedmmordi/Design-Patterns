package org.example.creational.factory.factory_method.factory;

import org.example.creational.factory.factory_method.product.reader.CSVReader;
import org.example.creational.factory.factory_method.product.reader.Reader;

public class CSVReaderFactory extends ReaderFactory {
    @Override
    protected Reader createReader() {
        return new CSVReader();
    }
}
