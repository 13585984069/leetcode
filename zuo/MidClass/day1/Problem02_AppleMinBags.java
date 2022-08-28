package leetcode.zuo.MidClass.day1;

/**
 * @author JJChen
 * @version 1.0
 */
public class Problem02_AppleMinBags {

    //https://www.nowcoder.com/questionTerminal/61cfbb2e62104bc8aa3da5d44d38a6ef
    public static int minBags01(int apple){
        if(apple < 0) return 0;
        int bag8 = apple / 8;
        int res = -1;
        for (int i = bag8; i >= 0 ; i--) {
            int rest = apple - i * 8;
            if(rest % 6 == 0){
                res = i + rest / 6;
                break;
            }
        }
        return res;
    }

    // 使用最小公倍数
    public static int minBag02(int apple){
        int bag6 = -1;
        int bag8 = apple / 8;
        int res = -1;
        int rest = apple - bag8 * 8;
        while (bag8 >= 0 && rest < 24){
            int restUse6 = rest % 6 ==0? rest/6:-1;
            if(restUse6 != -1){
                bag6 = restUse6;
                break;
            }
            rest += 8;
            bag8--;
        }
        return bag6 == -1? -1:bag8+bag6;
    }
    // 打表法， 对于输入输出都比较单一的使用
    // 即看输出规律
    public static int minBag03(int apple){
        if((apple & 1)!=0){
            return -1;
        }
        if(apple < 18){
            return apple == 0? 0:(apple == 6|| apple==8)?1:(apple==12||apple==14||apple==16)?2: -1;
        }
        return (apple - 18) / 8 + 3;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            System.out.println("i " +i + "res " + minBags01(i));
        }
    }
}
