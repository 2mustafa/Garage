public class ParkingSlot {


    private final int id;
    private final Floor floor;
    private Vehicle vehicle;


    /**
     * @return the ID of the parking slot (the ID is unique for each parking slot which is created in the for loop in Floor constructor)
     */
    public int getId() {
        return id;
    }



    /**
     * sets the vehicle type of car to the parking slot
     */
    public void setVehicle(Car car) {
        this.vehicle = car;
    }

    /**
     * sets the vehicle type of bike to the parking slot
     */
    public void setVehicle(Bike bike) {
        this.vehicle = bike;
    }


    /**
     * Gets the vehicle currently parked in this parking slot.
     * @return the vehicle currently parked in the slot (Car or Bike)
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * By setting the vehicle to null, the parking slot would be empty as primarily initialized in the constructor
     */
    public void removeVehicle() {
        this.vehicle = null;
    }


    /**
     * This Constructor Creates a new parking slot with the given id and floor
     * @param id = the id of the parking slot
     * @param floor = the floor of the parking slot
     * The vehicle is initialized as null so that the parking slot is empty and there is no need to create a vehicle object for each parking slot beforehand
     */
    public ParkingSlot(int id, Floor floor) {
        this.id = id;
        this.floor = floor;
        this.vehicle = null; // Initialize as empty
    }
}
