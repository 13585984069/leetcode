package leetcode.zuo.day4.AllSort;

/**
 * @author JJChen
 * @version 1.0
 */
public class MergeSort extends Sort{
    public static void sort(int[] arr){
        if(arr == null || arr.length < 2) return;
        mergeSort(arr, 0, arr.length - 1);

    }
    public static void mergeSort(int[] arr, int left, int right){
        if(left == right) return;
        int mid = left + (right - left) /2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, right, mid);
    }
    public static void merge(int[] arr , int left, int right , int mid){
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right){
            help[i++] = arr[p1] < arr[p2]? arr[p1++]:arr[p2++];
        }
        while(p1<=mid){
            help[i++] = arr[p1++];
        }
        while (p2<=right){
            help[i++] = arr[p2++];
        }
        for ( i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
    }
}
