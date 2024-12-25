public class QuickSort {
    public static int partition(int arr[], int low, int high) {
        // This function will return the index of pivot
        int pivot = arr[high];
        int temp;
        int i = low - 1;

        // Rearranging elements so that elements smaller than pivot
        // are on the left and larger are on the right
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place pivot at the correct position (i + 1)
        temp = arr[i + 1];
        arr[i + 1] = pivot;
        arr[high] = temp;

        return i + 1; // Return the pivot index
    }

    public static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pidx = partition(arr, low, high);
            // Recursively apply QuickSort to the left and right partitions
            quickSort(arr, low, pidx - 1);
            quickSort(arr, pidx + 1, high);
        }
    }

    public static void main(String args[]) {
        System.out.println("Name: Yogesh Rathod \n");

        // Example array
        int[] arr = { 6, 4, 5, 3, 1, 2 };
        int n = arr.length;

        // Print initial array
        System.out.println("Array Elements Are:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // Call the quickSort function
        quickSort(arr, 0, n - 1);

        // Print sorted array
        System.out.println("Array Elements After Quick Sort Are:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
