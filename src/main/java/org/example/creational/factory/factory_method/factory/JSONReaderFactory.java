package org.example.creational.factory.factory_method.factory;

import org.example.creational.factory.factory_method.product.reader.JSONReader;
import org.example.creational.factory.factory_method.product.reader.Reader;

public class JSONReaderFactory extends ReaderFactory{
    @Override
    protected Reader createReader() {
        return new JSONReader();
    }
}
