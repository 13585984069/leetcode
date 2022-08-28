package leetcode.zuo.day1.practice1;


import java.util.Arrays;

/**
 * @author JJChen
 * @version 1.0
 */
public class BSProblems {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 3, 3, 5, 6, 7, 7, 8, 11, 12, 13, 31};
        System.out.println(BSexist(arr, 31));
        System.out.println(FindOneLessValueIndex(arr, 3));
        int[] arr2 =   {6, 5, 3, 4, 6, 7, 8 };
        System.out.println(findLocalityLeastValue(arr2));
    }


    public static int[] generator(int size, int value){
        int[] arr = new int[(int)((1+size)*Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)((1+value)*Math.random() - (1+value)*Math.random());
        }
        return arr;
    }


    public static boolean BSexist(int[] arr, int num) {
        if (arr == null || arr.length == 0) return false;
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (arr[mid] < num) {
                left = mid + 1;
            } else if (arr[mid] > num) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static int FindOneLessValueIndex(int[] arr, int num) {
        if (arr == null || arr.length == 0) return -1;
        int left = 0;
        int right = arr.length - 1;
        int pos = -1;
        int mid = 0;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (arr[mid] >= num) {
                right = mid - 1;
                pos = mid;
            } else {
                left = mid + 1;
            }
        }
        return pos;
    }

    public static int findLocalityLeastValue(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        if (arr[0] < arr[1]) return 0;
        if (arr[arr.length - 1] < arr[arr.length - 2]) return arr.length - 1;
        int left = 1;
        int right = arr.length - 2;
        while (left <= right){
            int mid = left + ((right - left) >> 1);
            if (arr[mid] > arr[mid + 1]){
                left = mid + 1;
            }else if (arr[mid] > arr[mid - 1 ]){
                right = mid - 1;
            }else{
                return mid;
            }
        }
        return left;
    }
}
