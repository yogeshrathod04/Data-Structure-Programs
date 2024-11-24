import java.util.*;
/**
 * BubbleSort
 */
public class BubbleSort {

    public static void main(String[] args) {
        int arr[] = {10, 2, 9, 25, 1, 22, 7};
        for(int i = 0; i<arr.length; i++){
            for(int j= 0; j<arr.length-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}