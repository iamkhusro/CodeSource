package DSA.Stack;
import java.util.EmptyStackException;

public class GenericStack<T> {
    private T[] stackArray; // Array to store stack elements
    private int top;        // Index of the top element
    private int capacity;   // Maximum capacity of the stack

    // Constructor
    @SuppressWarnings("unchecked")
    public GenericStack(int capacity) {
        this.capacity = capacity;
        this.stackArray = (T[]) new Object[capacity]; // Create a generic array
        this.top = -1; // Stack is initially empty
    }

    // Push an element onto the stack
    public void push(T element) {
        if (top == capacity - 1) {
            throw new StackOverflowError("Stack is full.");
        }
        stackArray[++top] = element;
    }

    // Pop an element from the stack
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T element = stackArray[top];
        stackArray[top--] = null; // Clear the reference for garbage collection
        return element;
    }

    // Peek at the top element of the stack
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stackArray[top];
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Get the size of the stack
    public int getSize() {
        return top + 1;
    }

    // Main method to demonstrate the stack
    public static void main(String[] args) {
        GenericStack<Integer> intStack = new GenericStack<>(5);
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);

        System.out.println("Top element: " + intStack.peek()); // Output: 30
        System.out.println("Stack size: " + intStack.getSize()); // Output: 3

        System.out.println("Popped: " + intStack.pop()); // Output: 30
        System.out.println("Top element after pop: " + intStack.peek()); // Output: 20

        GenericStack<String> stringStack = new GenericStack<>(3);
        stringStack.push("Hello");
        stringStack.push("World");

        System.out.println("Top element in string stack: " + stringStack.peek()); // Output: World
    }
}