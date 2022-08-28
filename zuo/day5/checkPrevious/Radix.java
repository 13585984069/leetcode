package leetcode.zuo.day5.checkPrevious;

import java.util.Arrays;

/**
 * @author JJChen
 * @version 1.0
 */
public class Radix {
    public static void main(String[] args) {
        String res = solution05("tree");
        System.out.println(res);
    }


    public static String solution05(String s) {
        if (s == null) return s;
        char[] chars = s.toCharArray();
        System.out.println(chars);
        int[] help = new int[128];
        for (char c : chars) {
            help[c]++;
        }
        System.out.println(Arrays.toString(help));
        int cur = 0;
        char c = 0;
        while (cur < chars.length) {
            int max = 0;
            for (int i = 0; i < help.length; i++) {
                max = help[max] > help[i]? max: i;
            }
            c = (char) max;
            for (int i = 0; i < help[max]; i++) {
                chars[cur + i] = c;
            }
            cur += help[max];
            help[max] = 0;
        }
        return new String(chars);
    }
}
