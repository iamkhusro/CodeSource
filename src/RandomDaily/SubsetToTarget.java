package RandomDaily;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//problem asked in VISA interview
public class SubsetToTarget {
    private static int getSolution(int[] arr, int threshold) {
        List<Integer> maximum = new ArrayList<>();
        int length = arr.length;

        for (int i = 0; i < length; i++) {
            List<Integer> newList = new ArrayList<>();
            for (int j = i; j < length; j++) {
                newList.add(arr[j]);
                if (newList.size() > maximum.size() && isSatisfied(newList, threshold)) {
                    maximum = new ArrayList<>(newList);
                }
            }
        }
        System.out.println(maximum);
        return maximum.size();
    }

    private static boolean isSatisfied(List<Integer> list, int threshold) {
        Integer max = list.stream().max(Comparator.comparingInt(Integer::intValue)).orElse(null);
        Integer min = list.stream().min(Comparator.comparingInt(Integer::intValue)).orElse(null);

        if (max != null && min != null) {
//            System.out.println(list);
            return (max - min) <= threshold;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,9,6,8};
        System.out.println(getSolution(arr, 4));
    }
}
