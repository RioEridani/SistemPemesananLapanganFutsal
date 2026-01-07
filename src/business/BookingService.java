package business;

import dataaccess.BookingDAO;
import model.Booking;

import java.util.List;

public class BookingService {

    public boolean buatBooking(String nama, String noTelepon, String lapangan, String tanggal, String jam) {
        if (BookingDAO.isSlotTersedia(lapangan, tanggal, jam)) {
            Booking booking = new Booking(nama, noTelepon, lapangan, tanggal, jam);
            BookingDAO.tambahBooking(booking);
            return true;
        } else {
            return false;
        }
    }

    public void hapusBooking(Booking booking) {
        BookingDAO.hapusBooking(booking);
    }

    public List<Booking> getSemuaBooking() {
        return BookingDAO.getAllBookings();
    }
} 
