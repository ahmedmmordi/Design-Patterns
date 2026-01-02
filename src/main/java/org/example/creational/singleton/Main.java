package org.example.creational.singleton;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Testing Message From My Logger.");

        Logger logger2 = Logger.getInstance();
        System.out.println(logger == logger2); // Just to ensure that all references point to the same instance
    }
}
