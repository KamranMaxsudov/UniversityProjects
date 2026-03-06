package MidtermSample3;

public class Employee {

    // Private fields
    private int id;
    private String name;
    private double salary;
    private String department;

    // Constructor 1
    public Employee(int id, String name) {
        this(id, name, 1000.0, "General"); // constructor chaining
    }

    // Constructor 2
    public Employee(int id, String name, double salary, String department) {
        this.id = id;
        this.name = name;

        // Validation for salary
        if (salary > 0) {
            this.salary = salary;
        } else {
            this.salary = 1000.0;
        }

        // Validation for department
        if (department != null && !department.isEmpty()) {
            this.department = department;
        } else {
            this.department = "General";
        }
    }

    // Calculate yearly salary
    public double calculateYearlySalary() {
        return salary * 12;
    }

    // Increase salary by percent
    public void increaseSalary(double percent) {
        if (percent > 0) {
            salary = salary + (salary * percent / 100);
        }
    }

    // Get department code using switch
    public String getDepartmentCode() {
        switch (department) {
            case "IT":
                return "001";
            case "HR":
                return "002";
            case "Finance":
                return "003";
            case "Sales":
                return "004";
            default:
                return "000";
        }
    }

    // Override toString
    @Override
    public String toString() {
        return "Employee{id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }

    // Override equals (based only on id)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Employee employee = (Employee) obj;
        return this.id == employee.id;
    }

    // Override hashCode
    @Override
    public int hashCode() {
        return id;
    }
}