package RandomDaily;

//Given an array KEYS consisting of N non-negative integers.
// For each element in a given array, you need to determine the index by which this element is mapped in the hash table if the ‘Linear Probing’ technique is used to handle collision.
//The hash function you need to consider is H(X) = X mod N i.e. index = X mod N.
//Return an array ‘HASH_TABLE’ of size N in which:
//HASH_TABLE[ i ] = KEYS[ j ] where, i = KEYS[ j ] mod N.
//In short, an element at index ‘i’ is the element from the given array KEYS which is mapped to that index.

import java.util.List;

public class Hashing {

    public static int[] linearProbing(List<Integer> keys) {
        // Write your code here.
        int n = keys.size();
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            res[i] = -1;
        }

        for (int key : keys) {
            int index = key % n;
            if (res[index] == -1) {
                res[index] = key;
            }
            else {
                res[nextIndex(index, res)] = key;
            }
        }
        return res;

    }

    private static int nextIndex(int index, int[] arr) {
        while (arr[index] != -1) {
            ++index;
            if (index == arr.length) {
                index = 0;
            }
        }
        return index;
    }

    //main

}