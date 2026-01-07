package business;

import business.state.LapanganState;
import java.io.Serializable;

public abstract class Lapangan implements Serializable {
    private static final long serialVersionUID = 1L;

    protected String nama;
    protected LapanganState state;

    public Lapangan(String nama) {
        this.nama = nama;
    }

    public void setState(LapanganState state) {
        this.state = state;
    }

    public LapanganState getState() {
        return state;
    }

    public String getNama() {
        return nama;
    }

    public void tampilkanStatus() {
        state.handle(this);
    }

    public abstract String getTipe();
}

