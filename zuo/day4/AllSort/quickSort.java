package leetcode.zuo.day4.AllSort;

/**
 * @author JJChen
 * @version 1.0
 */
public class quickSort extends Sort{
    public static void sort(int[] arr){
        if(arr == null || arr.length < 2) return;
        quicksort02(arr, 0, arr.length -1);
    }

    public static void  quicksort01(int[] arr, int start, int end){
        if( start >= end) return;
        int left = start;
        int right = end;
        int num = arr[left];
        while(left < right){
            while(arr[right] >= num && left < right){
                right--;
            }
            arr[left] = arr[right];
            while (arr[left] < num && left < right){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = num;
        quicksort01(arr, start, left - 1);
        quicksort01(arr, left + 1, end);
    }

    public static void quicksort02(int[] arr, int start, int end){
        if(start >=end) return;
        int left = start;
        int right = end;
        int randomIndex =  left + (int)((right - left + 1) * Math.random());
        swap(arr, randomIndex, right);
        int less = left - 1;
        int more = right;
        while (left < more){
            if(arr[left] > arr[right]){
                swap(arr, left, --more);
            }else if(arr[left] < arr[right]){
                swap(arr, ++less, left++);
            }else {
                left++;
            }
        }
        swap(arr, right, more);
        quicksort02(arr, start, less);
        quicksort02(arr, more + 1, end);
    }
}
