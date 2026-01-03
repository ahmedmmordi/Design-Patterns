package org.example.creational.factory.factory_method.factory;

import org.example.creational.factory.factory_method.product.reader.Reader;
import org.example.creational.factory.factory_method.product.reader.XMLReader;

public class XMLReaderFactory extends ReaderFactory {
    @Override
    protected Reader createReader() {
        return new XMLReader();
    }
}
