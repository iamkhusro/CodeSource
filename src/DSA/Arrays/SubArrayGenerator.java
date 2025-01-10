package DSA.Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubArrayGenerator {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        Set<List<Integer>> subs = new HashSet<>();
        subs.add(new ArrayList<>()); // Start with an empty subset

        for (int num : arr) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> subset : subs) {
                List<Integer> newSubset = new ArrayList<>(subset);
                newSubset.add(num);
                newSubsets.add(newSubset);
            }
            subs.addAll(newSubsets);
        }

        // Print the result
        System.out.println(subs);
    }
}