package org.example.structural.adapter;

import org.example.structural.adapter.adaptee.XmlData;
import org.example.structural.adapter.adapter.XmlToJsonAdapter;
import org.example.structural.adapter.client.ReportGenerator;

public class Main {
    public static void main(String[] args) {
        XmlData xml = new XmlData("<data>Some Data</data>");
        XmlToJsonAdapter xmlToJsonAdapter = new XmlToJsonAdapter(xml);
        ReportGenerator reportGenerator = new ReportGenerator(xmlToJsonAdapter);
        reportGenerator.generateReport();
    }
}
