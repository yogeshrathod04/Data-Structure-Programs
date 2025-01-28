import java.util.Scanner;

public class LinearSearch {
    static int search(int a[], int n, int x) {
        for (int i = 0; i < n; i++) {
            if (a[i] == x)
                return i; // Return the index if element is found
        }
        return -1; // Return -1 if the element is not found
    }

    public static void main(String[] args) {
        System.out.println("Name: Yogesh Rathod \nRoll No: C24092");
        Scanner sc = new Scanner(System.in);
        int[] a = { 3, 4, 1, 7, 5 }; // Array to search
        int n = a.length; // Length of the array
        int x; // Element to search

        System.out.println("\nThe Array Elements Are:: ");
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " "); // Print the array elements
        System.out.println("\nEnter the element to search:");
        x = sc.nextInt(); // Input element to search
        int index = search(a, n, x); // Call the search method

        if (index == -1)
            System.out.println("Element is not present in the array");
        else
            System.out.println("Element found at position " + index);

        sc.close(); // Close the scanner
    }
}