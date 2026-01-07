package business;

import business.state.AvailableState;

public class LapanganIndoor extends Lapangan {
    public LapanganIndoor(String nama) {
        super(nama);
        this.state = new AvailableState();
    }

    @Override
    public String getTipe() {
        return "Indoor";
    }
}