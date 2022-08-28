package leetcode.zuo.day5.checkPrevious.Binary;

/**
 * @author JJChen
 * @version 1.0
 */
public class LocalSmall {
    public static void main(String[] args) {
        int[] arr = {5,3,4,1,5,9};
        System.out.println(localSmall(arr));
    }

    public static int localSmall(int[] arr){
        if(arr == null || arr.length == 0) return -1;
        if(arr.length < 2 || arr[0] < arr[1]){
            return 0;
        }
        if(arr[arr.length - 1] < arr[arr.length -2]){
            return arr.length - 1;
        }
        int left = 1;
        int right = arr.length -2;
        int mid = 0;
        while(left <= right){
            mid = left + (right - left)/2;
            if(arr[mid] > arr[mid - 1]){
                right = mid -1;
            }else if(arr[mid] > arr[mid + 1]){
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return mid;
    }
}
