import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class Queue {
    private int front, rear, capacity, count;
    private int[] queue;

    // Constructor to initialize the queue
    Queue(int size) {
        front = rear = -1;
        capacity = size;
        count = 0;
        queue = new int[capacity];
    }

    // Method to insert an element into the queue
    void queueEnqueue(int item) {
        if (count == capacity) { // check if the queue is full
            System.out.println("\nQueue is full");
            return;
        }
        if (rear == capacity - 1) {
            rear = -1; // Wrap around if rear goes beyond capacity
        }
        queue[++rear] = item; // Insert element at the rear
        if (front == -1) { // Queue was empty, so we set front to 0
            front = 0;
        }
        count++;
        System.out.println("Count is: " + count);
    }

    // Method to remove an element from the queue
    void queueDequeue() {
        if (count == 0) { // Check if the queue is empty
            System.out.println("\nQueue is empty");
            return;
        }
        int dequeuedElement = queue[front];
        queue[front] = 0; // Clear the slot
        front = (front + 1) % capacity; // Move front pointer to the next element (circular queue)
        count--;
        System.out.println("Dequeued element: " + dequeuedElement);
        System.out.println("Count is: " + count);
    }

    // Method to display all elements in the queue
    void queueDisplay() {
        if (count == 0) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = 0; i < capacity; i++) {
            if (queue[i] != 0) { // Only print non-zero elements
                System.out.print(queue[i] + " ");
            }
        }
        System.out.println("\nCount is: " + count);
    }

    // Method to display the front element of the queue
    void queueFront() {
        if (count == 0) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("\nFront Element of the queue: " + queue[front]);
    }
}

public class QueueArray {
    public static void main(String[] args) throws IOException {
        System.out.println("Name: Yogesh Rathod \nRoll No: C24092\n");

        // Create a queue of capacity 4
        Queue q = new Queue(4);

        int choice;
        Scanner scanner = new Scanner(System.in);
        BufferedReader bfn = new BufferedReader(new InputStreamReader(System.in));

        do {
            System.out.println("Menu:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Queue Display");
            System.out.println("4. Queue Front");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Queue Element:");
                    int item = Integer.parseInt(bfn.readLine());
                    q.queueEnqueue(item); // Inserting elements in the queue
                    break;
                case 2:
                    System.out.println("Dequeued Element:");
                    q.queueDequeue(); // Dequeue operation
                    break;
                case 3:
                    System.out.println("Queue Elements are:");
                    q.queueDisplay(); // Display queue elements
                    break;
                case 4:
                    q.queueFront(); // Display front element
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return; // Exit the program
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
