package DSA.Queue;

import java.util.ArrayDeque;

public class DEQue
{
    // Initialize your data structure.
    public java.util.Deque<Integer> deque;
    public int size;
    public DEQue(int n)
    {
        // Write your code here.
        deque = new ArrayDeque<>();
        size = n;
    }

    // Pushes 'X' in the front of the deque. Returns true if it gets pushed into the deque, and false otherwise.
    public boolean pushFront(int x)
    {
        // Write your code here.
        try {
            deque.addFirst(x);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    // Pushes 'X' in the back of the deque. Returns true if it gets pushed into the deque, and false otherwise.
    public boolean pushRear(int x)
    {
        // Write your code here.
        try {
            deque.addLast(x);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    // Pops an element from the front of the deque. Returns -1 if the deque is empty, otherwise returns the popped element.
    public int popFront()
    {
        // Write your code here.
        return deque.removeFirst();
    }

    // Pops an element from the back of the deque. Returns -1 if the deque is empty, otherwise returns the popped element.
    public int popRear()
    {
        // Write your code here.
        return deque.removeLast();
    }

    // Returns the first element of the deque. If the deque is empty, it returns -1.
    public int getFront()
    {
        // Write your code here.
        return deque.getFirst();
    }

    // Returns the last element of the deque. If the deque is empty, it returns -1.
    public int getRear()
    {
        // Write your code here.
        return deque.getLast();
    }

    // Returns true if the deque is empty. Otherwise returns false.
    public boolean isEmpty()
    {
        // Write your code here.
        return deque.isEmpty();
    }

    // Returns true if the deque is full. Otherwise returns false.
    public boolean isFull()
    {
        // Write your code here.
        return deque.size() == size;
    }
}