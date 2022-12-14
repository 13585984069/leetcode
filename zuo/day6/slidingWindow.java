package leetcode.zuo.day6;

import java.util.LinkedList;

/**
 * @author JJChen
 * @version 1.0
 */
public class slidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            while(!list.isEmpty() && nums[list.peekLast()] <= nums[i]){
                list.pollLast();
            }
            list.add(i);
            if(list.peek() == (i - k)){
                list.poll();
            }
            if(i >= k - 1){
                res[index++] = nums[list.peekFirst()];
            }
        }
        return res;
    }

}
