package leetcode.zuo.day5.checkPrevious.Sort;

/**
 * @author JJChen
 * @version 1.0
 */
public class RadixSort {
    public static void sort(int[] arr){
        if(arr == null || arr.length < 2) return;
        int maxDigit = getMaxDigit(arr);
        int curDigit = -1;
        int[] help = new int[arr.length];
        for (int i = 1; i <= maxDigit; i++) {
            int[] barrels = new int[10];
            for (int j = 0; j < arr.length; j++) {
                curDigit = getCurDigit(arr[j], i);
                barrels[curDigit]++;
            }
            for (int j = 1; j < barrels.length; j++) {
                barrels[j] += barrels[j-1];
            }
            for (int j = arr.length - 1; j >=0 ; j--) {
                curDigit = getCurDigit(arr[j],i);
                help[--barrels[curDigit]] = arr[j];
            }
            for (int j = 0; j < help.length; j++) {
                arr[j] = help[j];
            }
        }
    }
    public static int getCurDigit(int num, int d){
        return num / (int)(Math.pow(10, d- 1)) % 10;
    }

    public static  int getMaxDigit(int[] arr){
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int digit = 0;
        while(max != 0){
            max /= 10;
            digit++;
        }
        return digit;
    }

}
