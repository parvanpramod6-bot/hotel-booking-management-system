package service;

import model.Reservation;

import java.util.LinkedList;
import java.util.Queue;

public class BookingRequestQueue {

    private Queue<Reservation> queue;

    public BookingRequestQueue() {
        queue = new LinkedList<>();
    }

    public void addRequest(Reservation reservation) {
        queue.offer(reservation);
        System.out.println("Request added:");
        reservation.display();
    }

    public void viewRequests() {
        System.out.println("\n--- Booking Queue ---");

        if (queue.isEmpty()) {
            System.out.println("No pending requests.");
            return;
        }

        for (Reservation r : queue) {
            r.display();
        }
    }

    // ✅ ADD THIS
    public Queue<Reservation> getQueue() {
        return queue;
    }
}