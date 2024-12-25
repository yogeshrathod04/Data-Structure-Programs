import java.util.Arrays;

public class RadixSort {

    // Function to get the maximum value in the array
    static int getMax(int arr[], int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > mx) {
                mx = arr[i];
            }
        }
        return mx;
    }

    // Function to perform counting sort based on the digit represented by exp
    // (10^i)
    static void countSort(int arr[], int n, int exp) {
        int output[] = new int[n]; // Output array to store sorted values
        int count[] = new int[10]; // Array to store count of occurrences of digits (0 to 9)

        // Initialize count array with zeros
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // Change count[i] to contain actual position of this digit in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array using the count[] positions
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now contains sorted numbers
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    // Main function to implement radix sort
    static void radixsort(int arr[], int n) {
        // Get the maximum number to know number of digits
        int m = getMax(arr, n);

        // Do counting sort for every digit. Note that exp is 10^i where i is current
        // digit number
        for (int exp = 1; m / exp > 0; exp *= 10) {
            countSort(arr, n, exp);
        }
    }

    // Function to print the array
    static void print(int arr[], int n) {
        System.out.println("\nArray Elements After Radix Sort:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Driver code
    public static void main(String[] args) {
        System.out.println("Name: Yogesh Rathod \n");
        int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
        int n = arr.length;

        // Print array before sorting
        System.out.println("\nArray Elements Before Radix Sort:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // Perform Radix Sort
        radixsort(arr, n);

        // Print array after sorting
        print(arr, n);
    }
}
