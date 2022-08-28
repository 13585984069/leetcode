package leetcode.zuo.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author JJChen
 * @version 1.0
 */
public class NiXuDui {
    public static void main(String[] args) {
        int[] arr = {4,3,2,1,5,6};
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        niXuDui(arr, arrayLists);
        System.out.println(Arrays.toString(arr));
        System.out.println(arrayLists);
    }

    public static void niXuDui(int[] arr,ArrayList<ArrayList<Integer>> arrayLists){
        if(arr == null || arr.length < 2) return ;
        niXuDui(arr, 0, arr.length-1, arrayLists);
    }
    public static void niXuDui(int[] arr, int left, int right, ArrayList<ArrayList<Integer>> arrayLists){
        if(left == right) return;
        int mid = left +((right - left) >> 1);
        niXuDui(arr, left,mid, arrayLists);
        niXuDui(arr,mid+1, right,arrayLists);
        merge(arr, left, right, mid, arrayLists);
    }
    public static void merge(int[] arr, int left, int right, int mid,ArrayList<ArrayList<Integer>> arrayLists){
        int[] help = new int[right-left+1];
        int i=0;
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid && p2<= right){
            if(arr[p1] > arr[p2]){
                for (int j = p1; j <= mid; j++) {
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(arr[j]);
                    integers.add(arr[p2]);
                    arrayLists.add(integers);
                }
            }
            help[i++] = arr[p1] < arr[p2]? arr[p1++]:arr[p2++];
        }
        while (p1<=mid){
            help[i++] = arr[p1++];
        }
        while (p2<=right){
            help[i++] = arr[p2++];
        }
        for ( i = 0; i < help.length; i++) {
            arr[left+i] = help[i];
        }

    }
}
