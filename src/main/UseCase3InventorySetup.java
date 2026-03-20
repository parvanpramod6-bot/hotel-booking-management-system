package main;

import repository.RoomInventory;

/**
 * Use Case 3: Centralized Room Inventory Management
 */
public class UseCase3InventorySetup {

    public static void main(String[] args) {

        String appName = "Book My Stay";
        String version = "v3.0";

        System.out.println("===== " + appName + " " + version + " =====");

        // Initialize Inventory
        RoomInventory inventory = new RoomInventory();

        // Add room types
        inventory.addRoom("Single Room", 5);
        inventory.addRoom("Double Room", 3);
        inventory.addRoom("Suite Room", 2);

        // Display initial inventory
        inventory.displayInventory();

        // Update availability
        System.out.println("\nUpdating availability...");
        inventory.updateAvailability("Single Room", 4);

        // Display updated inventory
        inventory.displayInventory();

        System.out.println("\nApplication Ended.");
    }
}