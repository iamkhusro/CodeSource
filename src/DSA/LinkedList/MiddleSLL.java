package DSA.LinkedList;



public class MiddleSLL {

    public static Node findMiddle(Node head)
    {
        // Write your code here.
        int length = 0;
        Node tempHead = head;
        while (tempHead != null) {
            ++length;
            tempHead = tempHead.next;
        }

        int mid = (length/2)+1;

        tempHead = head;
        while (mid > 1) {
            tempHead = tempHead.next;
            mid--;
        }

        return tempHead;
    }

    public static Node findMiddleFast(Node head)
    {
        // Write your code here.
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    //main
}
