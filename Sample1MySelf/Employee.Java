package Sample1Myself;

import java.util.Arrays;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private String department;


    public Employee ( int id, String name){
    this(id, name);
    }
    public Employee ( int id, String name, double salary, String departmen){
    this(id, name);

        if (salary >0){
        this.salary = salary;

        }else{
        this.salary = 1000.0;
        }
        if ( department !=null || !deparment.trim.isEmpty()){
        this.department = department;

        }else{
            this.department = "General";
        }

    }  
    public double calculateYearlySalary(){
    return salary * 12;
    }
    public void increaseSalary(double percent){
        if (percent > 0){
            salary = salary + salary * percent /100;
    }

    }
    public String getDepartmentCode() {
        switch (deparment){
            case "it" : return "1001";
            case "hr " : return "1002";
        }
    }
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}