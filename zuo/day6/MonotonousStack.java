package leetcode.zuo.day6;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author JJChen
 * @version 1.0
 */
public class MonotonousStack {
    // 求最近比自己大的值
    public static int[][] getNearMoreRepeat(int[] arr){
        int[][] res = new int[arr.length][2];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek() < arr[i]){
                int temp = stack.pop();
                res[temp][1] = i;
                if(stack.isEmpty()){
                    res[temp][0] = -1;
                }else {
                    res[temp][0] = stack.peek();
                }
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int temp = stack.pop();
            int moreIndex = stack.isEmpty()? -1:stack.peek();
            res[temp][0] = moreIndex;
            res[temp][1] = -1;
        }
        return res;
    }
    
    public static int[][] getNearLess(int[] arr){
        int[][] res = new int[arr.length][2];
        Stack<List<Integer>> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]){
                List<Integer> more = stack.pop();
                int lessIndex = stack.isEmpty()?-1:stack.peek().get(stack.peek().size() -1);
                for(Integer pos:more){
                    res[pos][0] = lessIndex;
                    res[pos][1] = i;
                }
            }
            if(!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]){
                stack.peek().add(i);
            }else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }
        while (!stack.isEmpty()){
            List<Integer> nums = stack.pop();
            int lessIndex = stack.isEmpty()? -1 :stack.peek().get(stack.peek().size() -1);
            for(Integer num:nums){
                res[num][0] = lessIndex;
                res[num][1] = -1;
            }

        }
        return res;
    }
}
