import java.util.Scanner;

class Stack {
    private int top, capacity, count;
    private int[] stack;

    // Constructor to initialize the stack
    Stack(int size) {
        top = -1;
        capacity = size;
        count = 0;
        stack = new int[capacity];
    }

    // Insert an element into the stack
    void push(int item) {
        // Check if the stack is full
        if (count == capacity) {
            System.out.println("\nStack is full");
            return;
        }

        // Insert element at the top of the stack
        top++;
        stack[top] = item;
        count++;
        System.out.println("Element " + item + " pushed to stack.");
        System.out.println("Count is: " + count);
    }

    // Remove an element from the stack
    void pop() {
        // Check if the stack is empty
        if (top == -1) {
            System.out.println("\nStack is empty");
            return;
        }

        // Remove the element from the top
        int removedElement = stack[top];
        stack[top] = 0; // Optional: Clear the spot
        top--;
        count--;
        System.out.println("Popped Element: " + removedElement);
        System.out.println("Count is: " + count);
    }

    // Display elements in the stack
    void stackDisplay() {
        if (top == -1) {
            System.out.println("Stack is Empty");
            return;
        }

        System.out.print("Stack elements: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println("\nCount is: " + count);
    }
}

public class StackArray {
    public static void main(String[] args) {
        System.out.println("Name: Yogesh Rathod \nRoll No: C24092\n");

        // Create a stack with capacity 4
        Stack s = new Stack(4);
        int choice;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Menu:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Stack Display");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Stack Element:");
                    int item = scanner.nextInt(); // Using scanner to read the integer
                    s.push(item); // Pushing the entered element
                    break;
                case 2:
                    System.out.println("Popped Element is:");
                    s.pop();
                    break;
                case 3:
                    System.out.println("Stack Elements are:");
                    s.stackDisplay();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        } while (choice != 4);

        scanner.close();
    }
}