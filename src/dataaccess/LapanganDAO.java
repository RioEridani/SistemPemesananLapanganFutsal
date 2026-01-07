package dataaccess;

import business.Lapangan;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LapanganDAO {
    private static final String FILE_NAME = "lapangan_data.dat";

    public static void save(List<Lapangan> lapanganList) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(lapanganList);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan data lapangan: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Lapangan> load() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Lapangan>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Tidak ada data lapangan sebelumnya.");
            return new ArrayList<>();
        }
    }
}

