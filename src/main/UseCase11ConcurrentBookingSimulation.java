package main;

import model.Reservation;
import repository.RoomInventory;
import service.ConcurrentBookingProcessor;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Use Case 11: Concurrent Booking Simulation
 */
public class UseCase11ConcurrentBookingSimulation {

    public static void main(String[] args) {

        System.out.println("===== Book My Stay v11.0 =====");

        // Shared inventory
        RoomInventory inventory = new RoomInventory();
        inventory.addRoom("Single Room", 2);

        // Shared queue
        Queue<Reservation> queue = new LinkedList<>();

        queue.offer(new Reservation("Alice", "Single Room"));
        queue.offer(new Reservation("Bob", "Single Room"));
        queue.offer(new Reservation("Charlie", "Single Room")); // should fail

        // Processor
        ConcurrentBookingProcessor processor =
                new ConcurrentBookingProcessor(queue, inventory);

        // Threads (simulate multiple users)
        Runnable task = () -> {
            for (int i = 0; i < 2; i++) {
                processor.processBooking();
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        // Start threads
        t1.start();
        t2.start();

        // Wait for completion
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Final inventory
        System.out.println("\nFinal Inventory:");
        inventory.displayInventory();

        System.out.println("\nApplication Ended.");
    }
}