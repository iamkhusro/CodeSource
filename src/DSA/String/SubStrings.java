package DSA.String;

import java.util.ArrayList;
import java.util.List;

public class SubStrings {
    private static String str = "happy";

    public static void main(String[] args) {
        List<String> subList = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            String sub = "";
            for (int j = i; j < str.length(); j++) {
                sub += str.charAt(j);
                subList.add(sub);
            }
        }

        System.out.println(subList);
        System.out.println(subList.size());
    }
}
