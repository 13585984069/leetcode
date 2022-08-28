package leetcode.zuo.MidClass.day1;

/**
 * @author JJChen
 * @version 1.0
 */
public class Problem06_UniqueBST {
    public static int numTrees(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        int res = 0;
        for (int leftNum = 0; leftNum <= n-1; leftNum++) {
            int leftWays = numTrees(leftNum);
            int rightWays = numTrees(n - 1- leftNum);
            res += leftWays * rightWays;
        }
        return res;
    }

    public static int tree(int num){
        if(num < 2) return 1;
        int[] dp = new int[num + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < num + 1; i++) {
            for (int j = 0; j < i ; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[num];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(5));
        System.out.println(numTrees1(5));
        System.out.println(tree(5));
    }
    public static int numTrees1(int n) {
        if (n < 2) {
            return 1;
        }
        int[] num = new int[n + 1];
        num[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                num[i] += num[j - 1] * num[i - j];
            }
        }
        return num[n];
    }
}
