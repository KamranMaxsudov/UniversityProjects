import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Choose version:");
        System.out.println("1 - Without signs");
        System.out.println("2 - With signs");

        int choice = sc.nextInt();

        int[] result;


        if (choice == 1) {
            
            System.out.print("Enter numerator1: ");
            int n1 = sc.nextInt();

            System.out.print("Enter denominator1: ");
            int d1 = sc.nextInt();

            System.out.print("Enter numerator2: ");
            int n2 = sc.nextInt();

            System.out.print("Enter denominator2: ");
            int d2 = sc.nextInt();

            result = FractionUtil.addFractions(n1, d1, n2, d2);

        } else {
            System.out.print("Enter sign1 (+ or -): ");
            char sign1 = sc.next().charAt(0);

            System.out.print("Enter numerator1: ");
            int n1 = sc.nextInt();

            System.out.print("Enter denominator1: ");
            int d1 = sc.nextInt();

            System.out.print("Enter sign2 (+ or -): ");
            char sign2 = sc.next().charAt(0);

            System.out.print("Enter numerator2: ");
            int n2 = sc.nextInt();

            System.out.print("Enter denominator2: ");
            int d2 = sc.nextInt();

            result = FractionUtil.addFractionsWithSigns(
                    sign1, n1, d1,
                    sign2, n2, d2
            );
        }

        System.out.println("Output:");
        System.out.println(result[0] + ", " + result[1]);
    }
}
