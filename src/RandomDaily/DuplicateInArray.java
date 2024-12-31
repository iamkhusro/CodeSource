package RandomDaily;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateInArray {
    public static int findDuplicate(ArrayList<Integer> arr) {
        //    Write your code here.
        Set<Integer> set = new HashSet<>();
        return arr.stream().filter(n -> !set.add(n)).findFirst().orElse(-1);
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new ArrayList<>(List.of(2,6,4,1,2))));
    }
}
