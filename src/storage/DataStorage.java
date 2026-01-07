package storage;

import model.Booking;

import java.io.*;
import java.util.List;

public class DataStorage {
    private static final String FILE_NAME = "bookings.dat";

    public static void save(List<Booking> bookings) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(bookings);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Booking> load() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Booking>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Tidak ada data booking sebelumnya atau gagal load.");
            return new java.util.ArrayList<>();
        }
    }
}
