package RandomDaily;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HighestOccurringCharacter {

    public static char highestOccurringChar(String str) {
        //Your code goes here
        return str.chars().mapToObj(n -> (char)n)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((e1, e2) -> (int)(e2.getValue() - e1.getValue()))
                .map(e -> e.getKey())
                .findFirst()
                .orElse('-');
    }

    public static void main(String[] args) {
        System.out.println(highestOccurringChar("abcdeapapqarr"));
    }

}