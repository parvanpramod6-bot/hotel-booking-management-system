package service;

import model.Reservation;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores confirmed bookings in order
 */
public class BookingHistory {

    private List<Reservation> history;

    public BookingHistory() {
        history = new ArrayList<>();
    }

    // Add confirmed booking
    public void addBooking(Reservation reservation) {
        history.add(reservation);
    }

    // Get all bookings
    public List<Reservation> getAllBookings() {
        return history;
    }

    // Display all bookings
    public void displayHistory() {

        System.out.println("\n--- Booking History ---");

        if (history.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }

        for (Reservation r : history) {
            r.display();
        }
    }
}