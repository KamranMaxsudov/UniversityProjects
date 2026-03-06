package KamranMaxsudovTask2;

public class Main {

    public static void main(String[] args) {

        StudentService service = new StudentService();

        // REQUIRED: at least 3 students
        Student s1 = service.createStudent("Kamran", 20, new int[]{85, 90, 87});
        Student s2 = service.createStudent("Jeffrey Epstein", 19, new int[]{70, 75, 80});
        Student s3 = service.createStudent("Donald Trump", 21, new int[]{94, 92, 96});

        Student[] students = {s1, s2, s3};

        // REQUIRED: for-each loop processing
        System.out.println("Student statistics:");
        for (Student s : students) {
            System.out.println("------------");
            System.out.println("Name: " + s.getName());
            System.out.println("Average: " + s.calculateAverage());
            System.out.println("Max: " + s.getMaxGrade());
            System.out.println("Min: " + s.getMinGrade());
        }

        // Print all students
        System.out.println("\nAll students:");
        service.printAllStudents(students);

        // Top student
        Student top = service.getTopStudent(students);
        System.out.println("\nTop student:");
        System.out.println(top.getName() + " with average " + top.calculateAverage());

        // Class average
        System.out.println("\nClass average: " + service.getClassAverage(students));
    }
}