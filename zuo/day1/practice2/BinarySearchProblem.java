package leetcode.zuo.day1.practice2;

/**
 * @author JJChen
 * @version 1.0
 */
public class BinarySearchProblem {
    public static void main(String[] args) {
//        int[] arr = {1, 1, 2, 2, 2, 3, 3, 5, 6, 7, 7, 8, 11, 12, 13, 31};
//        System.out.println(exist(arr, 3));
        int[] arr = {1,2,3};
        System.out.println(findLeftLeastValue(arr, 3));
    }

    public static boolean exist(int[] arr, int num){
        int left = 0;
        int right = arr.length -1 ;
        int mid = -1;
        while(left < right){
            mid = left + ((right - left) >> 1);
            if(arr[mid] > num){
                right = mid - 1;
            }else if(arr[mid] < num){
                left = mid + 1;
            }else {
                return true;
            }
        }
        return arr[left] == num;
    }

    public static int findLeftLeastValue(int[] arr, int num){
        int left = 0;
        int right = arr.length - 1 ;
        int mid;
        int pos = -1;
        while(left <= right){
            mid = left +  ((right - left) >> 1);
            if (arr[mid] >= num){
                right = mid - 1;
                pos = mid;
            }else {
                left = mid + 1;
            }
        }
        return pos;
    }
    
    public static int findLocalityLeastValue(int[] arr){
        if(arr == null || arr.length == 0) return -1;
        if(arr.length == 1 || arr[0] < arr[1]){
            return 0;
        }
        if(arr[arr.length - 1 ]< arr[arr.length - 2]){
            return arr.length - 1;
        }
        int left = 1;
        int right = arr.length - 2;
        int mid = 0;
        while(left <= right){
            mid = left + ((right - left) >> 1);
            if (arr[mid] > arr[mid - 1]){
                right = mid - 1;
            }else if(arr[mid] > arr[mid + 1]){
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return mid;
    }
}
