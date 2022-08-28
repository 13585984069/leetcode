package leetcode.zuo.day1.practice1;

import java.util.Arrays;

/**
 * @author JJChen
 * @version 1.0
 */
public class EvenTimeOddTime {
    public static void main(String[] args) {
        int[] arr1 = { 3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1 };
        System.out.println(FindOddValue(arr1));
        int[] arr2 = { 4, 33, 4, 22, 22, 22, 4, 1, 1, 1, 33, 33, 1, 1, 1, 4, 22, 22 };
        System.out.println(Arrays.toString(FindOddValues(arr2)));
    }

    public static int FindOddValue(int[] arr){
        int res = 0;
        for(int num :arr){
            res ^= num;
        }
        return res;
    }
    public static int[] FindOddValues(int[] arr){
        int twoValue = FindOddValue(arr);
        int oneRight = twoValue & (~twoValue + 1);
        int oneValue = 0;
        for(int num : arr){
            if ((oneRight & num) == 0){
                oneValue ^= num;
            }
        }
        return new int[]{oneValue, twoValue^oneValue};
    }
}
