package leetcode.zuo.day4.AllSort;

/**
 * @author JJChen
 * @version 1.0
 */
public class SelectionSort extends Sort{
    public static void sort(int[] arr){
        if(arr == null || arr.length < 2) return;
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i +1; j < arr.length; j++) {
                if(arr[min] > arr[j]){
                    min = j;
                }
            }
            if(min != i){
                swap(arr, i, min);
            }
        }
    }
}
