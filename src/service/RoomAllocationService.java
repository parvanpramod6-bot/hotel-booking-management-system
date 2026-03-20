package service;

import model.Reservation;
import repository.RoomInventory;

import java.util.*;

/**
 * Handles room allocation and booking confirmation
 */
public class RoomAllocationService {

    private RoomInventory inventory;
    private Queue<Reservation> bookingQueue;

    // Track assigned room IDs per type
    private Map<String, Set<String>> allocatedRooms;

    public RoomAllocationService(RoomInventory inventory, Queue<Reservation> bookingQueue) {
        this.inventory = inventory;
        this.bookingQueue = bookingQueue;
        this.allocatedRooms = new HashMap<>();
    }

    // Process all bookings
    public void processBookings() {

        System.out.println("\n--- Processing Bookings ---");

        while (!bookingQueue.isEmpty()) {

            Reservation request = bookingQueue.poll();
            String roomType = request.getRoomType();

            int available = inventory.getAvailability(roomType);

            if (available > 0) {

                // Generate unique room ID
                String roomId = generateRoomId(roomType);

                // Store allocation
                allocatedRooms.putIfAbsent(roomType, new HashSet<>());
                allocatedRooms.get(roomType).add(roomId);

                // Update inventory immediately
                inventory.updateAvailability(roomType, available - 1);

                System.out.println("Booking Confirmed:");
                System.out.println("Guest: " + request.getGuestName());
                System.out.println("Room Type: " + roomType);
                System.out.println("Room ID: " + roomId + "\n");

            } else {
                System.out.println("Booking Failed (No Availability):");
                System.out.println("Guest: " + request.getGuestName());
                System.out.println("Requested: " + roomType + "\n");
            }
        }
    }

    // Generate unique room ID
    private String generateRoomId(String roomType) {

        allocatedRooms.putIfAbsent(roomType, new HashSet<>());

        Set<String> usedIds = allocatedRooms.get(roomType);

        String roomId;
        do {
            roomId = roomType.substring(0, 2).toUpperCase() + "-" + (int)(Math.random() * 1000);
        } while (usedIds.contains(roomId));

        return roomId;
    }
}