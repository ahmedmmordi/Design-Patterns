package org.example.creational.factory.factory_method.factory;

import org.example.creational.factory.factory_method.product.reader.Reader;

public abstract class ReaderFactory {
    protected abstract Reader createReader();

    public void readFile() {
        Reader reader = createReader();
        reader.read();
    }
}
