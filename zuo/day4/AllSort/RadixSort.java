package leetcode.zuo.day4.AllSort;

import java.util.*;

/**
 * @author JJChen
 * @version 1.0
 */
public class RadixSort extends Sort {
    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        int maxDigit = getMaxDigit(arr);
        int[] help = new int[arr.length];
        int d;
        for (int i = 1; i <= maxDigit; i++) {
            int[] barrel = new int[10];
            for (int j = 0; j < arr.length; j++) {
                d = getDigit(arr[j], i);
                barrel[d]++;
            }
            for (int j = 1; j < barrel.length; j++) {
                barrel[j] += barrel[j - 1];
            }
            for (int j = arr.length - 1; j >= 0; j--) {
                d = getDigit(arr[j], i);
                help[barrel[d] -1] = arr[j];
                barrel[d]--;
            }
            for (int j = 0; j < arr.length; j++) {
                arr[j] = help[j];
            }
                    }
    }

    public static int getDigit(int num, int d) {
        return (int) (num / Math.pow(10, d - 1) % 10);
    }

    public static int getMaxDigit(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int digit = 0;
        while (max != 0) {
            max /= 10;
            digit++;
        }
        return digit;
    }


}
