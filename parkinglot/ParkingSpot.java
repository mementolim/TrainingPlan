package parkinglot;

public class ParkingSpot {
    private final VehicleSize size;
    private Vehicle currentVehicle;
    ParkingSpot(VehicleSize size) {
        this.size = size;
    }
    boolean fit(Vehicle V) {
        return currentVehicle == null && size.getSize() >= V.getSize().getSize();
    }
    void park (Vehicle V) {
        currentVehicle = V;
    }
    void leave() {
        currentVehicle = null;
    }
    Vehicle getVehicle() {
        return currentVehicle;
    }
}
