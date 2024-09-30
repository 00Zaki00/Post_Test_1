/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package management;
import entities.Vehicle;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ACER NITRO
 */

public class TrafficManagement {
    private ArrayList<Vehicle> vehicles;

    // Constructor
    public TrafficManagement() {
        vehicles = new ArrayList<>();
    }

    // Method CRUD
    // 1. Create (Tambah Kendaraan)
    public void addVehicle(String licensePlate, String vehicleType, String ownerName) {
        Vehicle newVehicle = new Vehicle(licensePlate, vehicleType, ownerName);
        vehicles.add(newVehicle);
        System.out.println("Kendaraan berhasil ditambahkan!");
    }

    // 2. Read (Lihat semua kendaraan)
    public void displayVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("Belum ada kendaraan yang terdaftar.");
        } else {
            for (Vehicle vehicle : vehicles) { // For-each loop
                vehicle.displayInfo();
                System.out.println("-------------------");
            }
        }
    }

    // 3. Update (Ubah data kendaraan berdasarkan plat nomor)
    public void updateVehicle(String licensePlate) {
        boolean found = false;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getLicensePlate().equals(licensePlate)) {
                Scanner sc = new Scanner(System.in);
                System.out.print("Masukkan jenis kendaraan baru: ");
                String newType = sc.nextLine();
                System.out.print("Masukkan nama pemilik baru: ");
                String newOwner = sc.nextLine();
                vehicle.setVehicleType(newType);
                vehicle.setOwnerName(newOwner);
                System.out.println("Kendaraan berhasil diperbarui!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Kendaraan dengan plat nomor tersebut tidak ditemukan.");
        }
    }

    // 4. Delete (Hapus kendaraan berdasarkan plat nomor)
    public void deleteVehicle(String licensePlate) {
        Vehicle vehicleToRemove = null;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getLicensePlate().equals(licensePlate)) {
                vehicleToRemove = vehicle;
                break;
            }
        }
        if (vehicleToRemove != null) {
            vehicles.remove(vehicleToRemove);
            System.out.println("Kendaraan berhasil dihapus!");
            Vehicle.totalVehicles--; // Mengurangi jumlah kendaraan
        } else {
            System.out.println("Kendaraan dengan plat nomor tersebut tidak ditemukan.");
        }
    }

    // Method tambahan untuk melihat total kendaraan
    public static void displayTotalVehicles() {
        System.out.println("Total Kendaraan: " + Vehicle.totalVehicles);
    }

    // Main method untuk menjalankan sistem
    public static void main(String[] args) {
        TrafficManagement tm = new TrafficManagement();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Sistem Manajemen Lalu Lintas ===");
            System.out.println("1. Tambah Kendaraan");
            System.out.println("2. Lihat Semua Kendaraan");
            System.out.println("3. Perbarui Kendaraan");
            System.out.println("4. Hapus Kendaraan");
            System.out.println("5. Lihat Total Kendaraan");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            choice = sc.nextInt();
            sc.nextLine();  // Clear input buffer

            switch (choice) {
                case 1:
                    System.out.print("Masukkan plat nomor: ");
                    String licensePlate = sc.nextLine();
                    System.out.print("Masukkan jenis kendaraan: ");
                    String vehicleType = sc.nextLine();
                    System.out.print("Masukkan nama pemilik: ");
                    String ownerName = sc.nextLine();
                    tm.addVehicle(licensePlate, vehicleType, ownerName);
                    break;
                case 2:
                    tm.displayVehicles();
                    break;
                case 3:
                    System.out.print("Masukkan plat nomor kendaraan yang ingin diubah: ");
                    String updatePlate = sc.nextLine();
                    tm.updateVehicle(updatePlate);
                    break;
                case 4:
                    System.out.print("Masukkan plat nomor kendaraan yang ingin dihapus: ");
                    String deletePlate = sc.nextLine();
                    tm.deleteVehicle(deletePlate);
                    break;
                case 5:
                    TrafficManagement.displayTotalVehicles();
                    break;
                case 6:
                    System.out.println("Keluar dari sistem.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } while (choice != 6);
    }
}
