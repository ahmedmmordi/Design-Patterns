package org.example.creational.factory.factory_method.product.file_type;

public class FileTypeResolver {
    public FileType resolve(String fileName) {
        fileName = fileName.toLowerCase();
        if (fileName.endsWith(".json")) return FileType.JSON;
        else if (fileName.endsWith(".csv")) return FileType.CSV;
        else if (fileName.endsWith(".xml")) return FileType.XML;
        throw new IllegalArgumentException("Unsupported File Type: " + fileName);
    }
}
