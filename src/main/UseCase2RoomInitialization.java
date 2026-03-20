package main;

import model.*;

/**
 * Use Case 2: Room Initialization and Availability
 */
public class UseCase2RoomInitialization {

    public static void main(String[] args) {

        String appName = "Book My Stay";
        String version = "v2.0";

        System.out.println("===== " + appName + " " + version + " =====");

        // Create Room Objects
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Static Availability
        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        // Display Details
        System.out.println("\n--- Room Details ---");

        single.displayDetails();
        System.out.println("Available: " + singleAvailable + "\n");

        doubleRoom.displayDetails();
        System.out.println("Available: " + doubleAvailable + "\n");

        suite.displayDetails();
        System.out.println("Available: " + suiteAvailable + "\n");

        System.out.println("Application Ended.");
    }
}