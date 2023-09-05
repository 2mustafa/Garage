import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        /**
         * ASCII art generated from http://patorjk.com/software/taag/#p=display&f=Big&t=Garage%20Simulator
         */
        System.out.println(" ██████    █████   ██████    █████    ██████   ███████ ");
        System.out.println("██        ██   ██  ██   ██  ██   ██  ██        ██      ");
        System.out.println("██   ███  ███████  ██████   ███████  ██   ███  █████   ");
        System.out.println("██    ██  ██   ██  ██   ██  ██   ██  ██    ██  ██      ");
        System.out.println(" ██████   ██   ██  ██   ██  ██   ██   ██████   ███████ ");
        System.out.println("Welcome to Garage Simulator");


        /**
         * The user is asked to enter the number of floors and parking slots per floor
         * The garage is created using the Garage constructor
         * without this information, the garage cannot be created and the program cannot continue
         * As in Pdf file, the Base size (number of parking slots per floor ) and the number of floors are not clear and must be flexible
         */
        System.out.println("Please enter number of floors: ");
        int numberOfFloors = scanner.nextInt();

        System.out.println("Please enter how many Parking-slots per floor: ");
        int parkingSlotsPerFloor = scanner.nextInt();

        /**
         * The garage is created using the Garage constructor
         * the garage is passed as a parameter to the constructor of Floor class
         * the garage is passed as a parameter to the constructor of ParkingSlot class (because it is using floor constructor)
         */
        Garage garage = new Garage(numberOfFloors, parkingSlotsPerFloor);


        System.out.println("Garage created with " + numberOfFloors + " floors and " + parkingSlotsPerFloor + " parking slots per floor.");
        System.out.println();
        System.out.println();


        /**
         * The user is asked to choose an option
         * This is the main menu of the program or the interface of the program
         * runs in a while loop until the user chooses to quit
         */
        while (true) {
            System.out.println("Please select an option:");
            System.out.println("1. Enter Vehicle to the Parking");
            System.out.println("2. Exit Vehicle from the Parking");
            System.out.println("3. Query Vehicle Position");
            System.out.println("4. Check Available Spaces");
            System.out.println("5. Quit");
            System.out.println("6. Help");

            int choice = scanner.nextInt();

            switch (choice) {
                /**
                 * Logic for entering a vehicle
                 * The user is asked to choose between car and motorcycle as in pdf file
                 * The user is asked to enter the plate number of the vehicle
                 * The vehicle is created using the carCreator or bikeCreator methods in the Car and Bike classes besed on the user choice
                 * The vehicle is parked in the first available parking slot
                 * If there is no available parking slot, the user is informed and the vehicle is not parked
                 * IF the vehicle is already parked, the user is informed and the vehicle is not parked
                 */
                case 1:
                    System.out.println("Is your vehicle a car or a motorcycle?");
                    System.out.println("1. Car");
                    System.out.println("2. Motorcycle");

                    int vehicleType = scanner.nextInt();
                    System.out.println("Please enter the plate number of your vehicle: ");
                    String plateNr = scanner.next();

                    int floorNumber = 0;
                    int parkingSlotNumber = 0;

                    if (vehicleType == 1) {
                        Car car = Car.carCreator(plateNr);
                        boolean vehicleParked = false;
                        // Iterate through each floor in the garage
                        for (Floor floor : garage.getFloors()) {
                            // Iterate through each parking slot on the current floor
                            for (ParkingSlot slot : floor.getParkingSlots().values()) {
                                if (slot.getVehicle() != null && slot.getVehicle().getPlateNr().equals(plateNr)) {
                                    System.out.println("Your car with plate number " + plateNr + " is already parked at floor " + floor.getFloorNumber() + " and parking slot " + slot.getId());
                                    vehicleParked = true;
                                    break;
                                } else if (slot.getVehicle() == null) {
                                    slot.setVehicle(car);
                                    floorNumber = floor.getFloorNumber();
                                    parkingSlotNumber = slot.getId();
                                    System.out.println("Your car with plate number " + plateNr + " is parked at floor " + floorNumber + " and parking slot " + parkingSlotNumber);
                                    vehicleParked = true;
                                    break;
                                }
                            }
                            if (vehicleParked) {
                                break;
                            }
                        }
                        if (!vehicleParked) {
                            System.out.println("No available parking slots for cars.");
                        }
                    } else if (vehicleType == 2) {
                        Bike bike = Bike.bikeCreator(plateNr);
                        boolean vehicleParked = false;

                        for (Floor floor : garage.getFloors()) {
                            for (ParkingSlot slot : floor.getParkingSlots().values()) {
                                if (slot.getVehicle() != null && slot.getVehicle().getPlateNr().equals(plateNr)) {
                                    System.out.println("Your bike with plate number " + plateNr + " is already parked at floor " + floor.getFloorNumber() + " and parking slot " + slot.getId());
                                    vehicleParked = true;
                                    break;
                                } else if (slot.getVehicle() == null) {
                                    slot.setVehicle(bike);
                                    floorNumber = floor.getFloorNumber();
                                    parkingSlotNumber = slot.getId();
                                    System.out.println("Your bike with plate number " + plateNr + " is parked at floor " + floorNumber + " and parking slot " + parkingSlotNumber);
                                    vehicleParked = true;
                                    break;
                                }
                            }
                            if (vehicleParked) {
                                break;
                            }
                        }
                        if (!vehicleParked) {
                            System.out.println("No available parking slots for bikes.");
                        }
                    } else {
                        System.out.println("Invalid choice. Please choose a valid option.");
                    }
                    break;

                    /**
                     * Logic for exiting a vehicle
                     * The user is asked to enter the plate number of the vehicle
                     * The vehicle is searched in the garage using a nested for loop
                     * If the vehicle is found, the vehicle is exited from the parking slot by declaring the parking slot as empty or null
                     * If the vehicle is not found, the user is informed
                     * the type of the vehicle is not asked because the plate number is unique for each vehicle
                     */
                case 2:
                    System.out.println("Please enter the plate number of your vehicle: ");
                    String exitPlateNr = scanner.next();

                    boolean vehicleFound = false;

                    for (Floor floor : garage.getFloors()) {
                        for (ParkingSlot slot : floor.getParkingSlots().values()) {
                            if (slot.getVehicle() != null && slot.getVehicle().getPlateNr().equals(exitPlateNr)) {
                                String vehicleTypeStr = (slot.getVehicle() instanceof Car) ? "car" : "bike";
                                System.out.println("Your " + vehicleTypeStr + " with plate number " + exitPlateNr + " has been exited from floor " + floor.getFloorNumber() + " and parking slot " + slot.getId());

                                // Assuming there's a method to remove the vehicle from the slot
                                slot.removeVehicle(); // You might need to implement this method

                                vehicleFound = true;
                                break;
                            }
                        }
                        if (vehicleFound) {
                            break;
                        }
                    }

                    if (!vehicleFound) {
                        System.out.println("No vehicle found with plate number " + exitPlateNr + " in the parking.");
                    }
                    break;

                /**
                 * Logic for querying vehicle position
                 * The user is asked to enter the plate number of the vehicle
                 * The entered vehicle is searched in the garage using a nested for loop
                 * If the vehicle is found, the floor number and parking slot number is printed
                 * If the vehicle is not found, the user is informed
                 * the type of the vehicle is not asked because the plate number is unique for each vehicle
                 */

                case 3:
                    System.out.println("Please enter the plate number of your vehicle: ");
                    String queryPlateNr = scanner.next();

                    boolean vehicleFound2 = false;
                    for (Floor floor : garage.getFloors()) {
                        for (ParkingSlot slot : floor.getParkingSlots().values()) {
                            if (slot.getVehicle() != null && slot.getVehicle().getPlateNr().equals(queryPlateNr)) {
                                String vehicleTypeStr = (slot.getVehicle() instanceof Car) ? "car" : "bike";
                                System.out.println("Your " + vehicleTypeStr + " with plate number " + queryPlateNr + " is parked at floor " + floor.getFloorNumber() + " and parking slot " + slot.getId());
                                vehicleFound2 = true;
                                break;
                            }
                        }
                        if (vehicleFound2) {
                            break;
                        }
                    }

                    break;

                    /**
                     * Logic for checking available spaces
                     * The number of available parking slots is counted using a nested for loop
                     * The number of available parking slots is printed
                     * The user is not asked to enter anything
                     * The type of the vehicle is not asked because the plate number is unique for each vehicle
                     */
                case 4:
                    // Logic for checking available spaces
                    for (Floor floor : garage.getFloors()) {
                        int availableParkingSlots = 0;
                        for (ParkingSlot slot : floor.getParkingSlots().values()) {
                            if (slot.getVehicle() == null) {
                                availableParkingSlots++;
                            }
                        }
                        System.out.println("Floor " + floor.getFloorNumber() + " has " + availableParkingSlots + " available parking slots.");
                    }
                    break;

                    /**
                     * Logic for quitting
                     * The program is exited using System.exit(0)
                     * The user is not asked to enter anything
                     */
                case 5:
                    System.out.println("Exiting Garage Simulator. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                /**
                 * prints the main menu again as Help option
                 */
                case 6:
                    System.out.println("1. Enter Vehicle to the Parking");
                    System.out.println("2. Exit Vehicle from the Parking");
                    System.out.println("3. Query Vehicle Position");
                    System.out.println("4. Check Available Spaces");
                    System.out.println("5. Quit");
                    System.out.println("6. Help");
                    System.out.println();
                    break;

                    /**
                     * prints an error message if the user enters an invalid choice (not between 1 and 6)
                     */


                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
                    break;
            }

        }

    }

    }






