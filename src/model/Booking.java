package model;

public class Booking {
    private String nama;
    private String noTelepon;
    private String lapangan;
    private String tanggal;
    private String jam;

    public Booking(String nama, String noTelepon, String lapangan, String tanggal, String jam) {
        this.nama = nama;
        this.noTelepon = noTelepon;
        this.lapangan = lapangan;
        this.tanggal = tanggal;
        this.jam = jam;
    }

    public String getNama() {
        return nama;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public String getLapangan() {
        return lapangan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    @Override
    public String toString() {
        return nama + "\n" + noTelepon + "\n" + lapangan + "\n" + tanggal + "\n" + jam + "\n";
    }
} 
