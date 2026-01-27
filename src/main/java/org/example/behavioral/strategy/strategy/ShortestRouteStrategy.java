package org.example.behavioral.strategy.strategy;

public class ShortestRouteStrategy implements RouteStrategy {
    @Override
    public void calculateRoute(String from, String to) {
        System.out.println(
                "Shortest Route from '" + from + "' to '" + to +
                        "' -> 220 km, about 3 hours"
        );
    }
}
