package org.example.behavioral.strategy.strategy;

public class NoHighwaysRouteStrategy implements RouteStrategy {
    @Override
    public void calculateRoute(String from, String to) {
        System.out.println(
                "No-Highways Route from '" + from + "' to '" + to +
                        "' -> 18 km, about 40 minutes"
        );
    }
}
