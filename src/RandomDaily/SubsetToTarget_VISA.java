package RandomDaily;

import java.util.*;
import java.util.stream.Collectors;

//problem asked in VISA interview
public class SubsetToTarget_VISA {
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
        Map<String,Integer> map = list.stream().collect(Collectors.teeing(
                        Collectors.maxBy(Integer::compare),
                        Collectors.minBy(Integer::compare),
                        (max, min) -> {
                            Map<String,Integer> res = new HashMap<>();
                            res.put("max", max.orElse(null));
                            res.put("min", min.orElse(null));
                            return res;
                        }
                )
        );

        Integer max = map.get("max");
        Integer min = map.get("min");
        if (max != null && min != null) {
            return (max - min) <= threshold;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,9,6,8};
        System.out.println(getSolution(arr, 4));
    }
}
