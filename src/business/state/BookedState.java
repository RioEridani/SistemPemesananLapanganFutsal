package business.state;

import business.Lapangan;

public class BookedState implements LapanganState {
    private static final long serialVersionUID = 1L;

    public void handle(Lapangan lapangan) {
        System.out.println("Lapangan sudah dibooking.");
    }
    public String getStatus() { return "Booked"; }
}
