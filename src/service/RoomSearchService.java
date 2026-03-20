package service;

import model.Room;
import repository.RoomInventory;

import java.util.List;

public class RoomSearchService {

    private RoomInventory inventory;

    public RoomSearchService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    public void searchAvailableRooms(List<Room> rooms) {

        System.out.println("\n--- Available Rooms ---");

        for (Room room : rooms) {

            String type = room.getType();

            int available = inventory.getAvailability(type);

            if (available > 0) {
                room.displayDetails();
                System.out.println("Available: " + available + "\n");
            }
        }
    }
}