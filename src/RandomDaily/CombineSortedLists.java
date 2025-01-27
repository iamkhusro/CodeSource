package RandomDaily;

import java.util.ArrayList;
import java.util.List;

public class CombineSortedLists {
    public static void main(String[] args) {
        List<Integer> list1 = List.of(2,4,6,8);

        List<Integer> list2 = List.of(1,2,3,5,7,9,11,13);

        List<Integer> resList = new ArrayList<>();

        int l1 = list1.size() - 1;
        int l2 = list2.size() - 1;


        while (l1 >= 0 && l2 >= 0) {
            if (list1.get(l1) > list2.get(l2)) {
                resList.add(list1.get(l1));
                l1--;
            }
            else {
                resList.add(list2.get(l2));
                l2--;
            }
        }

        while (l1 >= 0) {
            resList.add(list1.get(l1));
            l1--;
        }

        while (l2 >= 0) {
            resList.add(list2.get(l2));
            l2--;
        }

        System.out.println(resList);
    }
}