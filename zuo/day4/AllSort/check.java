package leetcode.zuo.day4.AllSort;

import java.util.Arrays;

/**
 * @author JJChen
 * @version 1.0
 */
public class check {
    public static void main(String[] args) {
        System.out.println(comparator());
    }


    public static boolean comparator() {
        int maxvalue = 100;
        int maxSize = 100;
        int testTime = 500000;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generator(maxSize, maxvalue);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            InsertSort.sort(arr1);
//            quickSort.sort(arr2);
            heapSort.sort(arr2);
//            RadixSort.sort(arr2);
//            System.out.println(Arrays.toString(arr1));
//            System.out.println(Arrays.toString(arr2));
            if(!Arrays.equals(arr1,arr2)){
                succeed = false;
                break;
            }
        }
        return succeed;
    }

    public static int[] generator(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random());
        }
        return arr;
    }
}
