/**
 * The class Vehicle is the superclass of the classes Car and Bike
 * It contains the plate number of the vehicle
 */


public class Vehicle {

    /**
     * The plate number of the vehicle
     * It is String because it can contain letters and numbers
     */
    String plateNr;


    /**
     * @return the plate number of the vehicle
     */
    public String getPlateNr() {
        return plateNr;
    }
}
