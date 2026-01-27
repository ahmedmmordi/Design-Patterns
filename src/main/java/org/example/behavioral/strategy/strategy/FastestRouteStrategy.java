package org.example.behavioral.strategy.strategy;

public class FastestRouteStrategy implements RouteStrategy {
    @Override
    public void calculateRoute(String from, String to) {
        System.out.println(
                "Fastest Route from '" + from + "' to '" + to +
                        "' -> 14 km, about 25 minutes"
        );
    }
}
