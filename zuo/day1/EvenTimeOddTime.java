package leetcode.zuo.day1;

import java.util.Arrays;

/**
 * @author JJChen
 * @version 1.0
 */
public class EvenTimeOddTime {
    public static void main(String[] args) {
        int[] arr1 = { 3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1 };
        System.out.println(findOneOddTimeValue(arr1));
        int[] arr2 = { 4, 33, 4, 22, 22, 22, 4, 1, 1, 1, 33, 33, 1, 1, 1, 4, 22, 22 };
        System.out.println(Arrays.toString(findTwoOddTimeValues(arr2)));
    }
    // 一个数组中只有一个数出现了奇数次并找到它
    public static int findOneOddTimeValue(int[] arr){
        int res = 0;
        for (int num : arr){
            res ^= num;
        }
        return res;
    }
    // 一个数组中有2个数出现了奇数次，找到这两个数
    public static int[] findTwoOddTimeValues(int[] arr){
        int twoValues = 0;
        for (int num : arr){
            twoValues ^= num;
        }
        // 得到的twoValues是出现奇数次的两个数的异或, 因为两个数不同，那么这两个数必有一个bit是1
        // 找出最右边的1，将twoValues 与 （twoValues取反+1）相与就行
        int rightOne = twoValues & (~twoValues + 1);
//        int count = 0;
//        int temp = twoValues;
//        System.out.println(twoValues);
//        while (temp % 2 == 1){
//            temp= temp >> 1;
//            count++;
//        }
//        int rightOne = 1;
//        for (int i = 0; i < count - 1 ;i++){
//            rightOne = rightOne << 1;
//        }
        int oneValue = 0;
        for (int num : arr){
            if ((rightOne & num) == 0){
                oneValue ^= num;
            }
        }
        return new int[]{oneValue, twoValues ^ oneValue};

    }
}
