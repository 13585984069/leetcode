package leetcode.zuo.day5.checkPrevious.Binary;

/**
 * @author JJChen
 * @version 1.0
 */
public class findValue {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while(left <= right){
            mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] > target){
                right = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
