package leetcode.zuo.day5.checkPrevious.Sort;

/**
 * @author JJChen
 * @version 1.0
 */
public class SortUtility {
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
