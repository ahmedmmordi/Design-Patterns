package org.example.structural.adapter.client;

import org.example.structural.adapter.target.JsonData;

public class ReportGenerator {
    private final JsonData jsonData;

    public ReportGenerator(JsonData jsonData) {
        this.jsonData = jsonData;
    }

    public void generateReport() {
        System.out.println("Generating Report With JSON Data:");
        System.out.println(jsonData.toJson());
    }
}
