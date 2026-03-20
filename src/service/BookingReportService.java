package service;

import model.Reservation;

import java.util.List;

/**
 * Generates reports from booking history
 */
public class BookingReportService {

    // Generate summary report
    public void generateReport(List<Reservation> bookings) {

        System.out.println("\n--- Booking Report ---");

        if (bookings.isEmpty()) {
            System.out.println("No data available.");
            return;
        }

        int total = bookings.size();

        int single = 0, doubleRoom = 0, suite = 0;

        for (Reservation r : bookings) {
            String type = r.getRoomType();

            if (type.equals("Single Room")) single++;
            else if (type.equals("Double Room")) doubleRoom++;
            else if (type.equals("Suite Room")) suite++;
        }

        System.out.println("Total Bookings: " + total);
        System.out.println("Single Room: " + single);
        System.out.println("Double Room: " + doubleRoom);
        System.out.println("Suite Room: " + suite);
    }
}