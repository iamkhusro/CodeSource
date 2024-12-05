package DSA.String;


import java.math.BigInteger;

public class BigIntAdd {

    public static String stringConcatenation(String num1, String num2) {
        // Write your code here.
        BigInteger b1 = new BigInteger(num1);
        BigInteger b2 = new BigInteger(num2);
        BigInteger sum = b1.add(b2);
        return sum.toString();
    }

    //main method

}
