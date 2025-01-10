package DSA.Arrays;

import java.util.*;

public class SubArrayGenerator {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2};
        Set<List<Integer>> subs = new HashSet<>();
        subs.add(new ArrayList<>()); // Start with an empty subset

        for (int num : arr) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> subset : subs) {
                List<Integer> newSubset = new ArrayList<>(subset);
                newSubset.add(num);
                Collections.sort(newSubset); // Ensure subsets are always ordered
                newSubsets.add(newSubset);
            }
            subs.addAll(newSubsets);
        }

        // Print the unique subsets
        System.out.println(subs);
    }
}