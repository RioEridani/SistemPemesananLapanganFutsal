package business.state;

import business.Lapangan;

public class MaintenanceState implements LapanganState {
    private static final long serialVersionUID = 1L;

    public void handle(Lapangan lapangan) {
        System.out.println("Lapangan sedang dalam perawatan.");
    }
    public String getStatus() { return "Maintenance"; }
}
