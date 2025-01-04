package RandomDaily;

import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*Problem statement
You are given an array/list 'ARR' of integers of length ‘N’.
You are supposed to find all the elements that occur strictly more than floor(N/3) times in the given array/list.
*/

public class MajorityElement2 {
    public static ArrayList<Integer> majorityElementII(ArrayList<Integer> arr) {
        // Write your code here.
        int n = (int)Math.floor(arr.size() / 3.0);

        return arr.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > n)
                .map(Map.Entry::getKey).collect(Collectors.toCollection(ArrayList::new));
    }
}