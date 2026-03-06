package MidtermSample2;

public class Main {

    public static void main(String[] args) {

        // Create array of 7 cars
        Car[] cars = new Car[7];

        cars[0] = new Car("VIN001", "Toyota", 2023, 20000);
        cars[1] = new Car("VIN002", "BMW", 2015, 95000);
        cars[2] = new Car("VIN003", "Mercedes", 2010, 150000);
        cars[3] = new Car("VIN004", "Audi", 2026, 5000);
        cars[4] = new Car("VIN005", "Kia", 2018, 110000);
        cars[5] = new Car("VIN006", "Hyundai", 2005, 220000);
        cars[6] = new Car("VIN007", "Lexus");

        // Drive some cars
        cars[0].drive(30000);
        cars[1].drive(10000);
        cars[6].drive(120000);

        // Print cars needing service
        System.out.println("Cars needing service:");
        for (Car car : cars) {
            if (car.needsService()) {
                System.out.println(car);
            }
        }

        // Compare two cars
        System.out.println();
        System.out.println("Comparing VIN001 and VIN002:");
        System.out.println(cars[0].equals(cars[1]));

        // Use for-each to display all cars
        System.out.println();
        System.out.println("All cars:");
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}