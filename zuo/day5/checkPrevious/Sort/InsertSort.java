package leetcode.zuo.day5.checkPrevious.Sort;

/**
 * @author JJChen
 * @version 1.0
 */
public class InsertSort {
    public static void sort(int[] arr){
        for (int i = 0; i < arr.length - 1 ; i++) {
            for (int j = i+1; j > 0; j--) {
                if(arr[j] < arr[j - 1]){
                    SortUtility.swap(arr, j, j- 1);
                }
            }
        }
    }
}
