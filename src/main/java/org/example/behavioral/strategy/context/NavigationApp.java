package org.example.behavioral.strategy.context;

import org.example.behavioral.strategy.strategy.RouteStrategy;

public class NavigationApp {
    private RouteStrategy strategy;
    public void setRouteStrategy(RouteStrategy strategy) {
        this.strategy = strategy;
    }

    public void navigate(String from, String to) {
        strategy.calculateRoute(from, to);
    }
}
