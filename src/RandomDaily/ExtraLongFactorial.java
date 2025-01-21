package RandomDaily;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Result {

    /*
     * Complete the 'extraLongFactorials' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void extraLongFactorials(int n) {
        // Write your code here
        BigInteger bigInteger = new BigInteger(String.valueOf(n));
        System.out.println(facto(bigInteger).toString());
    }

    public static BigInteger facto(BigInteger bi) {
        if (bi.equals(new BigInteger("0")))
            return new BigInteger("1");
        return bi.multiply(facto(bi.subtract(new BigInteger("1"))));
    }

}

public class ExtraLongFactorial {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.extraLongFactorials(n);

        bufferedReader.close();
    }
}
