package leetcode.zuo.day1;

import java.util.Arrays;

/**
 * @author JJChen
 * @version 1.0
 */
public class BinarySearchProblems {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 3, 3, 5, 6, 7, 7, 8, 11, 12, 13, 31};
//        ArraySort.selectSort(arr);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(exist(arr, 3));
//        System.out.println(findLeft(arr, 31));
        int[] arr2 =   {6, 5, 3, 4, 6, 7, 8 };
        System.out.println(findLocalityLeastValue(arr2));

    }

    // 在一个有序数组中，找某个数是否存在
    public static boolean exist(int[] arr, int num) {
        if (arr == null || arr.length < 1) return false;
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (num > arr[mid]) {
                left = mid + 1;
            } else if (num < arr[mid]) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    // 在一个有序数组中， 找>=某个数最左侧的位置
    public static int findLeft(int[] arr, int num) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        int position = -1;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (arr[mid] >= num) {
                position = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return position;
    }

    // 找出一个局部最小值, 无序数列
    public static int findLocalityLeastValue(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        int left = 1;
        int right = arr.length - 2;
        int mid = 0;
        while (left < right){
            mid = left + ((right - left) >> 1);
            if (arr[mid] > arr[mid - 1]){
                right = mid - 1;
            }else if (arr[mid] > arr[mid + 1]){
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return left;
    }
}
