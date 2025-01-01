package RandomDaily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Problem statement
Ninja developed a love for arrays and strings so this time his teacher gave him an array of strings, ‘A’ of size ‘N’.
Each element of this array is a string. The teacher taught Ninja about prefixes in the past, so he wants to test his knowledge.

Node: A string is called a complete string if every prefix of this string is also present in the array ‘A’.
Ninja is challenged to find the longest complete string in the array ‘A’.
If there are multiple strings with the same length, return the lexicographically smallest one and if no string exists, return "None".
*/

class CompleteString {

    public static String completeString(int n, String[] a) {
        // Write your code here.
        List<String> satisfies = new ArrayList<>();

        List<String> arr = Arrays.stream(a).toList();

        for (int i = 0; i < arr.size(); i++) {
            List<String> prefixes = new ArrayList<>();
            String s = arr.get(i);

            String prefix = "";
            for (int k = 0; k < s.length(); k++) {
                prefix += s.charAt(k);
                prefixes.add(prefix);
            }

            boolean check = true;
            for (String p : prefixes) {
                if (!arr.contains(p)) {
                    check = false;
                    break;
                }
            }
            if (check) {
                satisfies.add(s);
            }
        }

        String res = "";
        for (String st : satisfies) {
            if (st.length() > res.length()) {
                res = st;
            }
            else if (st.length() == res.length()) {
                res = st.compareToIgnoreCase(res) < 0 ? st : res;
            }
        }

        return res.isEmpty() ? "None" : res;

    }

    //main
}