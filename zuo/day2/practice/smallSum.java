package leetcode.zuo.day2.practice;

import java.util.Arrays;

/**
 * @author JJChen
 * @version 1.0
 */
public class smallSum {
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,5};
        System.out.println(smallSum(arr));
        System.out.println(Arrays.toString(arr));
    }
    public static int smallSum(int[] arr){
        if(arr == null || arr.length < 2)return 0;
        return mergeSort(arr, 0, arr.length -1 );
    }
    public static int mergeSort(int[] arr,int left, int right){
        if (left == right) return 0;
        int mid = left + ((right - left ) >>1);
        return mergeSort(arr, left, mid) + mergeSort(arr, mid+1, right) + merge(arr, left, right, mid);
    }

    public static  int merge(int[] arr, int left, int right, int mid){
        int[] help = new int[right - left + 1];
        int i = 0;
        int sum = 0;
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right){
            sum += arr[p1] < arr[p2]? arr[p1] *(right-p2 + 1):0;
            help[i++] = arr[p1] < arr[p2]? arr[p1++]:arr[p2++];
        }
        while (p1<=mid){
            help[i++] = arr[p1++];
        }
        while(p2<=right){
            help[i++] = arr[p2++];
        }
        for ( i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
        return  sum;
    }
}
