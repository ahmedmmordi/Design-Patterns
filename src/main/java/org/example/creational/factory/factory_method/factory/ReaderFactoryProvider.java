package org.example.creational.factory.factory_method.factory;

import org.example.creational.factory.factory_method.product.file_type.FileType;

public class ReaderFactoryProvider {
    // In a real project, you could cache factories here to reuse them since factories are stateless and creating them repeatedly is unnecessary
    public ReaderFactory getFactory(FileType type) {
        return switch (type) {
            case JSON -> new JSONReaderFactory();
            case CSV -> new CSVReaderFactory();
            case XML -> new XMLReaderFactory();
        };
    }
}
