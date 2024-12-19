package RandomDaily;

import java.util.ArrayList;
import java.util.List;


//Create a data structure and write the methods
public class Trie {
    private List<String> ds;
    public Trie() {
        // Write your code here.
        ds = new ArrayList<>();
    }

    public void insert(String word) {
        // Write your code here.
        ds.add(word);
    }

    public int countWordsEqualTo(String word) {
        // Write your code here.
        return (int)ds.stream().filter(s -> s.equals(word)).count();
    }

    public int countWordsStartingWith(String word) {
        // Write your code here.
        return (int)ds.stream().filter(s -> s.startsWith(word)).count();
    }

    public void erase(String word) {
        // Write your code here.
        ds.remove(word);
    }

}