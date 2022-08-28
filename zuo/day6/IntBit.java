package leetcode.zuo.day6;

/**
 * @author JJChen
 * @version 1.0
 */
public class IntBit {
    public static void main(String[] args) {
        int a = 0;
        int[] arr = new int[10]; // 32bit * 10 = 320bits
        int i = 178;
        int numIndex = 178 / 32;
        int bitIndex = 178 % 32;
        // 获取178位的状态
        int s = (arr[numIndex] >> bitIndex) & 1;
        // 改成1状态
        arr[numIndex] =arr[numIndex] | (1<< bitIndex);
//        改成0
        arr[numIndex] =arr[numIndex] & (~(1<< bitIndex));
    }
}
