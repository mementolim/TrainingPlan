package parkinglot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Level {
    private final List<ParkingSpot> spots;
    Level (int numOfSpots) {
        List<ParkingSpot> list = new ArrayList<>(numOfSpots);
        int i = 0;
        for (; i < numOfSpots / 2; i++) {
            list.add(new ParkingSpot(VehicleSize.Compact));
        }
        for (; i < numOfSpots; i++) {
            list.add(new ParkingSpot(VehicleSize.Large));
        }
        spots = Collections.unmodifiableList(list);
    }
    boolean  hasSpot(Vehicle V) {
        for (ParkingSpot s : spots) {
            if (s.fit(V)) {
                return true;
            }
        }
        return false;
    }
    boolean  park(Vehicle V) {
        for (ParkingSpot s : spots) {
            if (s.fit(V)) {
                s.park(V);
                return true;
            }
        }
        return false;
    }
    boolean leave(Vehicle V) {
        for (ParkingSpot s : spots) {
            if (s.getVehicle() == V) {
                s.leave();
                return true;
            }
        }
        return false;
    }
}
//1. high level 开始讲
//2. 各个类之间的关系
//parkingLot has-a level
//level has-a parkingSpot
//Vehicle : car and truck extends vehicle
// is- a 继承关系
//3. 实现一个停车场 类与类之间的交互
//4. never use "simple"
//elegant / tricky