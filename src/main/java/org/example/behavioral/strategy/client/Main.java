package org.example.behavioral.strategy.client;

import org.example.behavioral.strategy.context.NavigationApp;
import org.example.behavioral.strategy.strategy.*;

public class Main {
    public static void main(String[] args) {
        NavigationApp app = new NavigationApp();

        app.setRouteStrategy(new FastestRouteStrategy());
        app.navigate("Tahrir Square", "Mohandessin");

        app.setRouteStrategy(new NoHighwaysRouteStrategy());
        app.navigate("Tahrir Square", "Mohandessin");

        app.setRouteStrategy(new ShortestRouteStrategy());
        app.navigate("Cairo", "Alexandria");
    }
}
