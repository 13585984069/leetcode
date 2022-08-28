package leetcode.zuo.day5.checkPrevious.Sort;

/**
 * @author JJChen
 * @version 1.0
 */
public class BubbleSort {
    public static void sort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int count = 0;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j+1]){
                    SortUtility.swap(arr,j, j+1);
                    count++;
                }
            }
            if(count == 0){
                break;
            }
        }
    }
}
