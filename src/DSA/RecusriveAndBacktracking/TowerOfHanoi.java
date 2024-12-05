package DSA.RecusriveAndBacktracking;

import java.util.ArrayList;

public class TowerOfHanoi
{
    private static ArrayList<ArrayList<Integer>> resList;
    public static ArrayList < ArrayList<Integer>> towerOfHanoi(int n)
    {
        //    Write your code here.
        resList = new ArrayList<>();
        towerOfHanoiSolution(n, 1, 2, 3);

        return resList;

    }

    private static void towerOfHanoiSolution(int n, int fromRod, int toRod, int auxRod) {
        if (n == 0) {
            return;
        }

        towerOfHanoiSolution(n-1, fromRod, auxRod, toRod);
        ArrayList<Integer> move = new ArrayList<>();
        // System.out.println("Move disk " + n + " from rod " + fromRod + " to rod " + toRod);
        move.add(fromRod);
        move.add(toRod);
        resList.add(move);
        towerOfHanoiSolution(n-1, auxRod, toRod, fromRod);
    }

    public static void main(String[] args) {
        System.out.println(towerOfHanoi(3));
    }


}