package business;

import business.state.AvailableState;

public class LapanganOutdoor extends Lapangan {
    public LapanganOutdoor(String nama) {
        super(nama);
        this.state = new AvailableState();
    }

    @Override
    public String getTipe() {
        return "Outdoor";
    }
}
