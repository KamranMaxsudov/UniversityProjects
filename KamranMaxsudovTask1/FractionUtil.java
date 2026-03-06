public class FractionUtil {

    //  VERSION 1
    public static int[] addFractions(int n1, int d1, int n2, int d2) {

        int lcm = lcm(d1, d2);

        int newN1 = n1 * (lcm / d1);
        int newN2 = n2 * (lcm / d2);

        int resultNumerator = newN1 + newN2;
        int resultDenominator = lcm;

        int gcd = gcd(Math.abs(resultNumerator), resultDenominator);

        return new int[]{
                resultNumerator / gcd,
                resultDenominator / gcd
        };
    }

    //VERSION 2 (with signs)
    public static int[] addFractionsWithSigns(
            char sign1, int n1, int d1,
            char sign2, int n2, int d2) {

        if (sign1 == '-') n1 = -n1;
        if (sign2 == '-') n2 = -n2;

        return addFractions(n1, d1, n2, d2);
    }

    // GCD (Ebob) (Euclidean Algorithm) -----------
    private static int gcd(int a, int b) {
    while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // LCM  (Ekob)
    private static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
