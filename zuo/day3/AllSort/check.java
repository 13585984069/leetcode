package leetcode.zuo.day3.AllSort;

import java.util.Arrays;

/**
 * @author JJChen
 * @version 1.0
 */
public class check {
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        SelectionSort selectionSort = new SelectionSort();
        InsertSort insertSort = new InsertSort();
        System.out.println(check(bubbleSort, new RadixSort()));

    }

    public static int[] generator(int maxValue, int maxSize) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random());
        }
        return arr;
    }

    public static boolean check(Sort sort1, Sort sort2) {
        int maxValue = 100;
        int maxSize = 100;
        int testTime = 500000;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            sort1.setArr(generator(maxValue,maxSize));
            sort2.setArr(Arrays.copyOf(sort1.arr, sort1.arr.length));
//            System.out.println(Arrays.toString(sort2.arr));
            sort1.sort();
            sort2.sort();
//            System.out.println(Arrays.toString(sort2.arr));
            succeed = Arrays.equals(sort1.arr, sort2.arr);
            if(!succeed){
                break;
            }
        }
        return succeed;
    }
}
