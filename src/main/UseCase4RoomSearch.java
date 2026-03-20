package main;

import model.*;
import repository.RoomInventory;
import service.RoomSearchService;

import java.util.ArrayList;
import java.util.List;

public class UseCase4RoomSearch {

    public static void main(String[] args) {

        System.out.println("===== Book My Stay v4.0 =====");

        RoomInventory inventory = new RoomInventory();
        inventory.addRoom("Single Room", 5);
        inventory.addRoom("Double Room", 0);
        inventory.addRoom("Suite Room", 2);

        List<Room> rooms = new ArrayList<>();
        rooms.add(new SingleRoom());
        rooms.add(new DoubleRoom());
        rooms.add(new SuiteRoom());

        RoomSearchService searchService = new RoomSearchService(inventory);

        searchService.searchAvailableRooms(rooms);

        System.out.println("\nApplication Ended.");
    }
}