package RandomDaily;


//Given an array, 'ARR' of 'N' integers print “true” if it is possible to split the array into some finite number of subset.
//Such that each subset has the same integer in it and all subsets have the same size.
//The size of the subset should be greater than one.
//Print “false” if it is not possible to do the above task.
//Example:
//Input: 'ARR' = [1, 2, 4, 4, 1, 2]
//Output: true
//We can split the above array like this: [1, 1], [4, 4], [2, 2]
//In the three subsets, each of size two. And every subset contains the same elements.

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SplitArrayIntoTheSubsets {
    public static boolean isPossibleToSplit(int n, int[] arr) {
        // Write your code here.
        List<Long> longList = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(
                        Function.identity(), Collectors.counting()))
                .values().stream().toList();


        if (longList.size() > 1) {
            long first = longList.get(0);
            if (first == 1)
                return false;
            return longList.stream().allMatch(num -> num == first);
        }

        return false;
    }

    //main
}
