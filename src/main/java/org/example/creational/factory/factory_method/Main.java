package org.example.creational.factory.factory_method;

import org.example.creational.factory.factory_method.factory.ReaderFactoryProvider;
import org.example.creational.factory.factory_method.product.file_type.FileTypeResolver;
import org.example.creational.factory.factory_method.service.ReadingService;

public class Main {
    public static void main(String[] args) {
        ReadingService readingService = new ReadingService(new ReaderFactoryProvider(), new FileTypeResolver());

        String fileName = "clients.json";
        readingService.read(fileName);

        fileName = "data.csv";
        readingService.read(fileName);

        fileName = "config.xml";
        readingService.read(fileName);
    }
}
