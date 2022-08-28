package leetcode.zuo.MidClass.day1;

import java.util.Arrays;

/**
 * @author JJChen
 * @version 1.0
 */
public class Problem04_MaxOneBorderSize {
    public static int largest1BorderedSquare(int[][] grid) {
       int row = grid.length;
       int col = grid[0].length;
       // +1 可以省去初始条件的if
        // 每行出现1的前缀和
       int[][] rowSum = new int[row][col + 1];
       int[][] colSum = new int[row + 1][col];
       // 使用左上角
        for (int i = row - 1; i >= 0 ; i--) {
            for (int j = col - 1; j >= 0 ; j--) {
                rowSum[i][j] = grid[i][j] == 1? rowSum[i][j+1] + 1 :0;
                colSum[i][j] = grid[i][j] == 1? colSum[i+1][j] + 1:0;
            }
        }

        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j] == 1){
                    int idx = Math.min(rowSum[i][j], colSum[i][j]);
                    for (int k = idx; k > 0; k--) {
                        if(res >= k){
                            break;
                        }
                        if(colSum[i][j+k-1] >= k && rowSum[i+k-1][j] >=k){
                            res = k;
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] ints = new int[][]{{0,1,1,1,1},{0,1,0,0,1},{0,1,0,0,1},{0,1,1,1,1},{0,1,0,1,1}};
        int i = largest1BorderedSquare(ints);
        System.out.println(i);
    }
    public static void print(int[][] nums){
        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(nums[i]));
        }
    }
}
