package leetcode.zuo.day5.checkPrevious.Sort;

/**
 * @author JJChen
 * @version 1.0
 */
public class MergeSort {
    public  static  void sort(int[] arr){
        if(arr == null || arr.length<2) return ;
        process(arr, 0, arr.length - 1);
    }

    public  static  void process(int[] arr, int left, int right){
        if(left == right) return;
        int mid = left + (right - left) /2;
        process(arr, left, mid);
        process(arr, mid + 1, right);
        merge(arr, left, right, mid);
    }

    public  static  void merge(int[] arr, int left, int right, int mid){
        int[] help = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int i = 0;
        while(p1 <= mid && p2<= right){
            help[i++] = arr[p1] <= arr[p2]? arr[p1++]:arr[p2++];
        }
        while(p1 <= mid){
            help[i++] = arr[p1++];
        }
        while (p2<=right){
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[left + j] = help[j];
        }
    }
}
