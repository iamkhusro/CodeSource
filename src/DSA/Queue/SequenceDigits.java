package DSA.Queue;

import java.util.*;

public class SequenceDigits {

    public static ArrayList<Long> createSequence(long n){
        ArrayList<Long> res = new ArrayList<>();
        Queue<Long> queue = new LinkedList<>();

        // Start with the valid digits
        queue.add(2L);
        queue.add(5L);

        while (!queue.isEmpty()) {
            long current = queue.poll();

            // Stop if the current number exceeds n
            if (current > n)
                continue;

            // Add the valid number to the result
            res.add(current);

            // Generate the next numbers by appending 2 and 5
            queue.add(current * 10 + 2);
            queue.add(current * 10 + 5);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(createSequence(500));//sequence formed by the digits less than the provided number
    }
}
