package leetcode.zuo.day3.AllSort;

/**
 * @author JJChen
 * @version 1.0
 */
public class RadixSort extends Sort{
    public RadixSort() {
    }

    @Override
    public void sort() {
        if(arr == null || arr.length < 2){
            return;
        }
        int maxDigit = getMaxDigit();
        int[] help = new int[arr.length];
        int digit;
        for (int d = 1; d <= maxDigit; d++) {
            int[] barrel = new  int[10];
            for (int i = 0; i < arr.length; i++) {
                digit = getDigit(arr[i], d);
                barrel[digit]++;
            }
            for (int i = 1; i < barrel.length; i++) {
                barrel[i] += barrel[i-1];
            }
            for (int i = arr.length -1; i >= 0 ; i--) {
                digit = getDigit(arr[i], d);
                help[barrel[digit] -1] = arr[i];
                barrel[digit]--;
            }
            for (int i = 0; i < help.length; i++) {
                arr[i] = help[i];
            }
        }
    }

    public int getDigit(int num, int d){
        return (int)(num / Math.pow(10, d-1) % 10);
    }
    public int getMaxDigit(){
        int max  = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }
        int digit = 0;
        while (max != 0){
            digit++;
            max /=10;
        }
        return digit;
    }
}
