public class BinarySearch {
    int Binary_Search(int[] arr, int tar) {
        int start = 0, end = arr.length - 1, mid;

        while (start <= end) {
            mid = start + (end - start) / 2; // To save from overflow condition we convert our mid formula into this formula
            if (tar > arr[mid]) {
                start = mid + 1;
            } else if (tar < arr[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        System.out.println("Name: Yogesh Rathod \nRoll No: C24092");
        int arr[] = { -1, 0, -3, 4, 5, 8, 10 };
        int n = arr.length;
        System.out.println("\nThe Array Elements are: ");
        for (int i = 0; i < n; i++)
            System.out.println(arr[i] + " ");
        int target = 4;
        BinarySearch b = new BinarySearch();
        System.out.println("\n" + target + " is present at Position " + b.Binary_Search(arr, target));
    }
}
