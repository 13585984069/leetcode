package leetcode.zuo.MidClass.day2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author JJChen
 * @version 1.0
 */
public class Problem01_SubvalueEqualK {
    public static int solution01(int[] nums, int k){
        HashSet<Integer> res = new HashSet<>();
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(visited.contains(nums[i] + k)){
                res.add(nums[i]);
            }
            if(visited.contains(nums[i] - k)){
                res.add(nums[i] - k);
            }
            visited.add(nums[i]);
        }
        return res.size();
    }
    public static int solution02(int[] nums, int k){
        Arrays.sort(nums);
        int y = 0;
        int res = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if(i == 0 || nums[i] != nums[i-1]){
                while (y < len && (y <= i || nums[y] <nums[i] + k)){
                    y++;
                }
                if(y < len && (nums[y] == nums[i] + k)){
                    res++;
                }
            }
        }
        return res;
    }
    public static int[] generator(int MaxSize, int MaxVal){
        int[] nums = new int[(int) (Math.random() * (MaxSize + 1))];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int)(Math.random()*(MaxVal+1));
        }
        return nums;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int maxSize = 100;
            int maxValue = 100;
            int[] nums = generator(maxSize, maxValue);
            int k = (int)(Math.random() * (maxValue /2));
            if(solution01(nums, k) != solution02(nums, k)){
                System.out.println("错了");
                return;
            }
        }
        System.out.println("对");
    }
}
