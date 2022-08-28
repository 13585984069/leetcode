package leetcode.zuo.day4.AllSort;

/**
 * @author JJChen
 * @version 1.0
 */
public class bubbleSort extends Sort{
    public static void sort(int[] arr) {
        if(arr == null || arr.length < 2) return;
        for (int i = 0; i < arr.length -1; i++) {
            int count = 0;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j+1]){
                    swap(arr, j+1, j);
                    count++;
                }
            }
            if(count == 0){
                break;
            }
        }
    }

}
