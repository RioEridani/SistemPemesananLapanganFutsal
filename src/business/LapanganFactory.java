package business;

public class LapanganFactory {
    public static Lapangan createLapangan(String tipe, String nama) {
        if (tipe.equalsIgnoreCase("indoor")) {
            return new LapanganIndoor(nama);
        } else if (tipe.equalsIgnoreCase("outdoor")) {
            return new LapanganOutdoor(nama);
        } else {
            throw new IllegalArgumentException("Tipe lapangan tidak dikenali");
        }
    }
}
