package DSA.LinkedList;

public class FindAndRemoveLoopSLL {

    public static Node findLoopNode(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head; //return true here if we only need to find loop presence

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }

        }

        return null;
    }

    public static Node removeLoop(Node head) {
        // Write your code here.
        Node slow = head;
        Node fast = head;
        Node startOfLoop = null;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                startOfLoop = slow;
                break;
            }
        }

        if (startOfLoop != null) {
            Node temp = startOfLoop;
            while (temp.next != startOfLoop) {
                temp = temp.next;
            }

            temp.next = null;

        }

        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(40);
        head.next.next.next = new Node(50);
        head.next.next.next.next = head.next.next;

        System.out.println(findLoopNode(head).data);
        removeLoop(head);
        System.out.println(findLoopNode(head));
    }
}
