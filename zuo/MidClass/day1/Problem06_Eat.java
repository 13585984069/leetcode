package leetcode.zuo.MidClass.day1;

/**
 * @author JJChen
 * @version 1.0
 */
public class Problem06_Eat {
    public static String eat(int num){
        if(num < 5){
            return num == 1 || num == 3 || num ==4 ?"先手":"后手";
        }
        int grass = 1;
        while (grass <= num){
            if(eat(num - grass).equals("后手")){
                return "先手";
            }
            grass *= 4;
        }
        return "后手";
    }
    // 先手0号位 后手1号位
    public static String eat3(int num){
        if(num < 5){
            return num == 1 || num == 3 || num ==4 ?"先手":"后手";
        }
        int[][] dp = new int[num+1][2];
        dp[0][0] = 0;
        dp[0][1] = 1;
        dp[1][0] = 1;
        dp[1][1] = 0;
        dp[2][0] = 0;
        dp[2][1] = 1;
        dp[3][0] = 1;
        dp[3][1] = 0;
        dp[4][0] = 1;
        dp[4][1] = 0;
        for (int i = 5; i <= num; i++) {
            boolean flag = false;
            int temp = 1;
            while (temp <= i){
                if(dp[i - temp][1] == 1){
                    dp[i][0] = 1;
                    dp[i][1] = 0;
                    flag = true;
                    break;
                }
                temp *= 4;
            }
            if(!flag){
                dp[i][0] = 0;
                dp[i][1] = 1;
            }
        }
//
        return dp[num][0] == 1? "先手":"后手";
    }


    public static String eat2(int num){
        if(num % 5 == 0 || num % 5 == 2){
            return "后手";
        }
        return "先手";
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            if(!eat(i).equals(eat2(i)) || !eat(i).equals(eat3(i))) {
                System.out.println(eat(i));
                System.out.println(i);
                System.out.println(eat3(i));
                System.out.println("错");
                return;
            }

        }
        System.out.println("对");
    }
}
