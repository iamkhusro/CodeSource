package RandomDaily;
//TODO
public class DivisionUpToNDecimal {
    public static String divideUpToNDecimalPlaces(int X, int Y, int N) {
        StringBuilder result = new StringBuilder();

        // Integer part of the division
        int integerPart = X / Y;
        result.append(integerPart).append(".");

        // Get the remainder
        int remainder = X % Y;

        // Compute the fractional part up to N decimal places
        for (int i = 0; i < N; i++) {
            remainder *= 10;
            int digit = remainder / Y;
            result.append(digit);
            remainder %= Y;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int X = 5, Y = 4, N = 5;
        System.out.println(divideUpToNDecimalPlaces(X, Y, N)); // Output: 1.25000

        // Additional examples
        System.out.println(divideUpToNDecimalPlaces(10, 3, 6)); // Output: 3.333333
        System.out.println(divideUpToNDecimalPlaces(1, 2, 4));  // Output: 0.5000
    }
}