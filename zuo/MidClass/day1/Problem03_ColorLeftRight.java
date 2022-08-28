package leetcode.zuo.MidClass.day1;

import leetcode.zuo.day6.M;

import java.util.Arrays;

/**
 * @author JJChen
 * @version 1.0
 */
public class Problem03_ColorLeftRight {
    // 使用前缀和和后缀和来记录
    // RGGRG
    // _ XXXXX 全变成G
    // XX_XXX 前面两位G变R，这时候从后面知道前面有多少个G，需要前缀和， 后面的R变G 从前面需要知道后面有多少个R，后缀和
    // XXXXX_ 前面G变R
    // 那么就准备一个前缀和，一个后缀和
    public static int minPaint(String s){
        if (s == null || s.length() < 2) {
            return 0;
        }
        char[] str = s.toCharArray();
        // 前面的是G变R 那么就计算要改多少个G
        int[] G2R = new int[str.length];
        // G= 1 R = 0;
        G2R[0] = str[0] == 'G'? 1 : 0;
        for (int i = 1; i < str.length; i++) {
            G2R[i] = G2R[i-1]+ (str[i] == 'G'? 1 : 0);
        }
        int[] R2G = new int[str.length];
        R2G[str.length - 1] = str[str.length - 1] == 'R'? 1 : 0;
        for (int i = str.length - 2; i >= 0 ; i--){
            R2G[i] = R2G[i+1]+ (str[i] == 'R'? 1 : 0);
        }

        int res = R2G[0];
//        System.out.println(Arrays.toString(G2R));
//        System.out.println(Arrays.toString(R2G));
        // 从左边有0 个R开始，到所有都是R
        for (int i = 0; i < str.length; i++) {
            if(i == str.length - 1){
                res = Math.min(res, G2R[i]);
//                System.out.println(res);
            }else {
                res = Math.min(res, G2R[i]+R2G[i+1]);
//                System.out.println(res);
            }
        }
        return res;
    }
    public static int minPaint1(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        char[] chs = s.toCharArray();
        int[] right = new int[chs.length];
        right[chs.length - 1] = chs[chs.length - 1] == 'R' ? 1 : 0;
        for (int i = chs.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] + (chs[i] == 'R' ? 1 : 0);
        }
        int res = right[0];
        int left = 0;
        for (int i = 0; i < chs.length - 1; i++) {
            left += chs[i] == 'G' ? 1 : 0;
            res = Math.min(res, left + right[i + 1]);
        }
        res = Math.min(res, left + (chs[chs.length - 1] == 'G' ? 1 : 0));
        return res;
    }
    public static int minPaint2(String str){
        int len = str.length();// 获取字符串长度
        char[] s = str.toCharArray();
        int gCount = 0;// 字符串中G字母的个数
        int count = 0; // 最小涂色次数
        for(int i = 0; i < len;i++)
        {
            if(s[i] == 'G')
            {
                gCount++;
            }else
            {
                count = Math.min(gCount, count + 1);
            }

        }
        return count;
    }

    public static void main(String[] args) {
        String  s = "GGRRRGGGR";
        System.out.println(minPaint2(s));
        System.out.println(minPaint1(s));
//        System.out.println(minPaint1(str));
//        System.out.println(minPaint2(str));
//        int i = minPaint(str);
//        System.out.println(i);
        for (int i = 0; i < 10000; i++) {
            String str = generator(20);
            if(minPaint2(str) != minPaint1(str)){
                System.out.println(str);
                System.out.println(minPaint1(str));
                System.out.println(minPaint2(str));
                System.out.println("错");
                return;
            }
        }
        System.out.println("对");

    }
    public static String generator(int MaxLen){
        StringBuffer sb = new StringBuffer();
        int len = (int)(Math.random()*(MaxLen + 1));
        for (int i = 0; i < len; i++) {
           int val = (int)(Math.random() *(2));
           sb.append(val==1?"R":"G");
        }
        return sb.toString();
    }
}
