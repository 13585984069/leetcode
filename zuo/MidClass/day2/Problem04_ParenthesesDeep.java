package leetcode.zuo.MidClass.day2;

/**
 * @author JJChen
 * @version 1.0
 */
public class Problem04_ParenthesesDeep {
    public static boolean isValid(String s){
        char[] str = s.toCharArray();
        int count =0;
        for(int i= 0; i < str.length; i++){
            if(str[i] =='('){
                count++;
            }else{
                count--;
            }
            if(count < 0) return false;
        }
        return count==0;
    }
    public static int deep(String s) {
        char[] str = s.toCharArray();
        if (!isValid(s)) {
            return 0;
        }
        int count = 0;
        int max = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '(') {
                max = Math.max(max, ++count);
            } else {
                count--;
            }
        }
        return max;
    }
}
