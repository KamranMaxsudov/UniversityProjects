package MidtermSample3;

public class Main {

    public static void main(String[] args) {

        // Create employees
        Employee e1 = new Employee(1, "Ali", 2000, "IT");
        Employee e2 = new Employee(2, "Leyla", 2500, "HR");
        Employee e3 = new Employee(3, "Kamran", 3000, "Finance");

        // Store in array
        Employee[] employees = {e1, e2, e3};

        // Print employees with salary > 2500 using while loop
        double limit = 2500;
        int index = 0;

        while (index < employees.length) {
            if (employees[index].calculateYearlySalary() / 12 > limit) {
                System.out.println(employees[index]);
            }
            index++;
        }
        // Increase salary using for loop
        for (int i = 0; i < employees.length; i++) {
            employees[i].increaseSalary(10); // increase by 10%
        }

        

        // Compare two employees
        System.out.println("e1 equals e2: " + e1.equals(e2));
        System.out.println("e1 equals new Employee(1, \"Test\"): " +
                e1.equals(new Employee(1, "Test")));
    }
}