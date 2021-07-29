package parkinglot;

import com.sun.javaws.exceptions.NativeLibViolationException;

public class ParkingLot {
    private final Level[] levels;
    public ParkingLot(int numLevels, int numSpotsPerLevel) {
        levels = new Level[numLevels];
        for (int i = 0; i < numLevels; i++) {
            levels[i] = new Level(numSpotsPerLevel);
        }
    }
    boolean  hasSpot(Vehicle V) {
        for (Level l : levels) {
            if (l.hasSpot(V)) {
                return true;
            }
        }
        return false;
    }
    public boolean park(Vehicle V) {
        for (Level l : levels) {
            if (l.park(V)){
                return true;
            }
        }
        return false;
    }
    public boolean leave(Vehicle V) {
        for (Level l : levels) {
            if (l.leave(V)){
                return true;
            }
        }
        return false;
    }
}
