package presentation;

import business.BookingService;
import model.Booking;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    private static Scanner scanner = new Scanner(System.in);
    private static BookingService bookingService = new BookingService();

    public static void main(String[] args) {
        while (true) {
            System.out.print("Nama: ");
            String nama = scanner.nextLine();
            System.out.print("No: ");
            String no = scanner.nextLine();

            while (true) {
                System.out.println("\nMenu");
                System.out.println("1. Booking lapangan");
                System.out.println("2. Batalkan booking");
                System.out.println("3. Edit booking");
                System.out.println("4. Lihat semua hasil booking");
                System.out.println("5. Exit");
                System.out.print("Pilih menu: ");
                int pilihan = Integer.parseInt(scanner.nextLine());

                switch (pilihan) {
                    case 1:
                        bookingLapangan(nama, no);
                        break;
                    case 2:
                        batalkanBooking();
                        break;
                    case 3:
                        editBooking();
                        break;
                    case 4:
                        lihatSemuaBooking();
                        break;
                    case 5:
                        System.out.println("Terima kasih!");
                        return;
                }
            }
        }
    }

    private static void bookingLapangan(String nama, String no) {
        System.out.println("Pilih Lapangan:");
        System.out.println("1. Lapangan A");
        System.out.println("2. Lapangan B");
        String lapangan = scanner.nextLine().equals("1") ? "Lapangan A" : "Lapangan B";

        System.out.print("Tanggal booking (yyyy-mm-dd): ");
        String tanggal = scanner.nextLine();

        String[] jamPilihan = {
                "07.00-08.00", "08.00-09.00", "09.00-10.00", "10.00-11.00",
                "11.00-12.00", "12.00-13.00", "13.00-14.00", "14.00-15.00",
                "15.00-16.00", "16.00-17.00", "17.00-18.00", "18.00-19.00",
                "19.00-20.00", "20.00-21.00", "21.00-22.00", "22.00-23.00"
        };

        System.out.println("Pilih jam booking yang tersedia:");
        for (int i = 0; i < jamPilihan.length; i++) {
            final int index = i;
            boolean tersedia = bookingService.getSemuaBooking().stream()
                    .noneMatch(b -> b.getLapangan().equals(lapangan) &&
                                    b.getTanggal().equals(tanggal) &&
                                    b.getJam().equals(jamPilihan[index]));
            if (tersedia) {
                System.out.printf("%d. %s\n", i + 1, jamPilihan[i]);
            }
        }

        System.out.print("Masukkan nomor jam booking: ");
        int pilihanJam = Integer.parseInt(scanner.nextLine());
        if (pilihanJam < 1 || pilihanJam > jamPilihan.length) {
            System.out.println("Pilihan tidak valid.");
            return;
        }

        String jamDipilih = jamPilihan[pilihanJam - 1];
        boolean tersedia = bookingService.getSemuaBooking().stream()
                .noneMatch(b -> b.getLapangan().equals(lapangan) &&
                                b.getTanggal().equals(tanggal) &&
                                b.getJam().equals(jamDipilih));

        if (!tersedia) {
            System.out.println("Slot sudah dibooking, silakan pilih slot lain.");
            return;
        }

        boolean berhasil = bookingService.buatBooking(nama, no, lapangan, tanggal, jamDipilih);
        if (berhasil) {
            System.out.println("\nBooking berhasil:");
            System.out.println(nama);
            System.out.println(no);
            System.out.println(lapangan);
            System.out.println(tanggal);
            System.out.println(jamDipilih);
        }
    }

    private static void batalkanBooking() {
        List<Booking> bookings = bookingService.getSemuaBooking();
        for (int i = 0; i < bookings.size(); i++) {
            System.out.println((i + 1) + ". " + bookings.get(i));
        }
        System.out.print("Pilih booking yang ingin dibatalkan: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        if (index >= 0 && index < bookings.size()) {
            bookingService.hapusBooking(bookings.get(index));
            System.out.println("Booking berhasil dibatalkan.");
        }
    }

    private static void editBooking() {
        List<Booking> bookings = bookingService.getSemuaBooking();
        for (int i = 0; i < bookings.size(); i++) {
            System.out.println((i + 1) + ". " + bookings.get(i));
        }
        System.out.print("Pilih booking yang ingin diedit: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        if (index >= 0 && index < bookings.size()) {
            Booking booking = bookings.get(index);
            bookingService.hapusBooking(booking);

            String[] jamPilihan = {
                "07.00-08.00", "08.00-09.00", "09.00-10.00", "10.00-11.00",
                "11.00-12.00", "12.00-13.00", "13.00-14.00", "14.00-15.00",
                "15.00-16.00", "16.00-17.00", "17.00-18.00", "18.00-19.00",
                "19.00-20.00", "20.00-21.00", "21.00-22.00", "22.00-23.00"
            };

            System.out.println("Jam tersedia untuk tanggal " + booking.getTanggal() + ":");
            for (int i = 0; i < jamPilihan.length; i++) {
                final int indexJam = i;
                boolean tersedia = bookingService.getSemuaBooking().stream()
                        .noneMatch(b -> b.getLapangan().equals(booking.getLapangan()) &&
                                        b.getTanggal().equals(booking.getTanggal()) &&
                                        b.getJam().equals(jamPilihan[indexJam]));
                if (tersedia) {
                    System.out.printf("%d. %s\n", i + 1, jamPilihan[i]);
                }
            }

            System.out.print("Pilih nomor jam baru: ");
            int pilihanJam = Integer.parseInt(scanner.nextLine());
            if (pilihanJam < 1 || pilihanJam > jamPilihan.length) {
                System.out.println("Pilihan tidak valid.");
                return;
            }

            String jamBaru = jamPilihan[pilihanJam - 1];
            boolean valid = bookingService.getSemuaBooking().stream()
                .noneMatch(b -> b.getLapangan().equals(booking.getLapangan()) &&
                                b.getTanggal().equals(booking.getTanggal()) &&
                                b.getJam().equals(jamBaru));

            if (valid) {
                bookingService.buatBooking(booking.getNama(), booking.getNoTelepon(), booking.getLapangan(), booking.getTanggal(), jamBaru);
                System.out.println("Booking berhasil diedit.");
            } else {
                System.out.println("Jam baru sudah dibooking oleh orang lain.");
            }
        }
    }

    private static void lihatSemuaBooking() {
        List<Booking> bookings = bookingService.getSemuaBooking();
        for (Booking b : bookings) {
            System.out.println("--------------------------");
            System.out.println(b);
        }
    }
}
