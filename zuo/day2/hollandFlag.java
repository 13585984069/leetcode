package leetcode.zuo.day2;

import java.util.Arrays;

/**
 * @author JJChen
 * @version 1.0
 */
public class hollandFlag {
    public static void main(String[] args) {
        int[] arr = {10,3,5,7,2,3,9,11,6,4};
        putValueSep(arr,4);
        System.out.println(Arrays.toString(arr));
    }

    public static void putValueSep(int[] arr, int num){
        int temp = arr[0];
        int left = 0;
        int right = arr.length  -1 ;
        while(left < right){
            while(num < arr[right] && left < right){
                right--;
            }
            arr[left] = arr[right];
            while(num > arr[left] && left < right){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = temp;
    }

}
