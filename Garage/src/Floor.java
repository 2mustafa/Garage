import java.util.HashMap;
import java.util.Map;

/**
 * Represents a floor in the garage
 */
public class Floor {
    private final int floorNumber;


    /**
     * Key: parking slot id
     * Value: parking slot
     */
    private final Map<Integer, ParkingSlot> parkingSlots = new HashMap<>();


    /**
     * @return the parking slots of the floor as a map containing the parking slot id as key and the parking slot as value
     */
    public Map<Integer, ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }


    /**
     * @return the floor number
     */
    public int getFloorNumber() {
        return floorNumber;
    }

    /**
     * This Constructor Creates a new floor with the given floor number and number of parking slots
     * @param floorNumber     = how many floors should the garage have
     * @param numParkingSlots = how many parking slots should each floor have
     * The for loop creates the parking slots using ParkingSlot constructor and adds them to the parkingSlots map
     */
    public Floor(int floorNumber, int numParkingSlots , Garage garage) {
        this.floorNumber = floorNumber;
        for (int i = 0; i < numParkingSlots; i++) {
            ParkingSlot parkingSlot = new ParkingSlot(i + 1, this);
            parkingSlots.put(parkingSlot.getId(), parkingSlot);
        }
    }
}