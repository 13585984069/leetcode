package leetcode.zuo.day6;

/**
 * @author JJChen
 * @version 1.0
 */
public class KMP {
    public static int getIndexOf(String s, String m){
        if(s==null || m==null || m.length() > s.length()){
            return -1;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getNextArray(str2);
        while (i1 < str1.length && i2 < str2.length){
            if(str1[i1] == str2[i2]){
                i1++;
                i2++;
            }else if(next[i2] == -1){
                i1++;
            }else{
                i2 = next[i2]; // next数组里面的数，即是后面next后面数的下标，也表示有多少个最大前缀后缀
            }
        }
        return i2 == str2.length? i1 - i2: - 1;
    }

    public static int[] getNextArray(char[] str){
        if(str.length == 1){
            return new int[]{-1};
        }
        int[] next = new int[str.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int mark = 0;
        while (i < next.length){
            if(str[i - 1] == str[next[i]]){
//                mark++;
//                next[i] = mark;
//                i++;
                next[i++] = ++mark;
            } else if(mark > 0){
                mark = next[mark];
            }else {
                next[i++] = 0;
            }
        }
        return  next;
    }

    public static void main(String[] args) {
        String str = "mississippi";
        String match = "issip";
        System.out.println(getIndexOf(str, match));
    }
}
