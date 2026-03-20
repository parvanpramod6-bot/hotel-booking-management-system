package main;

import model.Reservation;
import repository.RoomInventory;
import service.BookingRequestQueue;
import service.RoomAllocationService;

import java.util.Queue;

/**
 * Use Case 6: Reservation Confirmation & Room Allocation
 */
public class UseCase6RoomAllocationService {

    public static void main(String[] args) {

        System.out.println("===== Book My Stay v6.0 =====");

        // Inventory setup
        RoomInventory inventory = new RoomInventory();
        inventory.addRoom("Single Room", 2);
        inventory.addRoom("Double Room", 1);
        inventory.addRoom("Suite Room", 1);

        // Booking queue
        BookingRequestQueue requestQueue = new BookingRequestQueue();

        requestQueue.addRequest(new Reservation("Alice", "Single Room"));
        requestQueue.addRequest(new Reservation("Bob", "Single Room"));
        requestQueue.addRequest(new Reservation("Charlie", "Single Room")); // should fail

        requestQueue.addRequest(new Reservation("David", "Suite Room"));

        // Get internal queue
        Queue<Reservation> queue = requestQueue.getQueue();

        // Allocation service
        RoomAllocationService allocationService =
                new RoomAllocationService(inventory, queue);

        // Process bookings
        allocationService.processBookings();

        System.out.println("\nFinal Inventory:");
        inventory.displayInventory();

        System.out.println("\nApplication Ended.");
    }
}