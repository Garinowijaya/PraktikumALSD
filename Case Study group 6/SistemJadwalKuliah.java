import java.util.*;

class Dosen { String nidn; String namaDosen;

Dosen(String nidn, String namaDosen) {
    this.nidn = nidn;
    this.namaDosen = namaDosen;
}

void tampilData() {
    System.out.println("NIDN: " + nidn);
    System.out.println("Nama: " + namaDosen);
}

}

class MataKuliah { String kodeMK; String namaMK; int sks;

MataKuliah(String kodeMK, String namaMK, int sks) {
    this.kodeMK = kodeMK;
    this.namaMK = namaMK;
    this.sks = sks;
}

void tampilData() {
    System.out.println("Kode MK: " + kodeMK);
    System.out.println("Nama Mata Kuliah: " + namaMK);
    System.out.println("SKS: " + sks);
}

}

class Jadwal { Dosen dosen; MataKuliah mataKuliah; String hari; String jam;

Jadwal(Dosen dosen, MataKuliah mataKuliah, String hari, String jam) {
    this.dosen = dosen;
    this.mataKuliah = mataKuliah;
    this.hari = hari;
    this.jam = jam;
}

int hitungMenit() {
    return mataKuliah.sks * 50;
}

void tampilData() {
    System.out.println("Dosen : " + dosen.namaDosen);
    System.out.println("Mata Kuliah : " + mataKuliah.namaMK);
    System.out.println("SKS : " + mataKuliah.sks);
    System.out.println("Hari : " + hari);
    System.out.println("Jam : " + jam);
    System.out.println("Durasi : " + hitungMenit() + " menit\n");
}

}

public class SistemJadwalKuliah { static List<Dosen> daftarDosen = new ArrayList<>(); static List<MataKuliah> daftarMK = new ArrayList<>(); static List<Jadwal> daftarJadwal = new ArrayList<>();

public static void main(String[] args) {
    initData();
    Scanner input = new Scanner(System.in);
    int pilihan;

    do {
        System.out.println("\nMENU:");
        System.out.println("1. Tampilkan Data Dosen");
        System.out.println("2. Tampilkan Data Mata Kuliah");
        System.out.println("3. Tampilkan Data Jadwal");
        System.out.println("4. Urutkan Jadwal Berdasarkan Hari & Jam");
        System.out.println("5. Cari Jadwal Berdasarkan Nama Dosen");
        System.out.println("0. Keluar");
        System.out.print("Pilih menu: ");
        pilihan = input.nextInt();
        input.nextLine(); // buffer

        switch (pilihan) {
            case 1 -> tampilDosen();
            case 2 -> tampilMK();
            case 3 -> tampilJadwal();
            case 4 -> urutkanJadwal();
            case 5 -> cariJadwal(input);
            case 0 -> System.out.println("Keluar dari program.");
            default -> System.out.println("Pilihan tidak valid.");
        }
    } while (pilihan != 0);
}

static void initData() {
    Dosen d1 = new Dosen("D001", "Budi Hartono");
    Dosen d2 = new Dosen("D002", "Afif Hendrawan");
    Dosen d3 = new Dosen("D003", "Farid Angga Pribadi");
    Dosen d4 = new Dosen("D004", "Imam Farur Rozi");
    Dosen d5 = new Dosen("D005", "Andi Pratama");

    daftarDosen.addAll(List.of(d1, d2, d3, d4, d5));

    MataKuliah mk1 = new MataKuliah("MK001", "Struktur Data", 3);
    MataKuliah mk2 = new MataKuliah("MK002", "Pemrograman Java", 3);
    MataKuliah mk3 = new MataKuliah("MK003", "Basis Data", 3);
    MataKuliah mk4 = new MataKuliah("MK004", "Algoritma dan Pemrograman", 2);
    MataKuliah mk5 = new MataKuliah("MK005", "Matematika Diskrit", 2);
    MataKuliah mk6 = new MataKuliah("MK006", "Jaringan Komputer", 3);
    MataKuliah mk7 = new MataKuliah("MK007", "Pemrograman Web", 3);

    daftarMK.addAll(List.of(mk1, mk2, mk3, mk4, mk5, mk6, mk7));

    daftarJadwal.add(new Jadwal(d1, mk1, "Senin", "08:00"));
    daftarJadwal.add(new Jadwal(d2, mk2, "Selasa", "10:00"));
    daftarJadwal.add(new Jadwal(d3, mk3, "Rabu", "09:00"));
    daftarJadwal.add(new Jadwal(d1, mk4, "Kamis", "13:00"));
    daftarJadwal.add(new Jadwal(d4, mk5, "Jumat", "07:00"));
    daftarJadwal.add(new Jadwal(d5, mk6, "Senin", "11:00"));
    daftarJadwal.add(new Jadwal(d2, mk7, "Rabu", "14:00"));
}

static void tampilDosen() {
    System.out.println("=== DATA DOSEN ===");
    for (Dosen d : daftarDosen) {
        d.tampilData();
        System.out.println();
    }
}

static void tampilMK() {
    System.out.println("=== DATA MATA KULIAH ===");
    for (MataKuliah mk : daftarMK) {
        mk.tampilData();
        System.out.println();
    }
}

static void tampilJadwal() {
    System.out.println("=== DATA JADWAL KULIAH ===");
    for (Jadwal j : daftarJadwal) {
        j.tampilData();
    }
}

static void urutkanJadwal() {
    Map<String, Integer> urutanHari = Map.of(
            "Senin", 1, "Selasa", 2, "Rabu", 3,
            "Kamis", 4, "Jumat", 5, "Sabtu", 6, "Minggu", 7);

    daftarJadwal.sort(Comparator.comparing((Jadwal j) -> urutanHari.get(j.hari))
            .thenComparing(j -> j.jam));

    System.out.println("=== JADWAL KULIAH TERURUT (Hari & Jam) ===");
    for (Jadwal j : daftarJadwal) {
        System.out.println(j.hari + " - " + j.jam + " | " + j.dosen.namaDosen + " - " + j.mataKuliah.namaMK);
    }
}

static void cariJadwal(Scanner input) {
    System.out.print("Input nama dosen: ");
    String nama = input.nextLine();
    boolean ditemukan = false;

    System.out.println("=== HASIL PENCARIAN JADWAL ===");
    for (Jadwal j : daftarJadwal) {
        if (j.dosen.namaDosen.equalsIgnoreCase(nama)) {
            System.out.println("Dosen: " + j.dosen.namaDosen);
            System.out.println("Mata Kuliah: " + j.mataKuliah.namaMK);
            System.out.println("Hari: " + j.hari);
            System.out.println("Jam: " + j.jam + "\n");
            ditemukan = true;
        }
    }

    if (!ditemukan) {
        System.out.println("Data dosen dengan nama \"" + nama + "\" tidak ditemukan.");
    }
}

}
