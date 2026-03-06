package KamranMaxsudovTask2;

import java.util.Arrays;
import java.util.Objects;

public class Student {

    private String name;
    private int age;
    private double[] grades;

    // Default constructor
    public Student() {
        this.name = "Unknown";
        this.age = 0;
        this.grades = new double[0];
    }

    // Constructor without grades
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.grades = new double[0];
    }

    // Constructor with grades
    public Student(String name, int age, double[] grades) {
        this.name = name;
        this.age = age;
        this.grades = (grades == null) ? new double[0] : Arrays.copyOf(grades, grades.length);
    }

    // Getters
    public String getName() { return this.name; }
    public int getAge() { return this.age; }
    public double[] getGrades() { return Arrays.copyOf(this.grades, this.grades.length); }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }

    public void setGrades(double[] grades) {
        this.grades = (grades == null) ? new double[0] : Arrays.copyOf(grades, grades.length);
    }

    //  methods 
    public double calculateAverage() {
        if (this.grades.length == 0) return 0.0;
        double sum = 0;
        for (double g : this.grades) sum += g;
        return sum / this.grades.length;
    }

    public double getMaxGrade() {
        if (this.grades.length == 0) return 0.0;
        double max = this.grades[0];
        for (double g : this.grades)
            if (g > max) max = g;
        return max;
    }

    public double getMinGrade() {
        if (this.grades.length == 0) return 0.0;
        double min = this.grades[0];
        for (double g : this.grades)
            if (g < min) min = g;
        return min;
    }

    // equals / hashCode / toString  ( we @Override method cause we want it to work as we want)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student other = (Student) obj;
        return age == other.age && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, age);
        result = 31 * result + Arrays.hashCode(grades);
        return result;
    }

    @Override
    public String toString() {
        return "Name: " + name +
               "\nAge: " + age +
               "\nGrades: " + Arrays.toString(grades);
    }
}