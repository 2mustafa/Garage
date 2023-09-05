public class Car extends Vehicle {

    /**
     * Creates a new car with the given plate number
     * @param plateNr
     * @return the new car with the given plate number
     */
    public static Car carCreator(String plateNr) {
        Car car = new Car();
        car.plateNr = plateNr;
        return car;
    }
}
