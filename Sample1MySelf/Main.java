package Sample1MySelf;

import MidtermSample3.Employee;

public class Main {
    public static void main(String[] args){
        Employee e1 = new Employee(1, "Kamran" , 2000, "IT");
        Employee e2 = new Employee(2, "Ali", 1500, "HR");
        Employee e3 = new Employee(3, "Nigar");
        
        Employee[] employees = {e1,e2,e3};

        for ( int i =0; i< employees.length; i++){
            employees[i].increaseSalary(10);

        }
        double limit = 2500; //x=2500
        int index = 0;

        while (index < employees.length) {
            if (employees[index].calculateYearlySalary() / 12 > limit) {
                System.out.println(employees[index]);
            }
            index++;
        }
        // Compare two employees
        System.out.println("e1 equals e2: " + e1.equals(e2));
        
    }
}