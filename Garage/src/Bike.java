public class Bike extends Vehicle {

    /**
     * Creates a new bike with the given plate number
     * @param plateNr
     * @return the new bike with the given plate number
     */
    public static Bike bikeCreator(String plateNr) {
        Bike bike = new Bike();
        bike.plateNr = plateNr;
        return bike;
    }
}
