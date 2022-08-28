package leetcode.zuo.day5.checkPrevious.Binary;

/**
 * @author JJChen
 * @version 1.0
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {1,2,2,3,3,4,4,5,5};
    }

    public static int solution02(int[] nums, int target){
        return find(nums, target, 0, nums.length - 1 );
    }

    public static int find(int[] nums, int target, int left, int right){
        if(left >= right) return -1;
        int mid = left + (right - left) /2;
        if(nums[mid] < target){
            return find(nums, target, mid + 1, right);
        }else if (nums[mid] > target){
            return find(nums, target, left, mid - 1);
        }else{
            return mid;
        }
    }

}
