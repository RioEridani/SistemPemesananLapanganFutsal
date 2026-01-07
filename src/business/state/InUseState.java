package business.state;

import business.Lapangan;

public class InUseState implements LapanganState {
    private static final long serialVersionUID = 1L;

    public void handle(Lapangan lapangan) {
        System.out.println("Lapangan sedang digunakan.");
    }
    public String getStatus() { return "In Use"; }
}