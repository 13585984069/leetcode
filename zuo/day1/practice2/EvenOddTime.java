package leetcode.zuo.day1.practice2;

import java.util.Arrays;

/**
 * @author JJChen
 * @version 1.0
 */
public class EvenOddTime {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,2,2,2,3,3,3,3};
        System.out.println(singeOdd(arr));
        int[] arr2 = {1,1,1,1,1,1,2,2,2,3,3,3,3,4,4,4};
        System.out.println(Arrays.toString(twoOdd(arr2)));
    }
    public static int singeOdd(int[] arr){
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res ^= arr[i];
        }
        return res;
    }
    public static int[] twoOdd(int[] arr){
        int twoOdd = singeOdd(arr);
        int leftOneBit = twoOdd & (~twoOdd + 1);
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if((arr[i] & leftOneBit) == 0){
                res ^= arr[i];
            }
        }
        return new int[]{res, res ^ twoOdd};

    }
}
