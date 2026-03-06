package MidtermSample1;

import java.util.Arrays;

public class Course {

    // Fields (private as required)
    private String courseCode;
    private String courseName;
    private int credits;
    private double[] grades;

    // Constructor 1
    public Course(String code, String name, int credits) {
        this.courseCode = code;
        this.courseName = name;

        if (credits >= 1 && credits <= 6) {
            this.credits = credits;
        } else {
            this.credits = 1;   // default value if invalid
        }

        this.grades = new double[0];  // empty array initially
    }

    // Constructor 2
    public Course(String code, String name, int credits, double[] grades) {
        this.courseCode = code;
        this.courseName = name;

        if (credits >= 1 && credits <= 6) {
            this.credits = credits;
        } else {
            this.credits = 1;
        }

        // validate grades (0–100)
        this.grades = new double[0];
        for (double g : grades) {
            if (g >= 0 && g <= 100) {
                addGrade(g);
            }
        }
    }

    // Calculate average
    public double calculateAverage() {
        if (grades.length == 0) {
            return 0;
        }

        double sum = 0;
        for (double g : grades) {
            sum += g;
        }

        return sum / grades.length;
    }

    // Letter grade using switch
    public String getLetterGrade() {
        double avg = calculateAverage();
        char letter;

        if (avg >= 90) {
            letter = 'A';
        } else if (avg >= 80) {
            letter = 'B';
        } else if (avg >= 70) {
            letter = 'C';
        } else if (avg >= 60) {
            letter = 'D';
        } else {
            letter = 'F';
        }

        switch (letter) {
            case 'A': return "A";
            case 'B': return "B";
            case 'C': return "C";
            case 'D': return "D";
            default:  return "F";
        }
    }

    // Add new grade
    public void addGrade(double grade) {
        if (grade >= 0 && grade <= 100) {
            grades = Arrays.copyOf(grades, grades.length + 1);
            grades[grades.length - 1] = grade;
        }
    }

    // Override toString()
    @Override
    public String toString() {
        return "Course Code: " + courseCode +
               ", Name: " + courseName +
               ", Credits: " + credits +
               ", Grades: " + Arrays.toString(grades);
    }

    // Override equals() (based on courseCode)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Course other = (Course) obj;

        return this.courseCode.equals(other.courseCode);
    }

    // Override hashCode()
    @Override
    public int hashCode() {
        return courseCode.hashCode();
    }
}