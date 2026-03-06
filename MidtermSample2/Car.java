package MidtermSample2;
public class Car {

    private String vin;
    private String brand;
    private int year;
    private double mileage;

    // Constructor 1
    public Car(String vin, String brand) {
        this.vin = vin;
        this.brand = brand;
        this.year = 2026;   // default year
        this.mileage = 0;
    }

    // Constructor 2
    public Car(String vin, String brand, int year, double mileage) {
        this.vin = vin;
        this.brand = brand;

        int currentYear = 2026;

        // Year validation (cannot be future)
        if (year <= currentYear) {
            this.year = year;
        } else {
            this.year = currentYear;
        }

        // Mileage validation (cannot be negative)
        if (mileage >= 0) {
            this.mileage = mileage;
        } else {
            this.mileage = 0;
        }
    }

    // Drive method
    public void drive(double distance) {
        if (distance > 0) {
            mileage += distance;
        }
    }

    // Needs service if mileage > 100000
    public boolean needsService() {
        return mileage > 100000;
    }

    // Car age category
    public String getCarAgeCategory() {
        int age = 2026 - year;

        if (age <= 3) {
            return "New";
        } else if (age <= 10) {
            return "Used";
        } else {
            return "Old";
        }
    }

    // toString override
    @Override
    public String toString() {
        return "VIN: " + vin +
               ", Brand: " + brand +
               ", Year: " + year +
               ", Mileage: " + mileage +
               ", Age Category: " + getCarAgeCategory();
    }

    // equals override (based on vin)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Car other = (Car) obj;

        return this.vin.equals(other.vin);
    }

    // hashCode override
    @Override
    public int hashCode() {
        return vin.hashCode();
    }
}