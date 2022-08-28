package leetcode.zuo.day1;

import java.util.Arrays;

/**
 * @author JJChen
 * @version 1.0
 */
public class duiShuQi {
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            ArraySort.bubbleSort(arr1);
            comparator(arr2);
            if (!Arrays.equals(arr1,arr2)){
                succeed = false;
                break;
            }
        }
        System.out.println(succeed);
    }
    public static void comparator(int[] arr){
        Arrays.sort(arr);
    }

    public static int[] generateRandomArray(int maxSize, int maxValue){
        int[] arr = new int[(int)((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)((maxValue + 1) * Math.random() - (maxValue + 1) * Math.random());
        }
        return arr;
    }

}
