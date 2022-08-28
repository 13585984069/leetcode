package leetcode.zuo.day6;

/**
 * @author JJChen
 * @version 1.0
 */
public class Manacher {
    public static char[] manacherString(String str){
        char[] arr = str.toCharArray();
        char[] res = new char[arr.length * 2 + 1];
        int index = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = ((i & 1) == 1)? arr[index++]:'#';
        }
        return res;
    }
    public static int maxLength(String str){
        if(str == null || str.length() == 0){
            return 0;
        }
        char[] charArr = manacherString(str);
        int[] pArr = new int[charArr.length];
        System.out.println(charArr);
        int C = -1;
        int R = -1;
        int max = -1;
        for (int i = 0; i < charArr.length; i++) {
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i):1;
            while (i+pArr[i] < charArr.length && i -pArr[i] >-1){
                if(charArr[i+pArr[i]] == charArr[i-pArr[i]]){
                    pArr[i]++;
                }else {
                    break;
                }
            }
            if(i+pArr[i] > R){
                R = i+pArr[i];
                C = i;
            }
            max = Math.max(max, pArr[i]);
        }
        return max -1 ;

    }

    public static void main(String[] args) {
        String str1 = "aacabdkacaa";
        System.out.println(maxLength(str1));
    }
}
