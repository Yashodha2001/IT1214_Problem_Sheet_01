class Vehicle {
    private String licensePlate;
    private String ownerName;
    private int hoursParked;

    public Vehicle(String licensePlate, String ownerName, int hoursParked) {
        this.licensePlate = licensePlate;
        this.ownerName = ownerName;
        this.hoursParked = hoursParked;
    }

    // All getters and setters
    public String getLicensePlate() { return licensePlate; }
    public String getOwnerName() { return ownerName; }
    public int getHoursParked() { return hoursParked; }
    public void setLicensePlate(String plate) { licensePlate = plate; }
    public void setOwnerName(String name) { ownerName = name; }
    public void setHoursParked(int hours) { hoursParked = hours; }
}

class ParkingLot {
    private Vehicle[] vehicles;
    private int vehicleCount;

    public ParkingLot() {
        vehicles = new Vehicle[5];
        vehicleCount = 0;
    }

    public void parkVehicle(Vehicle vehicle) {
        if (vehicleCount < 5) {
            vehicles[vehicleCount++] = vehicle;
        } else {
            System.out.println("Parking lot is full (5 vehicles max)");
        }
    }

    public void removeVehicle(String licensePlate) {
        for (int i = 0; i < vehicleCount; i++) {
            if (vehicles[i].getLicensePlate().equals(licensePlate)) {
                // Shift remaining vehicles
                for (int j = i; j < vehicleCount - 1; j++) {
                    vehicles[j] = vehicles[j + 1];
                }
                vehicles[--vehicleCount] = null;
                System.out.println("Vehicle " + licensePlate + " removed");
                return;
            }
        }
        System.out.println("Vehicle " + licensePlate + " not found");
    }

    public void displayAllVehicles() {
        System.out.println("License\t\tOwner\t\tHours Parked");
        System.out.println("----------------------------------------");
        for (int i = 0; i < vehicleCount; i++) {
            System.out.printf("%-10s\t%-15s\t%d\n",
                vehicles[i].getLicensePlate(),
                vehicles[i].getOwnerName(),
                vehicles[i].getHoursParked());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot();
        
        lot.parkVehicle(new Vehicle("ABC123", "John Doe", 2));
        lot.parkVehicle(new Vehicle("XYZ789", "Jane Smith", 4));
        lot.parkVehicle(new Vehicle("LMN456", "Bob Brown", 1));
        
        lot.removeVehicle("XYZ789");
        lot.removeVehicle("NONEXISTENT");
        
        lot.displayAllVehicles();
    }
}