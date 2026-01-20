package org.example.structural.adapter.adapter;

import org.example.structural.adapter.adaptee.XmlData;
import org.example.structural.adapter.target.JsonData;

public class XmlToJsonAdapter implements JsonData {
    private final XmlData xmlData;

    public XmlToJsonAdapter(XmlData xmlData) {
        this.xmlData = xmlData;
    }

    @Override
    public String toJson() {
        String xml = xmlData.getXmlData();
        String json = xml
                .replace("<data>", "{ \"data\": \"")
                .replace("</data>", "\" }");
        return json;
    }
}
