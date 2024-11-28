public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = {29, 9, 23, 22, 7, 6, 78, 1};
        for(int i=0; i<arr.length; i++){
            int current = arr[i];
            int j = i-1;
            while (j >=0 && current < arr[j]) {
                arr[j+1] = arr[j];    
                j--;
            } 
            arr[j+1] = current;
        }
        for(int i = 0; i<arr.length; i++){
            
        }
    }
}
