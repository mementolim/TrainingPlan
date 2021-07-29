package parkinglot;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot(4, 10);
        List<Vehicle> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            final Vehicle V = i % 2 == 0 ? new Car() : new Truck();
            list.add(V);
            boolean hasSpot = lot.hasSpot(V);
            if (i < 40) {
                assert hasSpot;
                assert lot.park(V);
            }else {
                assert !hasSpot;
                assert !lot.park(V);
            }
        }
        assert list.size() == 50;
        int i = 0;
        for (Vehicle V : list) {
            assert i >= 40 || lot.leave(V);
            i++;
        }
    }
}
