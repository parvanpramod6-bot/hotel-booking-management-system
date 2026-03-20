package service;

import model.Reservation;
import repository.RoomInventory;

import java.util.Queue;

/**
 * Handles concurrent booking safely
 */
public class ConcurrentBookingProcessor {

    private Queue<Reservation> queue;
    private RoomInventory inventory;

    public ConcurrentBookingProcessor(Queue<Reservation> queue, RoomInventory inventory) {
        this.queue = queue;
        this.inventory = inventory;
    }

    // Critical section (thread-safe)
    public synchronized void processBooking() {

        if (queue.isEmpty()) return;

        Reservation request = queue.poll();

        if (request == null) return;

        String roomType = request.getRoomType();
        int available = inventory.getAvailability(roomType);

        if (available > 0) {
            inventory.updateAvailability(roomType, available - 1);

            System.out.println(Thread.currentThread().getName() +
                    " ✅ Booked for " + request.getGuestName() +
                    " (" + roomType + ")");
        } else {
            System.out.println(Thread.currentThread().getName() +
                    " ❌ Failed for " + request.getGuestName() +
                    " (No availability)");
        }
    }
}