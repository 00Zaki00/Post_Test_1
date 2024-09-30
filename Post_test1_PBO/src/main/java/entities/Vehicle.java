/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author ACER NITRO
 */
public class Vehicle {
    private String licensePlate;
    private String vehicleType;
    private String ownerName;

    public static int totalVehicles = 0; // Static keyword

    // Constructor
    public Vehicle(String licensePlate, String vehicleType, String ownerName) {
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
        this.ownerName = ownerName;
        totalVehicles++; // Setiap kali kendaraan dibuat, jumlah kendaraan bertambah
    }

    // Getter dan Setter
    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    // Method untuk menampilkan detail kendaraan
    public void displayInfo() {
        System.out.println("License Plate: " + licensePlate);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Owner Name: " + ownerName);
    }
}
