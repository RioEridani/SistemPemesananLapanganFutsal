package business.state;

import business.Lapangan;

public class AvailableState implements LapanganState {
    private static final long serialVersionUID = 1L;

    public void handle(Lapangan lapangan) {
        System.out.println("Lapangan tersedia untuk dibooking.");
    }
    public String getStatus() { return "Available"; }
}
