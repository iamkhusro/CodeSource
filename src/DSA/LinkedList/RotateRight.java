package DSA.LinkedList;

//You are given a linked list having ‘n’ nodes and an integer ‘k’.
//You have to rotate the linked list to the right by ‘k’ positions .
//Example :
//Input: linked list = [1 2 3 4] , k = 2
//Output: 3 4 1 2

public class RotateRight {
    public static Node rotate(Node head, int k) {
        // Write your code here.
        if (head == null || head.next == null || k == 0)
            return head;
        Node temp = head;
        int size = 1;

        while (temp.next != null) {
            ++size;
            temp = temp.next;
        }

        temp.next = head;

        k = k % size;
        int end = size - k;

        while (end-- != 0) {
            temp = temp.next;
        }

        head = temp.next;
        temp.next = null;

        return head;
    }

    //main

}
