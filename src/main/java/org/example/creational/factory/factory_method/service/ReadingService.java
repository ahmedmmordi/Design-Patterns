package org.example.creational.factory.factory_method.service;

import org.example.creational.factory.factory_method.product.file_type.FileType;
import org.example.creational.factory.factory_method.product.file_type.FileTypeResolver;
import org.example.creational.factory.factory_method.factory.ReaderFactory;
import org.example.creational.factory.factory_method.factory.ReaderFactoryProvider;

public class ReadingService {
    private final ReaderFactoryProvider provider;
    private final FileTypeResolver resolver;

    public ReadingService(ReaderFactoryProvider provider, FileTypeResolver resolver) {
        this.provider = provider;
        this.resolver = resolver;
    }

    public void read(String fileName) {
        FileType type = resolver.resolve(fileName);
        ReaderFactory factory = provider.getFactory(type);
        factory.readFile();
    }
}
