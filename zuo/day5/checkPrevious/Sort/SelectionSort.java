package leetcode.zuo.day5.checkPrevious.Sort;

/**
 * @author JJChen
 * @version 1.0
 */
public class SelectionSort {
    public static void sort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[min] >= arr[j]){
                    min = j;
                }
            }
            if(min != i){
                SortUtility.swap(arr, i, min);
            }
        }
    }
}
