package main;

import model.Reservation;
import service.BookingHistory;
import service.BookingReportService;

/**
 * Use Case 8: Booking History & Reporting
 */
public class UseCase8BookingHistoryReport {

    public static void main(String[] args) {

        System.out.println("===== Book My Stay v8.0 =====");

        // Booking history
        BookingHistory history = new BookingHistory();

        // Simulate confirmed bookings
        history.addBooking(new Reservation("Alice", "Single Room"));
        history.addBooking(new Reservation("Bob", "Double Room"));
        history.addBooking(new Reservation("Charlie", "Single Room"));
        history.addBooking(new Reservation("David", "Suite Room"));

        // Display history
        history.displayHistory();

        // Generate report
        BookingReportService reportService = new BookingReportService();
        reportService.generateReport(history.getAllBookings());

        System.out.println("\nApplication Ended.");
    }
}