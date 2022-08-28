package leetcode.zuo.day4.AllSort;

/**
 * @author JJChen
 * @version 1.0
 */
public class InsertSort extends Sort{
    public static void sort(int[] arr){
        if(arr == null || arr.length < 2) return;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i+1; j >0 ; j--) {
                if(arr[j] < arr[j -1]){
                    swap(arr, j, j-1);
                }
            }
        }
    }
}
