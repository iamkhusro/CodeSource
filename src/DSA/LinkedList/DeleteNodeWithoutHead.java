package DSA.LinkedList;
/*
Problem statement
You are given a Singly Linked List of integers and a reference to the node to be deleted.
Every node of the Linked List has a unique value written on it.
Your task is to delete that node from the linked list.

Note:
• The reference to the head of the linked list is not given.
• The node to be deleted is not a tail node.
• The value of each node in the Linked List is unique.
• It is guaranteed that the node to be deleted is present in the linked list.
*/
public class DeleteNodeWithoutHead {

    static class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;
        LinkedListNode(T data)
        {
            this.data = data;
            this.next = null;
        }
    }

    public static void deleteNode(LinkedListNode<Integer> node) {
        // Write your code here.
        node.data = node.next.data;
        node.next = node.next.next;
    }
}