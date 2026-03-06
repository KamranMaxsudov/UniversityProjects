package MidtermSample1;

public class Main {

    public static void main(String[] args) {

        // Create 2 courses
        Course c1 = new Course("CS101", "Programming I", 4);
        Course c2 = new Course("CS101", "Intro to Programming", 3);

        // Add grades
        c1.addGrade(85);
        c1.addGrade(90);
        c1.addGrade(78);

        c2.addGrade(60);
        c2.addGrade(70);

        // Print average and letter grade
        System.out.println(c1);
        System.out.println("Average: " + c1.calculateAverage());
        System.out.println("Letter Grade: " + c1.getLetterGrade());

        System.out.println();

        System.out.println(c2);
        System.out.println("Average: " + c2.calculateAverage());
        System.out.println("Letter Grade: " + c2.getLetterGrade());

        // Compare two courses
        System.out.println();
        System.out.println("Are courses equal? " + c1.equals(c2));
    }
}
