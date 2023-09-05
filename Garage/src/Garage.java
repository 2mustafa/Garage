import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a garage
 * has the relationship with class Floor (1 to many , composition)
 * when creating a floor, the garage is passed as a parameter (in Garage constructor the keyword this is used to pass the current garage object)
 * has the relationship with class ParkingSlot (1 to many)
 */
public class Garage {
    private final List<Floor> floors = new ArrayList<>();
    private final Map<Integer, ParkingSlot> parkingSlots = new HashMap<>();






    /**
     * Garage constructor creates a new garage with the given number of floors and parking slots per floor
     * @param numberOfFloors     = how many floors should the garage have
     *                           = the floors are created in a for loop using the floor constructor
     * @param parkingSlotsPerFloor = how many parking slots should each floor have
     *
     */
    public Garage(int numberOfFloors, int parkingSlotsPerFloor) {
        for (int i = 0; i < numberOfFloors; i++) {
            Floor floor = new Floor(i + 1, parkingSlotsPerFloor, this);
            floors.add(floor);
            parkingSlots.putAll(floor.getParkingSlots());
        }
    }


    /**
     * @return returns a list of Floor instances that are part of the garage
     */
    public List<Floor> getFloors() {
        return floors;
    }

}