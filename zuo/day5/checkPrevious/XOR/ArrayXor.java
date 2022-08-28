package leetcode.zuo.day5.checkPrevious.XOR;

/**
 * @author JJChen
 * @version 1.0
 */
public class ArrayXor {
    public static void main(String[] args) {
        System.out.println(xorOperation(5,0));
    }
    public static int xorOperation(int n, int start) {
        int res = 0;
        for(int i = 0; i < n ;i++){
            res ^= (start + 2 * i);
        }
        return res;
    }
}
