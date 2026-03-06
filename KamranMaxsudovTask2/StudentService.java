package KamranMaxsudovTask2;

public class StudentService {
    public Student createStudent(String name, int age, int[] grades) {
        if (grades == null) return new Student(name, age, new double[0]);

        double[] d = new double[grades.length];
        for (int i = 0; i < grades.length; i++) {
            d[i] = grades[i];
        }
        return new Student(name, age, d);
    }
    public void printAllStudents(Student[] students) {
        for (Student s : students) {
            System.out.println("------------");
            System.out.println(s);
        }
    }
    public Student getTopStudent(Student[] students) {
        if (students.length == 0) return null;

        Student top = students[0];
        for (Student s : students) {
            if (s.calculateAverage() > top.calculateAverage()) {
                top = s;
            }
        }
        return top;
    }
    public double getClassAverage(Student[] students) {
        if (students.length == 0) return 0;

        double sum = 0;
        for (Student s : students) {
            sum += s.calculateAverage();
        }
        return sum / students.length;
    }
    public double calculateAverage(int[] grades) {
        if (grades == null || grades.length == 0) return 0;

        double sum = 0;
        for (int g : grades) sum += g;
        return sum / grades.length;
    }

    public double calculateAverage(Student student) {
        if (student == null) return 0;
        return student.calculateAverage();
    }
}