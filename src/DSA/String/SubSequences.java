package DSA.String;

import java.util.ArrayList;
import java.util.List;

public class SubSequences {
    // Declare a global list
    static List<String> al = new ArrayList<>();

    // Creating a public static Arraylist such that
    // we can store values
    // If there is any question of returning
    // We can directly return too// public static
    // ArrayList<DSA.String> al = new ArrayList<DSA.String>();
    public static void main(String[] args)
    {
        String s = "abcd";
        findSubSequences(s, ""); // Calling a function
        System.out.println(al);
    }

    private static void findSubSequences(String s,
                                         String ans)
    {
        if (s.isEmpty()) {
            al.add(ans);
            return;
        }

        // We add adding 1st character in string
        findSubSequences(s.substring(1), ans + s.charAt(0));

        // Not adding first character of the string
        // because the concept of subsequence either
        // character will present or not
        findSubSequences(s.substring(1), ans);
    }
}
