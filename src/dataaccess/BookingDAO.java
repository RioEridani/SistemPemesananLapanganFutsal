package dataaccess;

import model.Booking;

import java.util.ArrayList;
import java.util.List;

public class BookingDAO {
    private static List<Booking> bookings = new ArrayList<>();

    public static void tambahBooking(Booking booking) {
        bookings.add(booking);
    }

    public static void hapusBooking(Booking booking) {
        bookings.remove(booking);
    }

    public static List<Booking> getAllBookings() {
        return bookings;
    }

    public static boolean isSlotTersedia(String lapangan, String tanggal, String jam) {
        for (Booking b : bookings) {
            if (b.getLapangan().equalsIgnoreCase(lapangan)
                    && b.getTanggal().equals(tanggal)
                    && b.getJam().equals(jam)) {
                return false;
            }
        }
        return true;
    }
} 
