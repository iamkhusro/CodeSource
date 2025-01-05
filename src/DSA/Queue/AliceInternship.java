package DSA.Queue;

//Alice has completed various courses on coding ninja, and now she is confident for her coding interviews.
// She plans to do internships in the summer and has prepared a list of ‘N’ companies.
// For each i-th company, the minimum experience needed is ‘minExp[i]’ days, and after completing the internship, she gains ‘expGained[i]’ days of experience.
// She is already having ‘D’ days of experience. As she is available only in summers, she can complete at most ‘K’ internships.
// Your task is to tell her the maximum experience(in days) she can gain after completing at most ‘K’ internships.
//Note :
//She cannot do more than one internship in the same company.


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class AliceInternship {

    public static int internshipExp(int d, int k, int n, ArrayList<Integer> minExp, ArrayList<Integer> expGained) {
        // this was my solution, the code filters the internships based on minExp and selects the one with the highest expGained value
        // however, this greedy approach might not always lead to the optimal solution
        // because it does not account for the long-term benefits of selecting internships with slightly lower expGained but better potential in subsequent iterations

        // Write your code here
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < minExp.size(); i++) {
            list.add(List.of(minExp.get(i), expGained.get(i)));
        }

        while (k != 0 && n != 0) {
            int exp = d;
            boolean internshipFound = false;
            List<Integer> requiredList = list.stream()
                    .filter(item -> item.get(0) <= exp)
                    .sorted((item1, item2) -> item2.get(1) - item1.get(1))
                    .findFirst().orElse(null);

            if (requiredList != null) {
                internshipFound = true;
                d += requiredList.get(1);
                list.remove(requiredList);
                k--;
                n--;
            }
            if (!internshipFound)
                break;
        }

        return d;
    }

    // to make it optimal, use dynamic programming (DP) or priority queue-based approach to maximize expGained while adhering to the constraints.
    public static int internshipExpOptimised(int d, int k, int n, ArrayList<Integer> minExp, ArrayList<Integer> expGained) {
        // Create a list of internships as pairs of (minExp, expGained)
        List<int[]> internships = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            internships.add(new int[]{minExp.get(i), expGained.get(i)});
        }

        // Sort internships by minExp (ascending) and expGained (descending for ties)
        internships.sort((a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        // Priority queue to maximize expGained for eligible internships
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0, totalExperience = d;

        while (k > 0) {
            // Add all eligible internships to the maxHeap
            while (i < n && internships.get(i)[0] <= totalExperience) {
                maxHeap.offer(internships.get(i)[1]);
                i++;
            }

            // If no eligible internship is found, break
            if (maxHeap.isEmpty()) break;

            // Take the internship with the highest expGained
            totalExperience += maxHeap.poll();
            k--;
        }

        return totalExperience;
    }

    //main
}
