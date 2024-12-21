public class ShellSort {
    public static void main(String args[]) {
        int i, j, n, gap, temp;
        int arr[] = { 23, 29, 15, 19, 31, 7, 9, 5, 2 };
        n = arr.length;
        System.out.println("Name: Yogesh Rathod \n");
        System.out.println("Array Elements are:");
        for (i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        for (gap = n / 2; gap >= 1; gap /= 2) {
            for (j = gap; j < n; j++) {
                for (i = j - gap; i >= 0; i -= gap) {
                    if (arr[i + gap] > arr[i]) {
                        break;
                    } else {
                        temp = arr[i + gap];
                        arr[i + gap] = arr[i];
                        arr[i] = temp;
                    }
                }
            }
        }
        System.out.println("\nArray Elements after Shell Sort are:");
        for (i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
