package leetcode.zuo.MidClass.day1;

/**
 * @author JJChen
 * @version 1.0
 */
public class Problem05_Rand5ToRand7 {
    // 随机概率发生器
    public static int rand1To5(){
        return (int)(Math.random() * 5 + 1);
    }

    // 计算6 有几位  3个2进制  再+ 1
    public static int rand1To7(){
        int res =   rand0To1() << 2+ rand0To1()<<1+ rand0To1();
        if(res == 7){
            return rand1To7();
        }
        return res + 1;
    }

    public static int rand0To1(){
        int a = rand1To5();
        if(a == 1 || a == 2){
            return 0;
        }
        if(a == 3 || a == 4){
            return  1;
        }
        return rand0To1();
    }
}
